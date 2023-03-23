package ru.ustinov;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">HashMap<URL, Integer> hashMap;</warning>
        HashMap<Integer, URL> hashMap2;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">HashMap<HashSet<URL>, Integer> hashMap3;</warning>
        HashMap<HashSet<Integer>, URL> hashMap6;
    }
}