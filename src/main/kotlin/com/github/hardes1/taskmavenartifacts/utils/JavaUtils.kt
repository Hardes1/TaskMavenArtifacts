package com.github.hardes1.taskmavenartifacts.utils

import com.intellij.psi.PsiType

object JavaUtils {
    private val collectionInterfaces = arrayOf(
        "java.util.Collection",
        "java.util.Map",
        "[]"
    )

    fun isTypeACollection(superTypes: Array<PsiType>): Boolean {
        var result = false
        for (i in collectionInterfaces.indices) {
            result = result or superTypes.any {
                if (i != collectionInterfaces.lastIndex) {
                    it.canonicalText.startsWith(collectionInterfaces[i])
                } else {
                    it.canonicalText.endsWith(collectionInterfaces[i])
                }
            }
        }
        return result
    }

    fun isReferenceNameContainsURL(canonicalName: String): Boolean {
        val trimmedName =
            if (canonicalName.endsWith(">"))
                canonicalName.dropWhile { it != '<' }.dropLastWhile { it != '>' }.drop(1).dropLast(1)
            else canonicalName
        var bracketBalance = 0
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