package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.inspections.UrlHashCodeInvocationInspection
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import junit.framework.TestCase

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class UrlHashCodeInspectionJavaTest : LightJavaCodeInsightFixtureTestCase() {
    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(UrlHashCodeInvocationInspection::class.java)
        myFixture.addClass("package java.net; public class URL {@Override public int hashCode() {return super.hashCode();}}")
        // optimization: add a fake java.lang.String class to avoid loading all JDK classes for test

    }

    override fun getTestDataPath() = "src/test/testData/java"

    fun `test Should highlight inside explicit call above object reference`() {
        doExplicitTest("Simple")
    }


    private fun doExplicitTest(name: String) {
        val path = "$name.java"
        myFixture.configureByFile(path)
        val highlightInfos = myFixture.doHighlighting()
        TestCase.assertFalse(highlightInfos.singleOrNull { it.description == InspectionBundle.message("inspection.URL.call.hashcode.explicit") } == null)
        // myFixture.testHighlighting(path)
    }
}