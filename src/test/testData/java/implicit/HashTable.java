package ru.ustinov;

import java.net.URL;
import java.util.Hashtable;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">Hashtable<URL, Integer> a;</warning>
        Hashtable<Integer, URL> b;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">Hashtable<Hashtable<Integer, URL>, Integer> c, d;</warning>
        Hashtable<Integer, Hashtable<Integer, URL>> e, f;
    }
}