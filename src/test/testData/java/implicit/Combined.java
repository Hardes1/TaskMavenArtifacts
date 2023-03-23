package ru.ustinov;

import java.net.URL;
import java.util.*;

class Simple {
    public static void main() {
        LinkedList<URL> a = new LinkedList<>();
        HashSet<URL> b = new HashSet<>();
        Hashtable<URL, Integer> c = new Hashtable<>();
        HashMap<URL, Integer> d = new HashMap<>();
        ArrayList<URL> e = new ArrayList<>();
        Queue<URL> f = new ArrayDeque<>();
        a.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
        b.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
        c.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
        d.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
        e.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
        f.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>();
    }
}