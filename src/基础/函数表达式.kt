package 基础

fun main() {
    val a = 5
    val b = 15
    var sum: Int
    sum = add2(a, b)
    val add3: (Int, Int) -> Int = { a, b -> a + b }
    sum = add3(a,b)
    println(sum)

    val add4:(Int,Int)-> Int = {a,b -> a+b}

    hello()
    hello(name = "dwad")
    hello(age = 99)
    println("集合和为：${add3(1, 2, 3, 4, 5, 5, 6, 4)}")
}

fun add1(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int) = a + b

fun hello(name: String = "陌生人", age: Int = 0): String {
    return "基础.hello,$name,你今年$age 岁了"
}

fun add3(vararg parms: Int): Int {
    var sum = 0
    parms.forEach { sum += it }
    return sum
}


