package 进阶

//
sealed class Parent {
    class Son1 : Parent()
    class Son2 : Parent()
    class Son3 : Parent()
}
class Son4 : Parent()
fun isQinSon(s: Parent): String {
    return when (s) {
        is Parent.Son1 ,is Parent.Son2, is Parent.Son3 -> "我亲儿子"
        else -> "不是我亲儿子"
    }
}

fun main() {
    println(isQinSon(Parent.Son3()))
    println(isQinSon(Son4()))
}








