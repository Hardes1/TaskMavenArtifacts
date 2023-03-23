import java.net.URL
import java.util.HashSet
import java.util.Queue

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: Queue<URL></warning>
    val b: Queue<Int>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: Queue<HashSet<URL>></warning>
    val d: Queue<HashSet<Int>>
}