package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class TemporarySimpleName {
    public static void main() {
        new URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}