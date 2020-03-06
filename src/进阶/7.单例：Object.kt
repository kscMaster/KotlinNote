package 进阶

// 对象在内存中仅有一个实例
// 方法：将当前class修饰词 替换为 object即可
// 使用：不可以新建实例，直接用类即可
object SingleInstance {
    var name: String = "张三"
    val age: Int = 0
    fun dothings() = println("名字是${name}")
}

fun main() {
    println(SingleInstance.name)
    SingleInstance.dothings()
    SingleInstance.name = "猪头"
    println(SingleInstance.name)

    val singl = Singlet.sing
    println(singl.name)
    singl.printName()
}

// 使用Kotlin完成一个标准的单例模式：
class Singlet private constructor() {
    val name = "张胜男"
    // 私有构造函数
    companion object {
        val sing: Singlet by lazy { Singlet() }
    }
    fun printName() = println("$name")
}