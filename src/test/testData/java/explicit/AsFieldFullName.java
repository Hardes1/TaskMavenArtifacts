package com.github.hardes1.taskmavenartifacts;

class AsFieldFullName {
    public static void main() {
        URLField urlField = new URLField();
        urlField.url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}

class URLField {
    final java.net.URL url;

    URLField() {
        url = new java.net.URL();
    }
}