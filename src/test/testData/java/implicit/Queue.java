package ru.ustinov;

import java.net.URL;
import java.util.HashSet;
import java.util.Queue;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">Queue<URL> a;</warning>
        Queue<Integer> b;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">Queue<HashSet<URL>> c, d;</warning>
        Queue<HashSet<Integer>> e, f;
    }
}