package 基础

fun main() {

val stud = Student1()
    println(Student3(name = "dwdawda").name)

    val  student1 = Student4("张三", 80)
    val  student2 = Student4("张三", 80, "186105234342")
    var studend5 = Student5("王麻子", 87, "12321312")
    println(studend5.contact)
    studend5.contact = "000012312"
    println(studend5.contact)

    Student6("adw", 33)
    Student6("adw", 33, "231231")


}

class Student1 {
    // 若要隐藏setName，需要在字段后加private set
    var name: String? = null
    private set
    private var age : Int = 0 // 若要隐藏get和set直接在var前加private
}
class Student2(var name:String,var age:Int)
class Student3(var name:String = "aaa",var age:Int = 0)

// 定义主构造函数
class Student4(var name:String,var age:Int)
{
    // 定义次构造函数，':this'表示调用主构造函数，并将参数传递过去
    constructor(name: String,age: Int, contact:String):this(name, age)
}

class Student5(var name: String,var age: Int)
{
    var contact : String = ""
    constructor(name: String,age: Int,contact: String):this(name, age)
    {
        this.contact = contact
    }
}
class Student6(var name: String,var age: Int)
{
    var contact : String = ""
    constructor(name: String,age: Int,contact: String):this(name, age)
    {
        this.contact = contact
    }
    init {
        println("每次对象被创建，都会执行一次init()方法。可以把一些初始化的操作放到该方法里")
    }
}