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
        val collectionElement =
            PsiType.getTypeByName("java.util.Collection", project, GlobalSearchScope.allScope(project))
        val mapElement = PsiType.getTypeByName("java.util.Map", project, GlobalSearchScope.allScope(project))
        return UastHintedVisitorAdapter.create(
            holder.file.language,
            object : AbstractUastNonRecursiveVisitor() {
                override fun visitCallExpression(node: UCallExpression): Boolean {
                    val methodName = node.methodName ?: return false
                    val classRef = node.receiverType ?: return false
                    println(classRef.canonicalText)
                    if (
                        (collectionElement.isAssignableFrom(classRef) || mapElement.isAssignableFrom(classRef))
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

    private fun isReferenceNameContainsURL(canonicalName: String): Boolean {
        val trimmedName = canonicalName.dropWhile { it != '<' }.dropLastWhile { it != '>' }.dropLast(1).drop(1)
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