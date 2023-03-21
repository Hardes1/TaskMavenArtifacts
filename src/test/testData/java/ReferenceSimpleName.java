package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class ReferenceSimpleName {
    public static void main() {
        URL url = new URL();
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}