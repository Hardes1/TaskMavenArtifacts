fun main() {
    val a = A(java.net.URL())
    a.url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}

class A(val url: java.net.URL)