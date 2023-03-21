package com.github.hardes1.taskmavenartifacts

import java.net.URL

fun main() {
    val url: URL = URL()
    url.hashCode()
    java.net.URL().hashCode()
    val url1: java.net.URL = java.net.URL()
    url1.hashCode()
    java.net.URL().hashCode()
    URLFieldSimpleName().url.hashCode()
    URLFieldFullName().url.hashCode()
}



class URLFieldSimpleName {
    val url: URL

    init {
        url = URL()
        url.hashCode()
    }
}

class URLFieldFullName() {
    val url: java.net.URL

    init {
        url = java.net.URL()
        url.hashCode()
    }
}