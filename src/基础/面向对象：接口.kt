package 基础

interface Ride {
    fun rideBike()
}
interface Drive{
    fun driveCar() = println("未成年人不能考驾照呢")
}
// 父类 实现了 接口*基础.Ride*
abstract class People(
    var name: String = "人类",
    var age: Int = 100000000,
    var gender: Int = -1,
    var contact: String? = null): Ride {
    open fun features() = println("会活动有大脑有思考的生命的统称")
    abstract fun hobby()
}
// 子类成年人不实现父类的接口编译器报错
class Adult(name: String, age: Int, gender: Int) : People(name, age, gender),
    Drive {
    override fun features() {
        super.features()
        println("胡子很粗")
    }
    override fun hobby() {
        println("爱好广泛")
    }
    override fun rideBike() {
        println("很快就学会了骑自行车")
    }
    override fun driveCar() {
        println("成年人一下子就学会了开车耶")
    }
}
// 未成年人
class Juveniles(name: String,age: Int,gender: Int,contact: String?) : People(name, age, gender, contact),
    Drive
{
    override fun features() {
        println("没长胡子")
    }
    override fun hobby() {
        println("吃饭")
    }
    override fun rideBike() {
        println("学骑自行车很慢")
    }
}
fun main() {
    val ad = Adult("成年人", 19, 0)
    ad.features()
    ad.hobby()
    ad.rideBike()
    ad.driveCar()
    val ju = Juveniles("未成年人", 12, 1, "18614838383")
    ju.features()
    ju.hobby()
    ju.rideBike()
    ju.driveCar()
}