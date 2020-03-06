package 基础

// 求 n的阶乘
// n*(n-1) * (n-2)...1
fun jieCheng(num: Int): Int {
    if (num == 1) return num
    return num * jieCheng(num - 1)
}

// 求 斐波那契数列
// 1 1 2 3 5 8 13 21 34 55
fun feiBoNaQie(n: Int): Int {
    if (n == 1 || n == 2) return 1
    return feiBoNaQie(n - 1) + feiBoNaQie(n - 2)
}

// 求1..100的和
fun sum(n: Int): Int {
    if (n == 1) return n
    return n + sum(n - 1)
}

// 优化
// 求1..100000的和
tailrec fun sumPro(n: Int, preSum: Int = 0): Int {
    if (n == 1) return n + preSum
    return sumPro(n - 1, preSum + n)
}

// 调用
fun main() {
    println(feiBoNaQie(8))

    println(jieCheng(6))

    println(sum(100))

    println(sumPro(100000))

    println(Person().age ?: "无")
    println(Person().name ?: "无")




}

class Person {
    var name: String? = "张三"
    val age: Int? = null
}
