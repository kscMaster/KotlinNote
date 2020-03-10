package 进阶

// 马+驴 = 骡子    驴+驴 = 小驴
interface isPregnant {
    fun say()
}
sealed class UncertainAnimals : isPregnant {
    class 小驴子() : UncertainAnimals() {
        override fun say() = println("我还能生子子孙孙")
    }
    class 小骡子() : UncertainAnimals() {
        override fun say() = println("此生断子绝孙永无后代")
    }
}
class 青蛙() : UncertainAnimals(), isPregnant {
    override fun say() = println("吾生子孙千千万")
}

fun main() {
    val s1 = UncertainAnimals.小骡子()
    val s2 = UncertainAnimals.小驴子()
    val s3 = UncertainAnimals.小驴子()
    val s4 = 青蛙()
    val lists = listOf<UncertainAnimals>(s1, s2, s3, s4)
    lists.forEach {
        when (it) {
            is UncertainAnimals.小驴子 -> it.say()
            is UncertainAnimals.小骡子 -> it.say()
            else -> it.say()
        }
    }
}