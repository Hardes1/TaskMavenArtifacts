package com.github.hardes1.taskmavenartifacts.util


private const val PREFIX_REFERENCE = "Reference"
private const val PREFIX_TEMPORARY = "Temporary"
private const val SUFFIX_SIMPLE_NAME = "SimpleName"
private const val SUFFIX_FULL_NAME = "FullName"
private const val PREFIX_AS_FIELD = "AsField"
private const val PREFIX_COMBINED = "Combined"


abstract class ExplicitTestType(pathName: String) : TestType(pathName) {
    class ReferenceSimple : ExplicitTestType("$PREFIX_REFERENCE$SUFFIX_SIMPLE_NAME")
    class ReferenceFull : ExplicitTestType("$PREFIX_REFERENCE$SUFFIX_FULL_NAME")
    class TemporarySimple : ExplicitTestType("$PREFIX_TEMPORARY$SUFFIX_SIMPLE_NAME")
    class TemporaryFull : ExplicitTestType("$PREFIX_TEMPORARY$SUFFIX_FULL_NAME")
    class AsFieldSimple : ExplicitTestType("$PREFIX_AS_FIELD$SUFFIX_SIMPLE_NAME")
    class AsFieldFull : ExplicitTestType("$PREFIX_AS_FIELD$SUFFIX_FULL_NAME")
    class Combined : ExplicitTestType(PREFIX_COMBINED)
}