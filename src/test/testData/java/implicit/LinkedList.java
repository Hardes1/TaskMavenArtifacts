package ru.ustinov;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">LinkedList<URL> a;</warning>
        LinkedList<Integer> b;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">LinkedList<HashSet<URL>> c, d;</warning>
        LinkedList<HashSet<Integer>> e, f;
    }
}