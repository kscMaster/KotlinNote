package 进阶

// 定义时不知道具体的类型，只有再使用时才知道
open class Box<T>(val anyThings: T)

// 子类可以继承泛型的父类，当子类知道具体类型时，可以直接传类型
class SonBox(num: Int) : Box<Int>(num)

// 若不可得知具体类型，也可以传T
class Daughter<T>(things: T) : Box<T>(things)

// 传递任意类型，打印出传递的类型
fun <T> parseType(type: T) {
    when (type) {
        is String -> println("${type}是String类型")
        is Int -> println("${type}是Int类型")
        is Char -> println("${type}是Char类型")
        is Boolean -> println("${type}是Boolean类型")
        else -> println("${type}是其他非法类型")
    }
}

fun main() {
//    val boxPerson = Box<Person>(Person())
//    println(boxPerson.anyThings.name)
//    val boxBoolean = Box<Boolean>(true )
//    println(boxBoolean.anyThings.toString())
//    val sonBox = SonBox(1)
//    println(sonBox.anyThings)
//    val daughter = Daughter<Person>(Person())
//    println(daughter.anyThings.age)

    parseType('A')
    parseType("BB")
    parseType(10)
    parseType(true)
    parseType(Person())
}

class Person() {
    val id: Int = 0
}