import java.net.URL
import java.util.HashSet

@Suppress("UNUSED_VARIABLE")
fun main() {
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: Array<URL></warning>
    val b: Array<Int>
    <warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: Array<HashSet<URL>></warning>
    val d: Array<HashSet<Int>>
}