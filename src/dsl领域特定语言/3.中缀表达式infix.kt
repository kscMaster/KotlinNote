package dsl领域特定语言

import getPersonRepository
import 查找某省所有人
import 查找特定性别

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

    val list = getPersonRepository()
    println(list 查找某省所有人 ("广东省") 查找特定性别 ("男"))
}