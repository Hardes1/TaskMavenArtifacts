package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.CommonConstants
import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.github.hardes1.taskmavenartifacts.JavaUtils
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
                    if (
                        isTypeACollection(classRef, collectionTypes)
                        && methodName == CommonConstants.HASH_CODE_NAME
                        && JavaUtils.isReferenceNameContainsURL(classRef.canonicalText)
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


}