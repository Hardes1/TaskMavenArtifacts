package com.github.hardes1.taskmavenartifacts;

class ReferenceFullName {
    public static void main() {
        java.net.URL url = new java.net.URL();
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}