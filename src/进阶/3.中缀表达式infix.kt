package 进阶

// 在类里的函数加上infix称为中缀表达式，条件：类里函数的参数仅有1个的情况下
class Welcome {
    infix fun sayHello(name: String): Unit {
        println("hello,$name")
    }
}

fun main() {
    // 调用方法：对象、函数名。参数
    val welcome = Welcome()
    welcome.sayHello("鲍勃")
    welcome sayHello "宝宝"
}