package 进阶

import com.sun.org.apache.xpath.internal.operations.Bool

// 可以替代项目开发中的各种utils
// 不需要添加新的对象就可以添加新的函数
// 可以理解为在原有API的各个类里添加自定义的API
// 父类定义的扩展函数，子类同样可以使用
fun main() {
    val a: String? = ""
    println(a?.isEmptyOrNull())
    val v: View = Button()
    v.showOff()
    val b: Button = Button()
    b.showOff()

    val obj = Object()
    println(obj.dosomethings())

    val song = Song("千年泪", 2005)
    println("这首歌《${song.title}》是由艺术家${song.artist}于${song.year}年发行的")
    song.artist = "Tank"
    println(song.artist)

}

fun String.isEmptyOrNull(): String =
    if (this.isNullOrEmpty()) {
        "是空的"
    } else "不是空的"

// 与多态不同，当子类初始化时以父类接收，最终会调用父类的函数。
open class View

class Button : View()

fun View.showOff() = println("View。showOff")
fun Button.showOff() = println("Button。showOff")

// 当成员函数和扩展函数名字冲突时，系统会优先调用成员函数
class Object {
    fun dosomethings() = "成员函数做一些事情"
}

fun Object.dosomethings(): String = "扩展函数做一些事情"

// 扩展属性，在一个已知的类中添加一个属性
class Song(val title: String, val year: Int)
// TOTO 这里老师没有讲如何设置扩展属性的方法，暂时注释掉，笔记在低964行
var Song.artist: String
    get() = "腾格尔"
    set(value) {
//        artist = value
    }
