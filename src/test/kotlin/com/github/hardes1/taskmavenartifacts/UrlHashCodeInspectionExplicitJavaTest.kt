package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.inspections.UrlHashCodeInvocationInspection
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import junit.framework.TestCase

private const val PREFIX_REFERENCE = "Reference"
private const val PREFIX_TEMPORARY = "Temporary"
private const val SUFFIX_SIMPLE_NAME = "SimpleName"
private const val SUFFIX_FULL_NAME = "FullName"
private const val PREFIX_AS_FIELD = "AsField"
private const val SINGLE_COUNT = 1


@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class UrlHashCodeInspectionExplicitJavaTest : LightJavaCodeInsightFixtureTestCase() {
    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(UrlHashCodeInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {@Override public int hashCode() {return super.hashCode();}}")
    }

    override fun getTestDataPath() = "src/test/testData/java"

    fun testHighlightReferenceSimpleName() {
        doTest("$PREFIX_REFERENCE$SUFFIX_SIMPLE_NAME", SINGLE_COUNT)
    }

    fun testHighlightReferenceFullName() {
        doTest("$PREFIX_REFERENCE$SUFFIX_FULL_NAME", SINGLE_COUNT)
    }

    fun testHighlightTemporarySimpleName() {
        doTest("$PREFIX_TEMPORARY$SUFFIX_SIMPLE_NAME", SINGLE_COUNT)
    }

    fun testHighlightTemporaryFullName() {
        doTest("$PREFIX_TEMPORARY$SUFFIX_FULL_NAME", SINGLE_COUNT)
    }

    fun testHighlightAsFieldSimpleName() {
        doTest("$PREFIX_AS_FIELD$SUFFIX_SIMPLE_NAME", SINGLE_COUNT)
    }

    fun testHighlightAsFieldFullName() {
        doTest("$PREFIX_AS_FIELD$SUFFIX_FULL_NAME", SINGLE_COUNT)
    }

    fun testHighlightCombined() {
        doTest("Combined", 8)
    }

    private fun doTest(name: String, count: Int) {
        val path = "$name.java"
        myFixture.configureByFile(path)
        val highlightInfos = myFixture.doHighlighting()
        val message = InspectionBundle.getMessage("inspection.URL.call.hashcode.explicit")
        TestCase.assertTrue(
            highlightInfos.count {
                it.description == message
            } == count
        )
    }
}