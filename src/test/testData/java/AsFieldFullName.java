package com.github.hardes1.taskmavenartifacts;

class AsFieldFullName {
    public static void main() {
        URLField urlField = new URLField();
        urlField.url.hashCode();
    }
}

class URLField {
    final java.net.URL url;

    URLField() {
        url = new java.net.URL();
    }
}