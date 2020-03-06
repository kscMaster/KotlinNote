package 进阶


//// 类型推断
//open class IAnimals
//
//class IDog : IAnimals() {
//    fun woof() =
//        println("woof woof woof")
//}
//
//class ICat : IAnimals() {
//    fun meow() = println("meow meow meow")
//}
//
//// 嵌套类无法访问外部类的属性或函数，是因为生成了Java的static final的内部类
//class OutClass1 {
//    val name: String = "asdf"
//    class innerClass1 {
//        fun say() = println("fdsa")
//    }
//}
// 嵌套类前加inner关键字成为内部类,此时可以访问外部类的属性或函数
class OutClass2 {
    var name = "asdf"
    fun say()= println("外部类")
    inner class innerClass2 {
        var name = "fdsa"
        fun say() = println("$name") // 同名情况下，默认调用内部类的属性
        fun sayOutParm() = println(this@OutClass2.name)
        fun sayOutFun() = this@OutClass2.say()
    }
}

fun main() {
//    val dog: IAnimals = IDog()
//    val cat: IAnimals = ICat()
//    if (dog is IDog) //如果是IDog类型，则不需要再写dog as IDog来强转了
//    {
////        dog as IDog
//        dog.woof()
//    }
//    if (cat is ICat) //如果是IDog类型，则不需要再写cat as ICat来强转了
//    {
////        cat as ICat
//        cat.meow()
//    }
//    val innerClass = OutClass1.innerClass1()
//    innerClass.say()
    val inClass = OutClass2().innerClass2()
    inClass.say()
    inClass.sayOutParm()
    inClass.sayOutFun()


}