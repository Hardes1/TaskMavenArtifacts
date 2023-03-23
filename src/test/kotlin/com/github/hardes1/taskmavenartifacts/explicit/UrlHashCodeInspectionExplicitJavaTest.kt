package com.github.hardes1.taskmavenartifacts.explicit

import com.github.hardes1.taskmavenartifacts.util.TestRunner
import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeExplicitInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase


@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class UrlHashCodeInspectionExplicitJavaTest : LightJavaCodeInsightFixtureTestCase() {
    private lateinit var testRunner: TestRunner

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeExplicitInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {@Override public int hashCode() {return super.hashCode();}}")
        testRunner = TestRunner(myFixture, FileExtension.JAVA)
    }

    override fun getTestDataPath() = "src/test/testData/java/explicit"

    fun testHighlightReferenceSimpleName() {
        testRunner.doTest(TestType.REFERENCE_SIMPLE)
    }

    fun testHighlightReferenceFullName() {
        testRunner.doTest(TestType.REFERENCE_FULL)
    }

    fun testHighlightTemporarySimpleName() {
        testRunner.doTest(TestType.TEMPORARY_SIMPLE)
    }

    fun testHighlightTemporaryFullName() {
        testRunner.doTest(TestType.TEMPORARY_FULL)
    }

    fun testHighlightAsFieldSimpleName() {
        testRunner.doTest(TestType.AS_FIELD_SIMPLE)
    }

    fun testHighlightAsFieldFullName() {
        testRunner.doTest(TestType.AS_FIELD_FULL)
    }

    fun testHighlightCombined() {
        testRunner.doTest(TestType.COMBINED)

    }
}