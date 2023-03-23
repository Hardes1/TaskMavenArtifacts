package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeDataStructureJavaInspection
import com.github.hardes1.taskmavenartifacts.util.*
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class URLHashCodeInspectionDataStructureJavaTest : LightJavaCodeInsightFixtureTestCase(), TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, FileExtension.JAVA)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeDataStructureJavaInspection::class.java)
        addClasses()
    }

    private fun addClasses() {
        myFixture.addClass("package java.net; public final class URL {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.lang; public class Integer {}")
        myFixture.addClass("package java.util; public class HashMap<K, V> extends Map<K, V>{}")
        myFixture.addClass("package java.util; public class Hashtable<K, V> extends Map<K, V>{}")
        myFixture.addClass("package java.util; public class HashSet<K> extends Collection<K>{}")
        myFixture.addClass("package java.util; public class Queue<K> extends Collection<K>{}")
        myFixture.addClass("package java.util; public class LinkedList<K> extends Collection<K>{}")
        myFixture.addClass("package java.util; public class ArrayList<K> extends Collection<K>{}")
        myFixture.addClass("package java.util; public class Collection<K> {}")
        myFixture.addClass("package java.util; public class Map<K, V>{}")
    }

    override fun getTestDataPath() = "src/test/testData/java/implicit"

    fun testHighlightURLHashMap() {
        testRunner.doTest(ImplicitTestType.HashMap())
    }

    fun testHighlightURLHashSet() {
        testRunner.doTest(ImplicitTestType.HashSet())
    }

    fun testHighlightURLHashTable() {
        testRunner.doTest(ImplicitTestType.HashTable())
    }

    fun testHighlightURLArrayList() {
        testRunner.doTest(ImplicitTestType.ArrayList())
    }

    fun testHighlightPrimitiveArray() {
        testRunner.doTest(ImplicitTestType.PrimitiveArray())
    }

    fun testHighlightQueue() {
        testRunner.doTest(ImplicitTestType.Queue())
    }

    fun testHighlightLinkedList() {
        testRunner.doTest(ImplicitTestType.LinkedList())
    }
}