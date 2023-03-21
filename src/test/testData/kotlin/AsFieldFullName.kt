fun main() {
    val a = A(java.net.Url())
    a.url.hashCode()
}

class A(val url: java.net.URL)