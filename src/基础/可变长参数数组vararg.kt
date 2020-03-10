package 基础


// 可变长参数数组
fun add3(vararg parms: Int): Int {
    var sum = 0
    parms.forEach { sum += it }
    return sum
}
fun main() {
    println("集合和为：${add3(1, 2, 3, 4, 5, 6, 7, 8,9,10)}")

    val a = arrayOf(1, 2, 3)
    val list = asList(-1, 0, *a, 4)
    println(list)
    var list1 = arrayOf("1", 2, 3, 4, "五", "⑥")
    var list2 = asList("dwda", *list1)
//    println(asLissaveToAny(1, *list2,2,3,4))

    println(te(1, 4, 2, 4, 6, 7, 7, 7, 6, 56, 5, 4, 4))
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

fun te(vararg tal: Int) :Int
{
    var sum = 0
    for (t in tal )
    {
        sum += t
    }
    return sum
}