package com.github.hardes1.taskmavenartifacts.util

private const val PREFIX_HASH_MAP = "HashMap"
private const val PREFIX_HASH_SET = "HashSet"
private const val PREFIX_HASH_TABLE = "HashTable"
private const val PREFIX_ARRAY_LIST = "ArrayList"
private const val PREFIX_PRIMITIVE_ARRAY = "PrimitiveArray"
private const val PREFIX_QUEUE = "Queue"
private const val PREFIX_LINKED_LIST = "LinkedList"

abstract class ImplicitTestType(pathName: String) : TestType(pathName) {
    class HashMap : ImplicitTestType(PREFIX_HASH_MAP)
    class HashSet : ImplicitTestType(PREFIX_HASH_SET)
    class HashTable : ImplicitTestType(PREFIX_HASH_TABLE)
    class ArrayList : ImplicitTestType(PREFIX_ARRAY_LIST)
    class PrimitiveArray : ImplicitTestType(PREFIX_PRIMITIVE_ARRAY)
    class Queue : ImplicitTestType(PREFIX_QUEUE)
    class LinkedList : ImplicitTestType(PREFIX_LINKED_LIST)
}