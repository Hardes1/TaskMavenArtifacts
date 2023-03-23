package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeDataStructureKotlinInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension

class URLHashCodeInspectionDataStructureKotlinTest : BaseURLHashCodeDataStructureConstructorTest(
    URLHashCodeDataStructureKotlinInspection::class.java,
    FileExtension.KOTLIN
)