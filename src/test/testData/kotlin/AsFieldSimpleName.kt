import java.net.URL

fun main() {
    val a = A(URL())
    a.url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}

class A(val url: URL)