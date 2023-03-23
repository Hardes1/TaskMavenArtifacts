import java.net.URL
import java.util.HashMap
import java.util.HashSet

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: HashMap<URL, Int></warning>
    val b: HashMap<Int, URL>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: HashMap<HashSet<URL>, Int></warning>
    val d: HashMap<Int, HashSet<Int>>
}