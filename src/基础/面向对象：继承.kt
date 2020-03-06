package 基础

// 普通继承
open class Father() {
    val surname: String = "康" // 姓
    open var name: String = "父亲" // 名
    open var age: Int = 40
    open fun work() {
        println("赚钱养家养儿子")
    }
}

class Son : Father() {
    override var name: String = "儿子"
    override var age: Int = 18

    override fun work() {
//        super.work()
        println("花父亲赚来的钱")
    }
}

// 带有构造函数的继承
abstract class Human(var name: String = "人类", var age: Int = 100000000, var gender: Int = -1, var contact: String? = null)
{
    open fun features(): Unit {
        println("会活动有大脑有思考的生命")
    }
    abstract fun hobby()
}
class Man(name: String, age: Int, gender: Int) : Human(name, age, gender)
{
    override fun features() {
        super.features()
        println("长了个丁丁")
    }
    override fun hobby() {
        println("吃饭的样子很狂野")
    }
}
class Woman(name: String,age: Int,gender: Int,contact: String?) : Human(name, age, gender, contact)
{
    override fun features() {
        super.features()
        println("没长丁丁")
    }
    override fun hobby() {
        println("吃饭的样子很淑女")
    }
}
fun main() {
    val son = Son()
    // 子类可以访问父类的属性和方法
    println("姓${son.surname}的${son.name}年龄是${son.age}岁")
    // 方法可以被重写
    son.work()
    val man = Man("男人", 20, 0)
    man.features()
    man.hobby()
    val woman = Woman("女人", 18, 1, "18548383929")
    woman.features()
    woman.hobby()

}