package 高阶

fun main() {
    /*无参的lambda单独存在*/
    { println("此行代码不会执行，相当于只定义了一个lambda表达式，但没有调用") }
    { println("此行代码会执行。在定义后的lambda表达式后加括号相当于调用了表达式") }();

    /*有参的lambda表达式*/
    // 不执行的有参lambda表达式
    { a: Int, b: Int ->
        a + b
    }
    // 执行的有参lambda表达式,表达式后加括号表示调用，在调用时传入参数即可
    val result = { a: Int, b: Int ->
        a + b
    }(3, 6)
    println("result=$result")

    /*高阶函数与lambda同时使用*/
    val a = 9
    val b = 18
    val sum = cacle(a, b, { a, b -> a + b })
    // 如果调用的函数是最后一个参数，则括号可以前移，单独将函数放置在外部
    val sub = cacle(a, b) { a, b -> a - b }
    println("${sum}::::${sub}")

    /*lambda表达式中使用it*/
    val num = 10
    add30(num) { a -> println("a的值最后变成了${a}") }
    // 当传入的高阶函数仅有一个参数时，可以省略传入的形参，使用时用it来代替
    add30(num) { println("a的值最后变成了${it}") }

    /* lambda表达式访问外部属性 */
    // 在kotlin中，函数与类都是一等公民
    val who = "哪吒"
    {
        println(who)
    }()
}

fun cacle(a: Int, b: Int, block: (Int, Int) -> Int): Int {
    return block(a, b)
}

fun add30(a: Int, blook: (Int) -> Unit) = blook(a + 30)