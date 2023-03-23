package com.github.hardes1.taskmavenartifacts.explicit

import com.github.hardes1.taskmavenartifacts.util.TestRunner
import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeExplicitInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class UrlHashCodeInspectionExplicitKotlinTest : LightJavaCodeInsightFixtureTestCase() {
    private lateinit var testRunner: TestRunner

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeExplicitInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.lang; public class Object {public int hashCode() { return 0;}}")

        testRunner = TestRunner(myFixture, FileExtension.KOTLIN)
    }

    override fun getTestDataPath() = "src/test/testData/kotlin/explicit"

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