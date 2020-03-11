package 函数式编程

var printNames = fun (name :String) { println(name) }

fun main() {
    var names = listOf<String>("a","v","c","z")
    names.forEach { printNames }

    // 继续简化
    names.forEach{ println(it)}



}