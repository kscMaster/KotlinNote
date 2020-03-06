package 高阶
// 定义函数
val add:(Int,Int)-> Int = {a,b -> a+b}

/**闭包**/
// 一个函数返回了一个内部的函数，该内部函数引用了外部函数的相关参数和变量，我们把该函数返回的内部函数称为闭包
// 函数返回一个无参无返回值的函数
fun close() : () -> Unit{
    var a = 10
    return {
        println(a++)
    }
}

fun main() {
    val c = close()
    c()
    c()
    c()
    c()
    //kotlin的函数是有状态的，比如使用闭包
    // kotlin里的闭包一般是指lambda表达式

    // 外部函数的变量a是一直在变化的，因为闭包引用了外部函数的内的变量，这使得函数会保持一定的状态
}