package 高阶

fun main() {
    val a = 10
    val b = 20
    var sum = 0 // a与b的和
    var sub = 0 // a与b的差
    println(plus(a, b))
    println(sub(a, b))
    // 调用高阶函数时，需要传入函数的地方使用*::*+fun 实现引用，若使用*fun()*相当于调用
    sum = cacl(a, b, ::plus)
    sub = cacl(a, b, ::sub)
    println(sum)
    println(sub)
}

// 一般函数
fun plus(a: Int, b: Int): Int = a + b
fun sub(a: Int, b: Int): Int = a - b

// 高阶函数实现方式,传入一个函数
// block:(Int,Int)->Int是一个函数，传入2个参数，返回一个参数
fun cacl(a: Int, b: Int, block: (Int, Int) -> Int): Int {
    return block(a, b)
}