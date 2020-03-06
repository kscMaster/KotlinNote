package 高阶

fun main() {
    // 只读
    val country1 = mapOf("China" to "中国", "American" to "美国")
    // 可写
    var country2 = mutableMapOf("China" to "中国", "American" to "美国")
    country2.put("Japan", "小日本")
    // hashMap linkedhashMap
    val hashMap = hashMapOf("China" to "中国", "American" to "美国")
    val linkedhashMap = linkedMapOf("China" to "中国", "American" to "美国")
    // 遍历1
    for (entry in country1) {
        println("${entry.key}:${entry.value}")
    }
    // 遍历2
    country2.entries.forEach {
        println("${it.key}:${it.value}")
    }
    // 遍历3
    for ((key, value) in country1) {
        println("${key}:${value}")
    }
    // 遍历4 单独获取key
    for (key in country1.keys) {
        println(key)
    }
    // 遍历5 单独获取value
    for (value in country1.values) {
        println(value)
    }
    // 遍历6 迭代器
    val it = country2.iterator()
    while (it.hasNext()) {
        val next = it.next()
        println("${next.key}:${next.value}")
    }
}