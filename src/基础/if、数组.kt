package 基础

import java.util.*

fun compareInt(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun main() {
//    val a = 10
//    val b = 20
//    基础.compareInt(a, b)

    // 数组
    val list1 = charArrayOf('c','t')
    val list2 = booleanArrayOf(true,true,false)
    val list3 = shortArrayOf(1,2,3)
    val list4 = byteArrayOf(1,2,3,4)
    val list5 = intArrayOf(1,2,3,4,5)
    val list6 = longArrayOf(1L,2L)
    val list7 = floatArrayOf(1.2f,2.1f)
    val list8 = doubleArrayOf(1.22,2.1)
    val list9 = arrayOf("s","t")
    list5[2] = 10
    list5.set(2, 20)
//    list5.forEach { println("${it}") }

    // Map
    var map = TreeMap<String,String>()
    map["好"] = "good"
    map["学习"] = "study"
    map["天"] = "day"
    map["向上"] = "up"
    map.forEach { println(it.key + it.value) }
}


