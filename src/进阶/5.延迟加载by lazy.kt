package 进阶

// 只创建一次，并且在加载的时候再创建,它是线程安全的
    val str by lazy {
    println("初始化")
    "张三"
}

fun main() {
    println(str)
    println(str)
}