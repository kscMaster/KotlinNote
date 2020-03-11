package 进阶

import kotlin.reflect.KProperty


/*  类委托   */
interface Clean {
    fun washDishes()
}

// 丈夫洗碗
class Son : Clean {
    override fun washDishes() {
        println("儿子来洗碗")
    }
}

// 妻子将洗碗的方法委托给丈夫去洗，丈夫委托给儿子去洗
class Wife() : Clean by Father()
class Wife1(val s : Clean) : Clean by s

class Father() : Clean by Son()

fun main() {
//    Wife().washDishes()
    val grandson = Grandson()
    grandson.money = 100
    grandson.showMoney()

    val shmz = 少数民族()
    shmz.score = 450
    shmz.showScore()
}

/*  属性委托  */
class Grandson {
    var money: Int by Father1()
    fun showMoney() = println("孙子的压岁钱是：${money}")
}
class Father1 {
    operator fun getValue(grandson: Grandson, property: KProperty<*>): Int {
        return money - 50
    }
    operator fun setValue(grandson: Grandson, property: KProperty<*>, i: Int) {
        this.money = i
    }
    var money: Int = 0
}

// 少数民族高考加分
class 少数民族
{
    var score : Int by 教育局()
    fun showScore() = println(score)
}
class 教育局()
{
    var score = 0
    operator fun getValue(少数民族: 少数民族, property: KProperty<*>): Int {
        return score + 20
    }

    operator fun setValue(少数民族: 少数民族, property: KProperty<*>, i: Int) {
        score = i
    }
}