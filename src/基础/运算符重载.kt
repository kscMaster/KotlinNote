package 基础

fun main() {
    // 当我们使用运算符时，实际上是调用了API
    var a = 0
    var b = 1
    a.plus(b) // a+b
    a.minus(b) // a-b
    a.times(b) // a*b
    a.div(b) // a/b
    a.rem(b) // a%b

    var 助教 = Teacher()
    println("助教等级${助教.level}的工资是${助教.saraly}")
    val 讲师 = 助教++
    println("老师等级${讲师.level}的工资是${讲师.saraly}")
    val 副教授 = 讲师.inc()
    println("副教授等级${副教授.level}的工资是${副教授.saraly}")
    val 教授 = 副教授.inc()
    println("教授等级${教授.level}的工资是${教授.saraly}")

}

class Teacher
{
    var level = 1
    var saraly = 1000
    operator fun inc( ) : Teacher
    {
        level ++
        saraly +=500
        return this
    }
}