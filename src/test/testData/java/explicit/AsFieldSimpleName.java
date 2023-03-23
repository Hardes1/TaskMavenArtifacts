package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class AsFieldSimpleName {
    public static void main() {
        URLField urlField = new URLField();
        urlField.url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}

class URLField {
    final URL url;

    URLField() {
        url = new URL();
    }
}