package com.github.hardes1.taskmavenartifacts.explicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeExplicitInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.*
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase


@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class URLHashCodeInspectionExplicitJavaTest : LightJavaCodeInsightFixtureTestCase(), TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, FileExtension.JAVA)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeExplicitInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {@Override public int hashCode() {return super.hashCode();}}")
    }

    override fun getTestDataPath() = "src/test/testData/java/explicit"

    fun testHighlightReferenceSimpleName() {
        testRunner.doTest(ExplicitTestType.ReferenceSimple())
    }

    fun testHighlightReferenceFullName() {
        testRunner.doTest(ExplicitTestType.ReferenceFull())
    }

    fun testHighlightTemporarySimpleName() {
        testRunner.doTest(ExplicitTestType.TemporarySimple())
    }

    fun testHighlightTemporaryFullName() {
        testRunner.doTest(ExplicitTestType.TemporaryFull())
    }

    fun testHighlightAsFieldSimpleName() {
        testRunner.doTest(ExplicitTestType.AsFieldSimple())
    }

    fun testHighlightAsFieldFullName() {
        testRunner.doTest(ExplicitTestType.AsFieldFull())
    }

    fun testHighlightCombined() {
        testRunner.doTest(ExplicitTestType.Combined())
    }
}