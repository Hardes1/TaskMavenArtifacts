package com.github.hardes1.taskmavenartifacts.util

import com.intellij.testFramework.fixtures.CodeInsightTestFixture

class HighlightTestRunner(private val myFixture: CodeInsightTestFixture, private val extension: FileExtension) :
    TestRunner {
    override fun doTest(testType: TestType) {
        val path = "${testType.pathName}${extension.type}"
        myFixture.configureByFile(path)
        myFixture.checkHighlighting()
    }
}