package 高阶函数实战

import getPersonRepository

fun main() {
    val list = getPersonRepository()
    // 将姓名和身份证号组合成集合
    val map = list.map {
        "${it.idNum.substring(6,10)} : ${it.name}"
    }
    println(map)


}