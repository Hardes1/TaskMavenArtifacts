package ru.ustinov;

import java.net.URL;
import java.util.HashSet;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">HashSet<URL> set;</warning>
        HashSet<Integer> set2;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">HashSet<HashSet<URL>> set3, set4;</warning>
        HashSet<HashSet<Integer>> set5, set6;
    }
}