import java.net.URL

fun main() {
    val a = A(Url())
    a.url.hashCode()
}

class A(val url: URL)