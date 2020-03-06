package 进阶

enum class Week {
    周一, 周二, 周三, 周四, 周五, 周六, 周日
}
fun todo(week: Week) {
    when (week) {
        Week.周一,Week.周二,Week.周三,Week.周四,Week.周五 -> println("上班")
        Week.周六 -> println("放松")
        Week.周日 -> println("玩")
    }
}
fun main() {
    todo(Week.周一)
    val p = Parents.ZS
    println("${p.age}岁的人是${p.pName}")
}

enum class Parents(var pName:String, var age:Int){
    ZS("张三",20),
    LS("李四",30),
    WMZ("王麻子",40)
}
