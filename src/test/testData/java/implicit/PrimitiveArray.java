package ru.ustinov;

import java.net.URL;
import java.util.HashSet;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">URL[] a;</warning>
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">java.net.URL[] b;</warning>
        Integer[] c;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">HashSet<URL>[] d, g;</warning>
        HashSet<Integer>[] e, f;
    }
}