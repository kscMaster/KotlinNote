package dsl领域特定语言

// 可以替代项目开发中的各种utils
// 不需要添加新的对象就可以添加新的函数
// 可以理解为在原有API的各个类里添加自定义的API
// 父类定义的扩展函数，子类同样可以使用
fun main() {
    val aa = "a"
    val bb = "A"
    println("${aa.isStrA()}       ${bb.isStrA()}")

    val v: View = Button()
    v.showOff()
    val b: Button = Button()
    b.showOff()

    var a = mutableListOf(1,2,3)
    a.swap(0,1)
    println(a)

    var t = null
    println(t.toString())

    val obj = Object()
    println(obj.dosomethings())

    val song = Song("千年泪", 2005)
    println("这首歌《${song.title}》是由艺术家${song.artist}于${song.year}年发行的")
    song.artist = "Tank"
    println(song.artist)


}

fun String.isStrA():Boolean = this=="A"

// 与多态不同，当子类初始化时以父类接收，最终会调用父类的函数。
open class View

class Button : View()

fun View.showOff() = println("View。showOff")
fun Button.showOff() = println("Button。showOff")

// 为multableList添加一个交换元素的方法
fun MutableList<Int>.swap(p1:Int,p2:Int)
{
    var temp = this[p1]
    this[p1] = this[p2]
    this[p2] = temp
}
/*****扩展属性****/
// 当成员函数和扩展函数名字冲突时，系统会优先调用成员函数
class Object {
    fun dosomethings() = "成员函数做一些事情"
}

fun Object.dosomethings(): String = "扩展函数做一些事情"

/**
 * 扩展属性
 */
// 扩展一个空对象
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}
// 扩展属性，在一个已知的类中添加一个属性

class Song(val title: String, val year: Int)
// 这里老师没有讲如何设置扩展属性的方法，暂时注释掉，笔记在低964行
var Song.artist: String
    get() = "腾格尔"
    set(value) {
//        artist = value
    }
