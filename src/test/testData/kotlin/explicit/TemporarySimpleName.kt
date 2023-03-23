import java.net.URL

fun main() {
    URL().<warning descr="Attempt to call hashCode() explicitly on URL object">hashCode</warning>()
}