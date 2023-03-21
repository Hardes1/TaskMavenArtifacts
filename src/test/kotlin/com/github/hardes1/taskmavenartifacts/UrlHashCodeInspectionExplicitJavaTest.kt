package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.inspections.UrlHashCodeInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase


@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class UrlHashCodeInspectionExplicitJavaTest : LightJavaCodeInsightFixtureTestCase() {
    private lateinit var testRunner: TestRunner

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(UrlHashCodeInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {@Override public int hashCode() {return super.hashCode();}}")
        testRunner = TestRunner(myFixture, FileExtension.JAVA)
    }

    override fun getTestDataPath() = "src/test/testData/java"

    fun testHighlightReferenceSimpleName() {
        testRunner.doTest(TestType.REFERENCE_SIMPLE, 1)
    }

    fun testHighlightReferenceFullName() {
        testRunner.doTest(TestType.REFERENCE_FULL, 1)
    }

    fun testHighlightTemporarySimpleName() {
        testRunner.doTest(TestType.TEMPORARY_SIMPLE, 1)
    }

    fun testHighlightTemporaryFullName() {
        testRunner.doTest(TestType.TEMPORARY_FULL, 1)
    }

    fun testHighlightAsFieldSimpleName() {
        testRunner.doTest(TestType.AS_FIELD_SIMPLE, 1)
    }

    fun testHighlightAsFieldFullName() {
        testRunner.doTest(TestType.AS_FIELD_FULL, 1)
    }

    fun testHighlightCombined() {
        testRunner.doTest(TestType.COMBINED, 8)

    }
}