package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.github.hardes1.taskmavenartifacts.JavaUtils
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiDeclarationStatement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiTypeElement
import com.intellij.psi.util.childrenOfType

class URLHashCodeDataStructureJavaInspection : AbstractBaseJavaLocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : JavaElementVisitor() {
            override fun visitDeclarationStatement(statement: PsiDeclarationStatement?) {
                super.visitDeclarationStatement(statement)
                val statementChild = statement?.firstChild ?: return
                val type = statementChild.childrenOfType<PsiTypeElement>().singleOrNull()?.type ?: return
                if (JavaUtils.isTypeACollection(type.superTypes) && JavaUtils.isReferenceNameContainsURL(type.canonicalText)) {
                    statement.let {
                        holder.registerProblem(
                            it,
                            InspectionBundle.getMessage("inspection.URL.call.hashcode.data.structure")
                        )
                    }
                }
            }
        }
    }
}