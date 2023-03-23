package com.github.hardes1.taskmavenartifacts.explicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeExplicitInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.*
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

abstract class BaseURLHashCodeInspectionExplicitTest(private val extension: FileExtension) :
    LightJavaCodeInsightFixtureTestCase(), TestRunnerOwner {
    override val testRunner: TestRunner by lazy {
        HighlightTestRunner(myFixture, extension)
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(URLHashCodeExplicitInvocationInspection::class.java)
        myFixture.addClass("package java.net; public final class URL {public int hashCode() {return super.hashCode();}}")
        myFixture.addClass("package java.lang; public class Object {public int hashCode() { return 0;}}")
    }

    override fun getTestDataPath() = "src/test/testData/${extension.name.toLowerCaseAsciiOnly()}/explicit"

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