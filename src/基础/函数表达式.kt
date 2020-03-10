package 基础

fun main() {
    val a = 5
    val b = 15
    add1(a, b)
    add2(a, b)
    val add3: (Int, Int) -> Int = { a, b -> a + b }
//    val add4 = { x: Int, y: Int -> x + y } // 不喜欢这么写
    println(add3(1, 2))
//    println(add4(1, 2))


    // 函数表达式
    val plus: (Int, Int) -> Int = { a, b -> a.plus(b) }
    val minus: (Int, Int) -> Int = { a, b -> a.minus(b) }
    val times: (Int, Int) -> Int = { a, b -> a.times(b) }
    val div: (Int, Int) -> Int = { a, b -> a.div(b) }
    val rem : (Int,Int)->Int ={a,b -> a.rem(b)}

    val plus2 = {a:Int,b:Int -> a.plus(b)}
    val minus2 = {a:Int,b:Int -> a.minus(b)}
}

fun add1(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int) = a + b




