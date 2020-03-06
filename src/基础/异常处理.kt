package 基础

import java.lang.Exception

fun main() {
    val  a = 1
    val b = 0
    var c :Int? = null
    try {
        c = a/b
    } catch (e:Exception)
    {
        println(e.message)
    }
    println(c ?: 0)
}