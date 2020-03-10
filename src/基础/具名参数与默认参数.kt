package 基础

fun hello(name: String = "陌生人", age: Int = 0): String {
    return "基础.hello,$name,你今年$age 岁了"
}

fun add3(vararg parms: Int): Int {
    var sum = 0
    parms.forEach { sum += it }
    return sum
}

fun main() {

    hello()
    hello(name = "dwad")
    hello(age = 99)
    println("集合和为：${add3(1, 2, 3, 4, 5, 5, 6, 4)}")

}