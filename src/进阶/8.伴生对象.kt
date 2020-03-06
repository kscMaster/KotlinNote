package 进阶

// 有些类的属性希望可以在外部直接使用，因此可以使用伴生对象来解决
class BeanData {
    val name: String = "张三" // 需要创建对象访问
    companion object InnerClass {// 类名可以省略
        val age = 10 // 可以直接调用
        fun sayHello() = println("奥利给")
    }
}

fun main() {
    BeanData.age
    BeanData.InnerClass.age
    BeanData.sayHello()
    val bd = BeanData()
    bd.name

}