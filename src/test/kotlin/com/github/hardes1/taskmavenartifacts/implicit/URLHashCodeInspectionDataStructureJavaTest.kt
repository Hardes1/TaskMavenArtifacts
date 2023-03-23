package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeDataStructureJavaInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.HighlightTestRunner
import com.github.hardes1.taskmavenartifacts.util.TestRunner
import com.github.hardes1.taskmavenartifacts.util.TestRunnerOwner
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class URLHashCodeInspectionDataStructureJavaTest : LightJavaCodeInsightFixtureTestCase(), TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, FileExtension.JAVA)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeDataStructureJavaInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.lang; public class Object {public int hashCode() { return 0;}}")
    }

    fun testHighlightURLArray() {
        // testRunner.doTest()
    }
}