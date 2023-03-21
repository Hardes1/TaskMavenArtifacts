package com.github.hardes1.taskmavenartifacts;

import java.net.URL;

class ReferenceSimpleName {
    public static void main() {
        URL url = new URL();
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
        new URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
        java.net.URL url1 = new java.net.URL();
        url1.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
        new java.net.URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
        new URLFieldSimpleName().url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
        new URLFieldFullName().url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}

class URLFieldSimpleName<error descr="Record header declared for non-record">()</error> {
    final URL url;

    URLFieldSimpleName() {
        url = new URL();
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}

class URLFieldFullName<error descr="Record header declared for non-record">()</error> {
    final java.net.URL url;

    URLFieldFullName() {
        url = new java.net.URL();
        url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>();
    }
}