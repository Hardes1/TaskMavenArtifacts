package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.CommonConstants
import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.intellij.codeInspection.AbstractBaseUastLocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.uast.UastHintedVisitorAdapter
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.visitor.AbstractUastNonRecursiveVisitor

private const val HASH_CODE_NAME = "hashCode"

class URLHashCodeExplicitInvocationInspection : AbstractBaseUastLocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return UastHintedVisitorAdapter.create(
            holder.file.language,
            object : AbstractUastNonRecursiveVisitor() {
                override fun visitCallExpression(node: UCallExpression): Boolean {
                    val name = node.methodName ?: return false
                    val classRef = node.receiverType ?: return false
                    if (name == HASH_CODE_NAME && classRef.canonicalText == CommonConstants.URL_CANONICAL_NAME) {
                        node.methodIdentifier?.sourcePsi?.let {
                            holder.registerProblem(
                                it,
                                InspectionBundle.message("inspection.URL.call.hashcode.explicit")
                            )
                        }
                    }
                    return true
                }
            }, arrayOf(UCallExpression::class.java)
        )
    }

}