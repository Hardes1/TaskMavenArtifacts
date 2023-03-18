package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class ReferenceSimpleName {
    public static void main() {
        URL url = new URL();
        url.hashCode();
        new URL().hashCode();
        java.net.URL url1 = new java.net.URL();
        url1.hashCode();
        new java.net.URL().hashCode();
        new URLFieldSimpleName().url.hashCode();
        new URLFieldFullName().url.hashCode();
    }
}

class URLFieldSimpleName() {
    final URL url;

    URLFieldSimpleName() {
        url = new URL();
        url.hashCode();
    }
}

class URLFieldFullName() {
    final java.net.URL url;

    URLFieldFullName() {
        url = new java.net.URL();
        url.hashCode();
    }
}