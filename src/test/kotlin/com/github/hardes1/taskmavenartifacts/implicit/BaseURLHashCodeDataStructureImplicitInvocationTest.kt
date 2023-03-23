package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeImplicitInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.*
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

abstract class BaseURLHashCodeDataStructureImplicitInvocationTest(private val type: FileExtension) :
    LightJavaCodeInsightFixtureTestCase(),
    TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, type)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeImplicitInvocationInspection::class.java)
        addClasses()
    }

    private fun addClasses() {
        myFixture.addClass("package java.net; public final class URL {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.lang; public class Integer {}")
        myFixture.addClass("package java.util; public class HashMap<K, V> extends Map<K, V>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class Hashtable<K, V> extends Map<K, V>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class HashSet<K> extends Collection<K>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class Queue<K> extends Collection<K>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class ArrayDeque<K> extends Queue<K>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class LinkedList<K> extends Collection<K>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class ArrayList<K> extends Collection<K>{public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class Collection<K> {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.util; public class Map<K, V>{public int hashCode() {return super.hashCode();}}")
    }

    override fun getTestDataPath() = "src/test/testData/${type.name.toLowerCaseAsciiOnly()}/implicit"

    fun testHighlightHashCodeImplicit() {
        testRunner.doTest(ImplicitTestType.Combined())
    }
}