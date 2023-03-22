package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.KotlinUtils
import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import org.jetbrains.kotlin.idea.inspections.AbstractKotlinInspection
import org.jetbrains.kotlin.nj2k.postProcessing.type
import org.jetbrains.kotlin.psi.propertyVisitor
import org.jetbrains.kotlin.types.typeUtil.supertypes

class URLHashCodeDataStructureKotlinInspection : AbstractKotlinInspection() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return propertyVisitor { property ->
            val type = property.type() ?: return@propertyVisitor
            val arguments = type.arguments
            val superTypes = type.supertypes()
            if (KotlinUtils.isTypeACollection(superTypes + type) && KotlinUtils.isContainsUrlAsTypeProjection(arguments)) {
                holder.registerProblem(
                    property,
                    InspectionBundle.getMessage("inspection.URL.call.hashcode.data.structure")
                )
            }
        }
    }


}

