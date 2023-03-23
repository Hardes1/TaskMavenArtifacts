fun main() {
    val url = java.net.URL()
    url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}