import java.net.URL
import java.util.HashSet
import java.util.ArrayList

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: ArrayList<URL></warning>
    val b: ArrayList<Int>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: ArrayList<HashSet<URL>></warning>
    val d: ArrayList<HashSet<Int>>
}