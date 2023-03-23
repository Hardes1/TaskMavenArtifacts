package com.github.hardes1.taskmavenartifacts.implicit

import com.github.hardes1.taskmavenartifacts.inspections.URLHashCodeDataStructureJavaInspection
import com.github.hardes1.taskmavenartifacts.util.FileExtension

class URLHashCodeInspectionDataStructureJavaTest :
    BaseURLHashCodeDataStructureConstructorTest(
        URLHashCodeDataStructureJavaInspection::class.java,
        FileExtension.JAVA
    )