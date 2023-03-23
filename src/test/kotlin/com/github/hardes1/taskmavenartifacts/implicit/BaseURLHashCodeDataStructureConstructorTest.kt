package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.util.*
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

abstract class BaseURLHashCodeDataStructureConstructorTest(
    private val inspectionClass: Class<out LocalInspectionTool>,
    private val extension: FileExtension
) :
    LightJavaCodeInsightFixtureTestCase(), TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, extension)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(inspectionClass)
        addClasses()
    }

    override fun getTestDataPath() = "src/test/testData/${extension.name.toLowerCaseAsciiOnly()}/implicit"

    private fun addClasses() {
        myFixture.addClass("package java.lang; public class Object {public int hashCode() { return 0;}}")
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