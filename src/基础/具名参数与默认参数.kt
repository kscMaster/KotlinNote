package 基础

fun hello(name: String = "陌生人", age: Int = 0): String {
    return "hello,$name,你今年${if (age == 0) "未知" else age} 岁了"
}

fun main() {

    println(hello())
    println(hello(name = "dwad"))
    println(hello(age = 99))
    println(hello("张三", 283))

}

