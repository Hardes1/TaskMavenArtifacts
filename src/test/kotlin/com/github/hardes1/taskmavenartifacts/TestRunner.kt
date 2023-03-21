package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.fixtures.CodeInsightTestFixture

class TestRunner(private val myFixture: CodeInsightTestFixture, private val extension: FileExtension) {
    fun doTest(testType: TestType) {
        val path = "${testType.pathName}${extension.type}"
        myFixture.configureByFile(path)
        myFixture.checkHighlighting()
    }
}