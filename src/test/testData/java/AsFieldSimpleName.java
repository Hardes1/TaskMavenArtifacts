package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class AsFieldSimpleName {
    public static void main() {
        URLField urlField = new URLField();
        urlField.url.hashCode();
    }
}

class URLField {
    final URL url;

    URLField() {
        url = new URL();
    }
}