package com.github.hardes1.taskmavenartifacts.util

private const val PREFIX_REFERENCE = "Reference"
private const val PREFIX_TEMPORARY = "Temporary"
private const val SUFFIX_SIMPLE_NAME = "SimpleName"
private const val SUFFIX_FULL_NAME = "FullName"
private const val PREFIX_AS_FIELD = "AsField"
private const val PREFIX_COMBINED = "Combined"
enum class TestType(val pathName: String) {
    REFERENCE_SIMPLE("$PREFIX_REFERENCE$SUFFIX_SIMPLE_NAME"),
    REFERENCE_FULL("$PREFIX_REFERENCE$SUFFIX_FULL_NAME"),
    TEMPORARY_SIMPLE("$PREFIX_TEMPORARY$SUFFIX_SIMPLE_NAME"),
    TEMPORARY_FULL("$PREFIX_TEMPORARY$SUFFIX_FULL_NAME"),
    AS_FIELD_SIMPLE("$PREFIX_AS_FIELD$SUFFIX_SIMPLE_NAME"),
    AS_FIELD_FULL("$PREFIX_AS_FIELD$SUFFIX_FULL_NAME"),
    COMBINED(PREFIX_COMBINED),
}