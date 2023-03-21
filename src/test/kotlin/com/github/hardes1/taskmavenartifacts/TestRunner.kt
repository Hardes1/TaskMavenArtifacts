package com.github.hardes1.taskmavenartifacts

import com.github.hardes1.taskmavenartifacts.util.FileExtension
import com.github.hardes1.taskmavenartifacts.util.TestType
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import junit.framework.TestCase

class TestRunner(private val myFixture: CodeInsightTestFixture, private val extension: FileExtension) {
    fun doTest(testType: TestType, count: Int) {
        val path = "${testType.pathName}${extension.pathName}"
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