package com.github.hardes1.taskmavenartifacts

import java.net.URL

fun main() {
    val url: URL = URL()
    url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    java.net.URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    val url1: java.net.URL = java.net.URL()
    url1.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    java.net.URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    URLFieldSimpleName().url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    URLFieldFullName().url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}



class URLFieldSimpleName {
    val url: URL

    init {
        url = URL()
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    }
}

class URLFieldFullName() {
    val url: java.net.URL

    init {
        url = java.net.URL()
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
    }
}