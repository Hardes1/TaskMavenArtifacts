package ru.ustinov;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

class Simple {
    public static void main() {
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">ArrayList<URL> a;</warning>
        ArrayList<Integer> b;
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">ArrayList<ArrayList<URL>> c, d;</warning>
        <warning descr="This data structure can probably implicitly invoke URL#hashCode()">ArrayList<HashMap<Integer, Hashtable<Integer, URL>>> e, f;</warning>
    }
}