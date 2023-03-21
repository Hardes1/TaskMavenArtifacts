package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.inspections.UrlHashCodeInvocationInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class UrlHashCodeInspectionExplicitKotlinTest : BasePlatformTestCase() {
    private lateinit var testRunner: TestRunner


    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(UrlHashCodeInvocationInspection::class.java)
        testRunner = TestRunner(myFixture, FileExtension.KOTLIN)
    }

    fun testHighlightReferenceSimpleName() {
        testRunner.doTest(TestType.REFERENCE_SIMPLE, 1)
    }

}