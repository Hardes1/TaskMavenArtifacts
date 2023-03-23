import java.net.URL
import java.util.Hashtable
import java.util.HashSet

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: Hashtable<URL, Int></warning>
    val b: Hashtable<Int, URL>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: Hashtable<HashSet<URL>, Int></warning>
    val d: Hashtable<Int, HashSet<Int>>
}