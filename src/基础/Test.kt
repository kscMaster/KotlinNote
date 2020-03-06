package 基础

fun main() {
    val nam1e: String ? = null
    println(nam1e?.length  ?: "aaa")

    var first = 10
    var second = 8
    var third = first
    first = second
    second = third
    println(first)
    println(second)
    println(third)
}