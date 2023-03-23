import java.net.URL
import java.util.HashSet

@Suppress("UNUSED_VARIABLE")
fun main() {
<warning descr="This data structure can probably implicitly invoke URL#hashCode()">val a: HashSet<URL></warning>
        val b: HashSet<Int>
<warning descr="This data structure can probably implicitly invoke URL#hashCode()">val c: HashSet<HashSet<URL>></warning>
        val d: HashSet<HashSet<Int>>
        }