import java.net.URL

fun main() {
    val url = URL()
    url.<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}