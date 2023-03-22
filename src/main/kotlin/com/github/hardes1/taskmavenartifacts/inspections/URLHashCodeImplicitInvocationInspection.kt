package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.CommonConstants
import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.intellij.codeInspection.AbstractBaseUastLocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiType
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.uast.UastHintedVisitorAdapter
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.visitor.AbstractUastNonRecursiveVisitor

class URLHashCodeImplicitInvocationInspection : AbstractBaseUastLocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        val project = holder.project
        val collectionTypes = listOf(
            PsiType.getTypeByName("java.util.Collection", project, GlobalSearchScope.allScope(project)),
            PsiType.getTypeByName("java.util.Map", project, GlobalSearchScope.allScope(project))
        )
        return UastHintedVisitorAdapter.create(
            holder.file.language,
            object : AbstractUastNonRecursiveVisitor() {
                override fun visitCallExpression(node: UCallExpression): Boolean {
                    val methodName = node.methodName ?: return false
                    val classRef = node.receiverType ?: return false
                    println(classRef.canonicalText)
                    if (
                        isTypeACollection(classRef, collectionTypes)
                        && methodName == CommonConstants.HASH_CODE_NAME
                        && isReferenceNameContainsURL(classRef.canonicalText)
                    ) {
                        node.methodIdentifier?.sourcePsi?.let {
                            holder.registerProblem(
                                it,
                                InspectionBundle.getMessage("inspection.URL.call.hashcode.data.implicit")
                            )
                        }
                    }
                    return true
                }
            }, arrayOf(UCallExpression::class.java)
        )
    }

    private fun isTypeACollection(classRef: PsiType, collectionTypes: Collection<PsiType>): Boolean {
        return collectionTypes.any { it.isAssignableFrom(classRef) } || classRef.canonicalText.endsWith("[]")
    }

    private fun isReferenceNameContainsURL(canonicalName: String): Boolean {
        val trimmedName =
            if (canonicalName.endsWith(">"))
                canonicalName.dropWhile { it != '<' }.dropLastWhile { it != '>' }.drop(1).dropLast(1)
            else canonicalName
        var bracketBalance = 0
        println(trimmedName)
        for (i in trimmedName.indices) {
            if (trimmedName[i] == '<') {
                bracketBalance++
            } else if (trimmedName[i] == '>') {
                bracketBalance--
            } else if (trimmedName[i] == ',' && bracketBalance == 0) {
                return trimmedName.take(i + 1).contains(CommonConstants.URL_CANONICAL_NAME)
            }
        }
        return trimmedName.contains(CommonConstants.URL_CANONICAL_NAME)
    }
}