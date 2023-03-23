import java.net.URL
import java.util.HashMap
import java.util.HashSet
import java.util.Hashtable
import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue
import kotlin.Array

@Suppress("UNUSED_VARIABLE")
fun main() {
    lateinit var a: Array<URL>
    lateinit var b: HashSet<URL>
    lateinit var c: HashMap<URL, Int>
    lateinit var d: Hashtable<URL, Int>
    lateinit var e: ArrayList<URL>
    lateinit var f: LinkedList<URL>
    lateinit var g: Queue<URL>
    a.<error descr="[MISSING_DEPENDENCY_SUPERCLASS] Cannot access 'java.io.Serializable' which is a supertype of 'kotlin.Array'. Check your module classpath for missing or conflicting dependencies"><warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning></error>()
    b.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
    c.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
    d.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
    e.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
    f.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
    g.<warning descr="Attempt to call hashCode() implicitly on DataStructure which contains URL">hashCode</warning>()
}