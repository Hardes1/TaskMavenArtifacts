package com.github.hardes1.taskmavenartifacts.utils

import org.jetbrains.kotlin.js.descriptorUtils.getJetTypeFqName
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.TypeProjection

object KotlinUtils {
    private val collectionsInterfaces =
        listOf("kotlin.Array", "kotlin.collections.Collection", "kotlin.collections.Map")

    fun isContainsUrlAsTypeProjection(arguments: List<TypeProjection>): Boolean {
        if (arguments.isEmpty()) {
            return false
        }
        val name = arguments.first().type.getJetTypeFqName(true)
        return name.contains(CommonConstants.URL_CANONICAL_NAME)
    }

    fun isTypeACollection(superTypes: Collection<KotlinType>) =
        superTypes.any { it.getJetTypeFqName(false) in collectionsInterfaces }
}