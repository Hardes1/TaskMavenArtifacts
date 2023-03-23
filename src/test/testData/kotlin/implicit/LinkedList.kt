import java.net.URL
import java.util.HashSet
import java.util.LinkedList

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: LinkedList<URL></warning>
    val b: LinkedList<Int>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: LinkedList<HashSet<URL>></warning>
    val d: LinkedList<HashSet<Int>>
}