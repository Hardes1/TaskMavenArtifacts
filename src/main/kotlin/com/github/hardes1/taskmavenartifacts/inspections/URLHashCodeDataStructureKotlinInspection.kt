package com.github.hardes1.taskmavenartifacts.inspections

import com.github.hardes1.taskmavenartifacts.CommonConstants
import com.github.hardes1.taskmavenartifacts.InspectionBundle
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import org.jetbrains.kotlin.idea.inspections.AbstractKotlinInspection
import org.jetbrains.kotlin.js.descriptorUtils.getJetTypeFqName
import org.jetbrains.kotlin.nj2k.postProcessing.type
import org.jetbrains.kotlin.psi.propertyVisitor
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.TypeProjection
import org.jetbrains.kotlin.types.typeUtil.supertypes

class URLHashCodeDataStructureKotlinInspection : AbstractKotlinInspection() {
    private val collectionsInterfaces =
        listOf("kotlin.Array", "kotlin.collections.Collection", "kotlin.collections.Map")

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return propertyVisitor { property ->
            val type = property.type() ?: return@propertyVisitor
            val arguments = type.arguments
            val superTypes = type.supertypes()
            if (isTypeACollection(superTypes + type) && isContainsUrlAsTypeProjection(arguments)) {
                holder.registerProblem(
                    property,
                    InspectionBundle.getMessage("inspection.URL.call.hashcode.data.structure")
                )
            }
        }
    }

    private fun isContainsUrlAsTypeProjection(arguments: List<TypeProjection>): Boolean {
        if (arguments.isEmpty()) {
            return false
        }
        val name = arguments.first().type.getJetTypeFqName(true)
        return name.contains(CommonConstants.URL_CANONICAL_NAME)
    }

    private fun isTypeACollection(superTypes: Collection<KotlinType>) =
        superTypes.any { it.getJetTypeFqName(false) in collectionsInterfaces }
}

