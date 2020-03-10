package 基础

// 阶乘
fun factorial(x: Int): Int {
    return if (x == 1) x else factorial(x - 1) * x
}

// 阶乘优化（尾递归优化）
tailrec fun factorialTailrec(x: Int, y: Int = 1): Int {
    return if (x == 1) x * y
    else factorialTailrec(x - 1, x * y)
}

// 等差数列
fun sum(n: Int): Int {
    if (n == 1) return n
    return n + sum(n - 1)
}

// 等差数列尾递归优化
tailrec fun sumTailrec(n: Int, sum: Int = 0): Int {
    return if (n == 1) sum + n
    else sumTailrec(n - 1, n + sum)
}

// 斐波那契数列，求第N位元素上的值
// 1 1 2 3 5 8 13 21 34 55
fun fibonacci(n: Int): Int {
    if (n < 2) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}

// 斐波那契数列（尾递归优化）ret1就是第n项的值，ret2就是第n+1项的值
tailrec fun fibonacciTailrec(n: Int, ret1: Int, ret2: Int): Int {
    if (n == 1)
        return ret1;
    return fibonacciTailrec(n - 1, ret2, ret1 + ret2);
}

// 调用
fun main() {
    println("N的阶乘：${factorial(6)}")
    println("尾递归优化N的阶乘：${factorialTailrec(6)}")

    println("等差数列${sum(100)}")
    println("等差数列尾递归优化${sumTailrec(100)}")

    println("斐波那契数列: ${fibonacci(8)}")
    println("尾递归优化斐波那契数列: ${fibonacciTailrec(8, 1, 1)}")
}

