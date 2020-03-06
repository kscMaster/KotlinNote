# KotlinNote



# 1. Kotlin 基础

## 1.1. 激活IDEA
> 在server处输入：http://idea.iteblog.com/key.php
## 应用场景
Java虚拟机、WebKotlinEE、前端开发KotlinJS、Android开发、KotlinNative程序、IOS

## 1.2. 基础语法

### 1.2.1. 基本数据类型

|   类型    |   占用    |   范围    |
|   :----   |   :----:    |   :----:    |
|   Boolean |   1   |   true、false |
|   Byte    |   1   |   -128~127 |
|   Short   |   2   |   -32768~32767 |
|   Char   |   2   |    |
|   Int   |   4   |   -2147483648~2147483647 |
|   Float   |   4   |   小数点可以精确到 6 位 |
|   Double   |   8   |   小数点可以精确到 15-16 |
|   Long   |   8   |   -9223372036854775807 ~ 9223372036854775807 |

### 1.2.2. 利用API查看最大值与最小值
> 以下代码可以利用SDK的API查看最大值和最小值
```kotlin
val minB:Byte = Byte.MIN_VALUE
val maxB:Byte = Byte.MAX_VALUE
val minS:Short = Short.MIN_VALUE
val maxS:Short = Short.MAX_VALUE
val minI:Int = Int.MIN_VALUE
val maxI:Int = Int.MAX_VALUE
val minF:Float = Float.MIN_VALUE
val maxF:Float = Float.MAX_VALUE
val minD:Double = Double.MIN_VALUE
val maxD:Double = Double.MAX_VALUE
val minL:Long = Long.MIN_VALUE
val maxL:Long = Long.MAX_VALUE
```

> Kotlin只有8种数据类型，没有包装类型，在使用中会自动根据场景选择Java对应的类型

> 在IDEA中，打开选择工具栏中Tool-Kotlin-Show Kotlin ByteCode-DeCompile查看Kotlin自动转换成的Java代码

### 1.2.3. kotlin原样输出
> 使用3个”，旨在输入的字符串格式保持不变
```kotlin
val str = """
        |智能
        |类型
        |推断
    """.trimMargin()
    println(str)
/** 输出内容为：
智能
类型
推断
**/
```

### 1.2.4. 去String空格
```kotlin
val space = "   space   "
    println("原格式：$space , 去空格${space.trim()}")
```

### 1.2.5. 字符串比较
```kotlin
    val x1 = "Hello"
    val x2 = String(charArrayOf('H','e','l','l','o'))
    println(x1 == x2) // 值比较， true
    println(x1.equals(x2)) // 值比较， true
    println(x1===x2) // 地址比较，false
```
>  kotlin中，==与equals作用相同

### 1.2.6. 元祖的创建

##### 1.2.6.0.1. 二元元祖 
```kotlin
// 两种创建二元元祖的方式
    val double1 = Pair("张三",20)
    val double2 = "张三" to 20
    println("double1的第一个元素是：${double1.first},第二个元素是${double1.second}")
    println("double2的第一个元素是：${double2.first},第二个元素是${double2.second}")
```
##### 1.2.6.0.2. 三元元祖 
```kotlin
// 三元元祖仅一种方式创建
    val triple1 = Triple("张三", "李四",23)
    println("triple1的第一个元素是：${triple1.first},第二个元素是${triple1.second},第三个元素是${triple1.third}")
```
### 1.2.7. 空指针的处理
1. 可空变量类型：
> 将null赋值给一个任意类型，需要在类型后加?
```kotlin
val string : String? = null
```
2. 空安全调用符
> 若不为空则运行toInt()函数，否则不执行并返回null
```kotlin
string?.toInt()
```
3. 非空断言 !!
> 相当于告诉编译器，这个地方一定不会为空(不建议使用)
```kotlin
string!!.toString()
```
4. ?:Elvis操作符
> 当接收的变量不可为空时，赋值语句需要先转换为可空变量，再再操作符后加?:再加如果为空的值，例如：
> 
```kotlin
    val sr : String? = null
    val result = sr?.toInt()?:0
    println(result)
```
> 以上含义为：
声明一个可空的sr
若sr为空，返回0，若不为空，返回sr.toInt()函数

### 1.2.8. 输入输出
> 循环使用readLine()从控制台读取一行字符串
```kotlin
    // 输入输出
    while (true)
    {
        println("请随意输入内容，回车键结束：")
        var input : String
        input = readLine() ?:"-1" // 若为空则默认值为-1
        println(
            when
            {
                input == "-1" -> "您啥都没输入"
                else -> "您刚刚输入的内容是：${input}"
            }
        )
        Thread.sleep(1000)
    }
```

### 1.2.9. 循环
#### 1.2.9.1. for
##### 1.2.9.1.1. for基础
```kotlin
    val guoji = "我是中国人"
    for (c in guoji) {
        println(c)
    }
    for ((index, value) in guoji.withIndex()) {
        println("$index, $value")
    }
    guoji.forEach {
        println(it)
    }
    guoji.forEachIndexed { index, c ->
        println("$index --> $c")
    }
```
##### 1.2.9.1.2. for循环进阶
###### 1.2.9.1.2.1. for循环标签处跳出 
```kotlin
    // for循环在标签处跳出
    // 在2层for循环内部停止外部for循环时，可使用xx@结束
    // 例如：组合comb1和comb2的元素，使之合并为a1,a2,a3,b1,b2,b3,c1,c2,c3
    // 当等于b2时，停止后面所有的循环：
    val comb1 = "abc"
    val comb2 = "123"
    loop@for (i in comb1)
    {
        for (j in comb2)
        {
            if (i == 'b' && j == '2') break@loop
            println("$i$j" )
        }
    }
```

#### 1.2.9.2. while
> too simply ,setp over
#### 1.2.9.3. do while
> too simply ,setp over 

### 1.2.10. Range定义区间
#### 1.2.10.1. 定义正向区间
```kotlin
    val range1 = 1..100 // 闭区间，最大100 也可使用API：1.rangeTo(5)来声明range1 
    val range2 = 1 until 100 // 开区间，最大99
    val range3 = 'A' ..'Z'
    val range4 = 'A' until 'Z'
    val range5 = 1L .. 10L
```
#### 1.2.10.2. 定义反向区间
```kotlin
    var range = 10 downTo 1
```
#### 1.2.10.3. 定义区间的反转
```kotlin
    var range = 1 until 10
    range.reversed().forEach{
        println("$it")
    }
```
### 1.2.11. 定义区间的反转
```kotlin
    var range = 1 until 10
    range.reversed().forEach{
        println("$it")
    }
```
### 1.2.12. if基本语法
```kotlin
fun compareInt(a: Int, b: Int): Int {
    return if (a > b) a else b
}
fun compareInt2(a: Int, b: Int) = {
    if (a > b) a else b
}
```
### 1.2.13. 数组
```kotlin
    charArrayOf('c','t')
    booleanArrayOf(true,true,false)
    shortArrayOf(1,2,3)
    byteArrayOf(1,2,3,4)
    intArrayOf(1,2,3,4,5)
    longArrayOf(1L,2L)
    floatArrayOf(1.2f,2.1f)
    doubleArrayOf(1.22,2.1)
    arrayOf("s","t")
    list[2] = 10
    list.set(2, 20) 
```

### 1.2.14. when
#### 1.2.14.1. 有参，in区间判断
```kotlin
fun returnParm(x: Int): String {
    return when (x) {
        in 1..6 -> "未上学" // 使用in关键字表示区间
        7 -> "小学"
        in 8..11 -> "正在上小学"
        12 -> "初中"
        13,14 -> "正在上初中"
        15 -> "高中"
        16,17,18 -> "正在读高中"
        19 -> "大学"
        else -> "毕业"
    }
}
```
> 当传入的参数带有范围，可使用关键字 *in* 表示 
> 条件相同的情况下可使用 *,*分割
> 在函数体内，最后一行为返回值
> 当参数判断比较简单时，kotlin会转换成Java的Switch语句；复杂的情况下，会转换成if else语句

#### 1.2.14.2. 无参，in区间判断
```kotlin
fun returnParm2(age: Int): String {
    return when {
        age is Int -> "没毛病"
        age in 1..6 -> "未上学" // 使用in关键字表示区间
        age == 7 -> "小学"
        age in 8..11 -> "正在上小学"
        age == 12 -> "初中"
        age == 13 || age == 14 -> "正在上初中"
        age == 15 -> "高中"
        age == 16 || age == 17 || age == 18 -> "正在读高中"
        age == 19 -> "大学"
        else -> "毕业"
    }
}
```

### 1.2.15. 函数表达式
#### 1.2.15.1. 定义函数
> 当函数体仅有一行的时候，可以省略return、{},函数的返回值也可以省略掉。例如：
```kotlin
fun add1(a: Int, b: Int): Int {
    return a+b
}
fun add2(a: Int, b: Int) = a + b
```
#### 1.2.15.2. 定义函数变量(可以直接定义并调用)
语法结构为：val fun:(数据类型1，数据类型2，) -> 返回数据类型 = {parm1,parm2 -> parm1 + parm2}
```kotlin
    val add3: (Int, Int) -> Int = { a, b -> a + b }
    sum = add3(a,b)
    println(sum)
```
#### 1.2.15.3. 默认参数
> 当传入的参数有默认值的时候，调用时可以不写参数
```kotlin
fun hello(name: String = "陌生人", age: Int = 0): String {
    return "hello,$name,你今年$age 岁了"
}
fun main() {
    hello()
    hello(name = "dwad") // 具名参数
    hello(age = 99) // 具名参数
}
```
#### 1.2.15.4. 可变参数 vararg
> 当需求发生变化时，原有的函数需要增加或删除形参，此时需要用到可变参数
```kotlin
fun add3(vararg parms: Int): Int {
    var sum = 0
    parms.forEach { sum += it }
    return sum
}
// 调用
println("集合和为：${add3(1, 2, 3, 4, 5, 5, 6, 4)}")
```

### 1.2.16. 异常处理
> 当函数体仅有一行的时候，可以省略return、{},函数的返回值也可以省略掉。例如：
```kotlin
fun add1(a: Int, b: Int): Int {
    return a+b
}
fun add2(a: Int, b: Int) = a + b
```
### 1.2.17. 递归
#### 1.2.17.1. 求n的阶乘
```kotlin
// 求 n的阶乘
// n*(n-1) * (n-2)...1
fun jieCheng(num: Int): Int {
    if (num == 1) return num
    return num * jieCheng(num-1)
}
// 调用
fun main() {
    println(jieCheng(6))
}
```
#### 1.2.17.2. 求斐波那契数列
```kotlin
// 1 1 2 3 5 8 13 21 34 55
fun feiBoNaQie(n: Int): Int {
    if (n == 1 || n == 2) return 1
    return feiBoNaQie(n - 1) + feiBoNaQie(n - 2)
}
// 调用
fun main() {
    println(feiBoNaQie(6))
}
```
#### 1.2.17.3. 求1.。100的和
```kotlin
// 求1..100的和
fun sum(n: Int): Int {
    if (n == 1) return n
    return n + sum(n-1)
}
// 调用
println(sum(100))
```
> 如果次数太多，通过递归的方式会导致栈内存溢出，说明递归对于内存的开销比较大，尽量使用普通的循环迭代方式，同时，可通过优化递归来减小内存开销
#### 1.2.17.4. 尾优化递归(仅在kotlin中生效)
> 尾递归：调用当前函数没有做其他任何偶作,并在方法前加修饰词tailrec
> 若要实现递归优化，有两个条件：
1. 递归变形为尾递归
2. 使用tailrec修饰递归函数
##### 1.2.17.4.1. 尾递归优化原理：转换为了Java的while迭代循环
```kotlin
// 求1..100000的和
tailrec fun sumPro(n: Int, preSum : Int = 0): Int {
    if (n == 1) return n + preSum
    return sumPro(n-1, preSum + n)
}
// 调用
println(sumPro(100000))
```
### 1.2.18. 面向对象

### 1.2.19. 运算符
```kotlin
    a.plus(b) // a+b
    a.minus(b) // a-b
    a.times(b) // a*b
    a.div(b) // a/b
    a.rem(b) // a%b
```
#### 1.2.19.1. 基本运算符

```kotlin
    var a = 0
    var b = 0
```
|   使用运算符  |   函数名      |   
|   ----        |    ----       |
|     a+b          |       a.plus(b)        |
|     a-b          |       a.minus(b)        |
|     a*b          |       a.times(b)        |
|     a/b          |       a.div(b)        |
|     a%b          |       a.rem(b)        |
|     a += b          |       a.plusAssign(b)        |
|     a -= b          |       a.minusAssign(b)        |
|     a *= b          |       a.timesAssign(b)        |
|     a /= b          |       a.divAssign(b)        |
|     a %= b          |       a.remAssign(b)        |

#### 1.2.19.2. 一元运算符
|   使用运算符  |   函数名      |   
|   ----        |    ----       |
|     +a          |       unaryPlus        |
|     -a          |       unaryMinus        |
|     !a          |       not        |
|     ++a,a++          |        	inc        |
|     --a,a--          |       dec       |
#### 1.2.19.3. 比较运算符
##### 1.2.19.3.1. 等号运算符
|   使用运算符  |   函数名      |   
|   ----        |    ----       |
|     ==          |       equals        |
|     !=          |       !equals        |
##### 1.2.19.3.2. 排序运算符
|   使用运算符  |   函数名      |   
|   ----        |    ----       |
|     >,<,>=,<=          |       compareTo        |
compareTo的返回类型必须为Int。所有Java中实现了Comparable接口的类，都可以在Kotlin中使用排序运算符语法。

> a >= b 会被转换成 a.compareTo(b) >= 0

##### 1.2.19.3.3. 使用运算符重载实现对象的加减操作
```kotlin
// 定义一个Teacher对象，属性level分别为1、2、3、4分别对应助教，讲师，副教授，教授。属性saraly为薪资
// 下面对该对象进行++操作，需要实现inc()函数即可，同时需要用opreator修饰，这样就可以在外部调用该函数实现++操作了
class Teacher
{
    var level = 1
    var saraly = 1000
    operator fun inc() : Teacher
    {
        level ++
        saraly +=500
        return this
    }
}
// 调用
    var 助教 = Teacher()
    println("助教等级${助教.level}的工资是${助教.saraly}")
    val 讲师 = 助教++
    println("老师等级${讲师.level}的工资是${讲师.saraly}")
    val 副教授 = 讲师.inc()
    println("副教授等级${副教授.level}的工资是${副教授.saraly}")
    val 教授 = 副教授.inc()
    println("教授等级${教授.level}的工资是${教授.saraly}")
```

### 1.2.20. 面向对象基本知识
创建一个对象
#### 1.2.20.1. 对象的主构造函数
```kotlin
class Student2(var name:String,var age:Int)
```
#### 1.2.20.2. 对象的次构造函数
```kotlin
// 定义主构造函数
class Student4(var name:String,var age:Int)
{
    // 定义次构造函数，':this'表示调用主构造函数，并将参数传递过去
    constructor(name: String,age: Int, contact:String):this(name, age)
}
// 2种调用方式
val  student1 = Student4("张三", 80)
val  student2 = Student4("张三", 80, "186105234342")
```
但以上的对象无法调用次构函数中的contact属性，需要继续修改：
```kotlin
class Student5(var name: String,var age: Int)
{
    var contact : String = ""
    constructor(name: String,age: Int,contact: String):this(name, age)
    {
        this.contact = contact
    }
}
```
#### 1.2.20.3. init
```kotlin
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
// 调用：
    Student6("adw", 33)
    Student6("adw", 33,"231231")
/* 执行结果：
每次对象被创建，都会执行一次init()方法。可以把一些初始化的操作放到该方法里
每次对象被创建，都会执行一次init()方法。可以把一些初始化的操作放到该方法里
*/ 
```
结论：每次对象被创建，都会执行一次init()方法。可以把一些初始化的操作放到该方法里，无论是主构函数还是次构函数
> 调用顺序：先执行主构函数，再创建次构函数。也就是说先执行init再执行constructor的次构函数

#### 1.2.20.4. 修改访问器的可见性
```kotlin
class Student {
    // 若要隐藏setName，需要在字段后加private set
    var name: String? = null
    private set
    private var age : Int = 0 // 若要隐藏get和set直接在var前加private
}
```
### 1.2.21. 面向对象3大特征
面向对象3大特征：封装、继承、多态
#### 1.2.21.1. 封装
隐藏内部细节实现，暴露功能接口
在方法前加private是最简单的封装
```kotlin
class Restaurant {
    fun order() {
        getTicket()
        notifyCooker()
        cooking()
        done()
    }

    private fun getTicket() {
        println("getOrder")
    }

    private fun notifyCooker() {
        println("notifyCooker")
    }

    private fun cooking() {
        println("Cooking")
    }

    private fun done() {
        println("Complete")
    }
}
// 调用，如此，内部实现的接口便可以隐藏了
    val restaurant = Restaurant()
    restaurant.order()
```
#### 1.2.21.2. 继承
继承的方式：
1. 在父类增加 *open* 关键字(默认不可继承)
2. 子类使用 *Son : Father* 来实现继承
3. 子类可以使用父类的属性和方法
4. 无论是复写属性和方法，都需要父类用*open*关键字修饰，同时子类使用*override*重写
#### 1.2.21.3. 不带构造函数的继承
```kotlin
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
// 调用
    val son = Son()
    // 子类可以访问父类的属性和方法
    println("姓${son.surname}的${son.name}年龄是${son.age}岁")
    // 方法可以被重写
    son.work()
```
#### 1.2.21.4. 单纯的抽象类
单纯的抽象类不需要再父类前加*open*，取而代之的是*abstract*关键字，同时在父类的抽象方法前也需要加关键字*abstract*
一个类只能有一个抽象方法
抽象方法也不需要加*open*也可以被继承
详见 带构造函数的继承 = [带构造函数的继承](@带构造函数的继承 "带构造函数的继承")
#### 1.2.21.5. 带构造函数的继承
带构造函数的继承需要将子类的值再次传递给父类，写法如下：
```kotlin
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
// 调用
    val man = Man("男人",20, 0)
    man.features()
    man.hobby()
    val woman = Woman("女人", 18,1,"18548383929")
    woman.features()
    woman.hobby()
/* 运行结果
会活动有大脑有思考的生命
长了个丁丁
吃饭的样子很狂野
会活动有大脑有思考的生命
没长丁丁
吃饭的样子很淑女
*/
```

#### 1.2.21.6. 接口
代表（对象）事物代表的能力
定义了接口后，在对象的后面加*，interface*并实现接口的方法即可
> 当父类实现了某一接口时，它的子类也必须实现这个接口的方法
> 类可以实现多个接口，接口可以实现方法，实现了接口的类可以不去实现该接口的方法，也可以覆盖
```kotlin
interface Ride {
    fun rideBike()
}
// 父类 实现了 接口*Ride*
interface Ride {
    fun rideBike()
}
interface Drive{
    fun driveCar() = println("未成年人不能考驾照呢")
}
// 父类 实现了 接口*Ride*
abstract class People(
    var name: String = "人类",
    var age: Int = 100000000,
    var gender: Int = -1,
    var contact: String? = null): Ride {
    open fun features() = println("会活动有大脑有思考的生命的统称")
    abstract fun hobby()
}
// 子类成年人不实现父类的接口编译器报错
class Adult(name: String, age: Int, gender: Int) : People(name, age, gender),Drive {
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
class Juveniles(name: String,age: Int,gender: Int,contact: String?) : People(name, age, gender, contact),Drive
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
// 调用
    val ad = Adult("成年人", 19, 0)
    ad.features()
    ad.hobby()
    ad.rideBike()
    ad.driveCar()
    val ju = Juveniles("未成年人", 12, 1,"18614838383")
    ju.features()
    ju.hobby()
    ju.rideBike()
    ju.driveCar()
/**
会活动有大脑有思考的生命的统称
胡子很粗
爱好广泛
很快就学会了骑自行车
没长胡子
吃饭
学骑自行车很慢
 */
```
#### 1.2.21.7. 多态
同种功能的不同表现形式
> 通过父类接收子类对象，还是会实现子类的方法
```kotlin
open  class Animals {
    open fun voice() = println("动物叫的方法")
}
class Cat : Animals() {
    override fun voice() {
        println("meow")
    }
}
class Dog : Animals() {
    override fun voice() {
        println("woof")
    }
}
// 调用
    val animals = Animals()
    animals.voice()
    val dog:Animals = Dog() // 即使强转为父类接收，最终也会调用子类的方法
    dog.voice()
    val cat = Cat()
    cat.voice()
/*
动物叫的方法
woof
meow 
*/
```
> 即使子类创建的时候强转为父类接收，最终也只会调用子类的方法
### 1.2.22. 面向对象高阶
#### 1.2.22.1. 智能类型推断
```kotlin
// 类型推断
open class IAnimals
class IDog : IAnimals() {
    fun woof() =
        println("woof woof woof")
}
class ICat : IAnimals() {
    fun meow() = println("meow meow meow")
}
// 调用
    val dog : IAnimals = IDog()
    val cat : IAnimals = ICat()
    if (dog is IDog) //如果是IDog类型，则不需要再写dog as IDog来强转了
    {
//        dog as IDog
        dog.woof()
    }
    if(cat is ICat) //如果是IDog类型，则不需要再写cat as ICat来强转了
    {
//        cat as ICat
        cat.meow()
    }
```

#### 1.2.22.2. 嵌套类
在类里面嵌套class
> 嵌套类不依赖外部类，因此不可以访问外部的属性或函数
```kotlin
// 嵌套类无法访问外部类的属性或函数，是因为生成了Java的static final的内部类
class OutClass {
    val name: String = "asdf"
    class innerClass {
        fun say() = println("fdsa")
    }
}
// 调用
    val innerClass = OutClass.innerClass()
    innerClass.say()
```
#### 1.2.22.3. 内部类inner,相当于是java的内部类
当在嵌套类class前加*inner*关键字后，该嵌套类就变成了内部类。
```kotlin
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
// 同属性名情况下下，默认调用内部类的属性
    val inClass = OutClass2().innerClass2()
    inClass.say()
    inClass.sayOutParm()
    inClass.sayOutFun()
/*
fdsa
asdf
外部类
*/
```

### 1.2.23. 泛型
#### 1.2.23.1. 泛型基础
定义一个不知道具体类型的对象，在使用的时候定义具体类型
```kotlin
// 定义一个基本的泛型父类
open class Father<T> (val anyThings : T)
// 子类可以继承泛型父类。当子类知道具体类型时，可以直接指定其类型
class Son<bool : Boolean> : Father<Boolean>(bool)
// 子类不知道具体类型时，也可以传泛型
class Daughter<anythings : T> : Father<T> (anythings)
// 调用
    val boxPerson = Box<Person>(Person())
    println(boxPerson.anyThings.name)
    val boxBoolean = Box<Boolean>(true )
    val sonBox = SonBox(1)
    val daughter = Daughter<Person>(Person())
```
#### 1.2.23.2. 泛型函数
```kotlin
// 传递任意类型，打印出传递的类型
fun <T>parseType(type: T){
    when (type)
    {
        is String -> println("${type}是String类型")
        is Int -> println("${type}是Int类型")
        is Char -> println("${type}是Char类型")
        is Boolean -> println("${type}是Boolean类型")
        else -> println("${type}是其他非法类型")
    }
}
// 调用
    parseType('A')
    parseType("BB")
    parseType(10)
    parseType(true)
```
### 1.2.24. 中缀表达式 infix
```kotlin
// 在类里的函数加上infix称为中缀表达式，条件：类里函数的参数仅有1个的情况下
class Welcome {
    infix fun sayHello(name: String): Unit {
        println("hello,$name")
    }
}
    // 调用方法：对象、函数名。参数
    val welcome = Welcome()
    welcome.sayHello("鲍勃")
    welcome sayHello "宝宝"
```
### 1.2.25. 委托 by
#### 1.2.25.1. 类委托
将一个函数的实现交给另一个类去做
##### 1.2.25.1.1. 方式1
```kotlin
interface Clean{
    fun washDishes()
}
// 丈夫洗碗
class Hasband : Clean
{
    override fun washDishes() {
        println("丈夫来洗碗")
    }
}
// 妻子将洗碗的方法委托给丈夫去洗
class Wife : Clean by Hasband()
// 调用
Wife().washDishes()
/* 输出
丈夫来洗碗
*/
```
##### 1.2.25.1.2. 方式2 传递参数的类委托
```kotlin
interface Clean{
    fun washDishes()
}
class Son : Clean {
    override fun washDishes() = println("儿子来洗碗")
}
class Father(val son :Son) : Clean by son
// 调用
Father(Son()).washDishes()
```
#### 1.2.25.2. 属性委托
在属性后加*by xxx*，其中xxx是另一个类
场景：爷爷给孙子100元利是，爸爸从中扣取一部分，剩余的是孙子实际可支配的金额
```kotlin
class Grandson {
    var money: Int by Father1() // 委托属性
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
// 爷爷给孙子钱以及孙子展示自己的钱的过程
    val grandson = Grandson()
    grandson.money = 100
    grandson.showMoney()
// 结果：孙子的压岁钱是：50
```
### 1.2.26. 延迟加载 by lazy
只创建一次，并且在加载的时候再创建，它是线程安全的
```kotlin
    val str by lazy {
    println("初始化")
    "张三"
}
// 调用
    println(str)
    println(str)
```
### 1.2.27. 扩展函数
#### 1.2.27.1. 示例1 
```kotlin
fun String.isEmptyOrNull(): String =
    if (this.isNullOrEmpty()) {
        "是空的"
    } else "不是空的"
// 调用
    val a: String? = ""
    println(a?.isEmptyOrNull())
```
#### 1.2.27.2. 示例2
> 与多态不同，当子类初始化时以父类接收，最终会调用父类的函数。
```kotlin
open class View
class Button:View()
fun View.showOff() = println("View。showOff")
fun Button.showOff() = println("Button。showOff")
// 调用
    val v :View = Button()
    v.showOff()
    val b : Button = Button()
    b.showOff()
/* 输出
View。showOff
Button。showOff
*/
```
#### 1.2.27.3. 示例3 当成员函数与扩展函数名相同时的情况
> 当成员函数和扩展函数名字冲突时，系统会优先调用成员函数
```kotlin
// 当成员函数和扩展函数名字冲突时，系统会优先调用成员函数
class Object {
    fun dosomethings() = "成员函数做一些事情"
}
fun Object.dosomethings() : String = "扩展函数做一些事情"
// 调用
    val obj = Object()
    println(obj.dosomethings())
/** 输出结果
 * 成员函数做一些事情
*/
```
#### 1.2.27.4. 示例4 扩展属性
在一个已知的类中添加一个属性，属性声明时不可直接赋值
```kotlin
class Song(val title: String, val year: Int)

var Song.artist: String
    get() = "腾格尔"

// 调用
    val song = Song("千年泪", 2005)
    println("这首歌《${song.title}》是由艺术家${song.artist}于${song.year}年发行的"
/* 输出：
这首歌《千年泪》是由艺术家腾格尔于2005年发行的
 */
```
一个最简单的单例，在将class替换为object即可，但里面的属性都可以访问，可以利用伴生对象解决
### 1.2.28. 单例
> 对象在内存中仅有一个实例
> 方法：将当前class修饰词 替换为 object即可
> 使用：不可以新建实例，直接用类.属性或者函数调用
```kotlin
object SingleInstance
{
    var name :String = "张三"
    val age :Int = 0
    fun dothings() = println("名字是${name}")
}
// 调用
    println(SingleInstance.name)
    SingleInstance.dothings()
    SingleInstance.name = "猪头"
    println(SingleInstance.name)
/* 输出：
张三
名字是张三
猪头
 */
```

下面使用Java实现一个单例模式：
```java
public class Single {
    // 1.私有构造函数
    private Single() {
    }
    // 2.对象引用
    private static Single single = null;
    // 3.提供静态方法获取对象引用属性
    private static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) single = new Single();
            }
        }
        return single;
    }
}
```
使用Kotlin写一个标准的单例模式：
```kotlin
// 使用Kotlin完成一个标准的单例模式：
class Singlet private constructor() {
    val name = "张胜男"
    // 私有构造函数
    companion object {
        val sing: Singlet by lazy { Singlet() }
    }
    fun printName() = println("$name")
}
// 调用
    val singl = Singlet.sing
    println(singl.name)
    singl.printName()
/* 输出：
张胜男
张胜男
 */
```

### 1.2.29. 伴生对象
有些类的属性希望可以在外部直接使用，因此可以使用伴生对象来解决
```kotlin
class BeanData {
    val name: String = "张三" // 需要创建对象访问
    companion object InnerClass {// 类名可以省略
        val age = 10 // 可以直接调用
        fun sayHello() = println("奥利给")
    }
}
// 调用
    BeanData.age
    BeanData.InnerClass.age
    BeanData.sayHello()
    val bd = BeanData()
    bd.name
```
### 1.2.30. 枚举
#### 1.2.30.1. 基本使用：一般用在判断的地方
```kotlin
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
// 调用
  todo(Week.周一)
```
#### 1.2.30.2. 进阶用法
> 枚举作为对象使用
```kotlin
enum class Parents(var pName:String, var age:Int){
    ZS("张三",20),
    LS("李四",30),
    WMZ("王麻子",40)
}
// 调用
    val p = Parents.ZS
    println("${p.age}岁的人是${p.pName}")
/* 输出：
20岁的人是张三
 */
```
### 1.2.31. 数据类
> 类似于JavaBean类，只保存数据，不包含任何逻辑的类,只需要使用*data*修饰class即可自动实现**equals()**、**hashCode()**、**toString()**、**copy()**(可以将当前对象拷贝一份)
```kotlin
data class Sms(val time:Long,val from:String,val content:String)
// 调用
    val sms1 = Sms(1111111L,"李波", "我是个短信内容")
    val sms2 = Sms(1111111L,"李波", "我是个短信内容")
    println(sms1.hashCode().equals(sms2.hashCode()))
    println(sms1.equals(sms2))
    println(sms1.toString())
/* 输出：
true
true
Sms(time=1111111, from=李波, content=我是个短信内容)
 */
```
### 1.2.32. 密封类
使用sealed包装，将一部分属性包含到类中，另一部分放在外部
> 密封类关注的是数据的类型，枚举关系的是数据的值
```kotlin
sealed class Parent {
    class Son1 : Parent()
    class Son2 : Parent()
    class Son3 : Parent()
}
class Son4 : Parent()
fun isQinSon(s: Parent): String {
    return when (s) {
        is Parent.Son1 ,is Parent.Son2, is Parent.Son3 -> "我亲儿子"
        else -> "不是我亲儿子"
    }
}
// 调用
    println(isQinSon(Parent.Son3()))
    println(isQinSon(Son4()))
/* 输出：
我亲儿子
不是我亲儿子
 */
```
### 1.2.33. 集合
> Any相当于Java里的Object
#### 1.2.33.1. 集合基础
```kotlin
    // 通过listOf创建的集合是一个不可修改的集合，只读不写
    var anyListOnlyRead = listOf<Any>("zhangsan","",true,1);
    println("${anyListOnlyRead.get(0)} : ${anyListOnlyRead[0]}")
    // 当元素不确定或需要修改的时候，使用mutableListOf
    var anyListReadWrite = mutableListOf<Any>("zhangsan","",true,1)
    anyListReadWrite.add("赵信")
    anyListReadWrite[0] = "张三"
    println("${anyListReadWrite.get(0)} : ${anyListReadWrite[0]}")

    //    ArrayList、LinkedList、Vector
    var arrayList = arrayListOf<Any>("zhangsan","",true,1) // 线程不安全，适用于单线程
    var linkedList = LinkedList<Any>() // 线程不安全，适用于单线程
    linkedList.add("zhangsan")
    var vector = Vector<String>() // 线程安全，适用于多线程
    vector.add("娃娃")

// 遍历
    var bl = listOf<Any>("aa", 'c',true,1);
    for (aa in bl) {
        println(aa)
    }
    for ((index, value) in bl.withIndex()) {
        println("${index}:${value}")
    }
    bl.forEach { it }
    bl.forEachIndexed { index, value ->  println("${index}:${value}")}
```
#### 1.2.33.2. 集合高阶
##### 1.2.33.2.1. 集合过滤
> 取出'张'姓的人
```kotlin
    // 取出'张'姓的人
    val all = listOf<String>("张三","张5","李四","李4","王五","王5")
    val zhang = all.filter { it.startsWith("张") }
    println(zhang)
```
> 将多个集合中特定的元素放到同一个集合中 *mutableList*
```kotlin
    val list1 = listOf<String>("张三","张5","李四","李6","王五","王7")
    val list2 = listOf<String>("张4","张6","李5","李7","王6","王8")
    var mutableList = mutableListOf<String>()
    list1.filterTo(mutableList){ it.startsWith("张") }
    list2.filterTo(mutableList){it.startsWith("张")}
    println(mutableList)
```
> 过滤角标为偶数的元素
```kotlin
val ouShu = list1.filterIndexed { index, s -> index%2 == 0 }
```
##### 1.2.33.2.2. 集合排序
```kotlin
    // 类型排序
    println(list1.sorted()) // 正序
    println(list1.sortedDescending()) // 倒序
    // 对象排序
    class Man(var name:String,val age:Int)
    var humans = listOf<Man>(
        Man("张三", 34)
        ,Man("李四",33)
        ,Man("王麻子",32)
        ,Man("潘金莲",31)
        ,Man("西门庆",30)
    )
    println(humans.sortedBy { it.age }) // 正序
    println(humans.sortedByDescending { it.age }) // 倒序
    // 自定义比较器,需要传递一个比较规则，
    println(humans.sortedWith(object : Comparator<Man> {
        override fun compare(o1: Man, o2: Man): Int {
            return o1.age - o2.age
        }
    }))
```
> *Comparator* 是一个匿名类，需要加上*object*修饰
总结：基本类型可以使用*sorted()*或*sortedDescending()*函数，对象中某个类型排序可以使用*sortedBy*或*sortedByDescending*调用，自定义比较器使用*sortWith()*调用，需要传递一个*object : Comparator<Class>)*方法并重写*compare()*比较函数
##### 1.2.33.2.3. 集合分组
```kotlin
    // 将不同的姓氏分组存放
    val listName = listOf<String>("张三","张5","李四","李6","王五","王7")
    val mapName = listName.groupBy{
        when
        {
            it.startsWith("张") -> "张氏"
            it.startsWith("李") -> "李氏"
            it.startsWith("王") -> "王氏"
            else -> "未知"
        }
    }
    println(mapName)
```
#### 1.2.33.3. joinToString 自定义输出格式  
```kotlin
/*joinToString*/
    println(humans.joinToString(separator = "|", prefix = "(", postfix = ")"))
```
### 1.2.34. Map
> key值不可重复，否则会覆盖
```kotlin
    val country1 = mapOf("China" to "中国", "American" to "美国")
    println(country1["China"])
    // 可写
    var country2 = mutableMapOf("China" to "中国", "American" to "美国")
    country2.put("Japan" , "小日本")
    println(country2)
```
> 遍历的几种常见的方式
```kotlin
// 遍历1
    for (entry in country1) {
        println("${entry.key}:${entry.value}")
    }
    // 遍历2
    country2.entries.forEach {
        println("${it.key}:${it.value}")
    }
    // 遍历3
    for ((key, value) in country1) {
        println("${key}:${value}")
    }
    // 遍历4 单独获取key
    for (key in country1.keys) {
        println(key)
    }
    // 遍历5 单独获取value
    for (value in country1.values) {
        println(value)
    }
    // 遍历6 迭代器
    val it = country2.iterator()
    while (it.hasNext()) {
        val next = it.next()
        println("${next.key}:${next.value}")
    }
```
### 1.2.35. 闭包
一个函数返回了一个内部函数，该内部函数引用了外部函数的相关变量和参数，我们把该返回的内部函数称作闭包
> kotlin的函数是有状态的，比如使用闭包
> kotlin里的闭包一般是指lambda表达式
```kotlin
// 函数返回一个无参无返回值的函数
fun close() : () -> Unit{
    var a = 10
    return {
        println(a++)
    }
}
// 调用
    val c = close()
    c()
    c()
    c()
    c()
/* 输出：可以看到，外部函数的变量a是一直在变化的，因为闭包引用了外部函数的内的变量，这使得函数会保持一定的状态
10
11
12
13
 */
```
### 1.2.36. 高阶函数
函数本身需要再传入一个函数。这种函数称为高阶函数
> 调用高阶函数时，需要传入函数的地方使用*::*+fun 实现引用，若使用*fun()*相当于调用
```kotlin
// 一般函数
fun plus(a: Int, b: Int): Int = a + b
fun sub(a: Int, b: Int): Int = a - b
// 高阶函数实现方式,传入一个函数
// block:(Int,Int)->Int是一个函数，传入2个参数，返回一个参数
fun cacl(a: Int, b: Int, block: (Int, Int) -> Int): Int {
    return block(a, b)
}
// 调用
    val a = 10
    val b = 20
    var sum = 0 // a与b的和
    var sub = 0 // a与b的差
    // 调用高阶函数时，需要传入函数的地方使用*::*+fun 实现引用，若使用*fun()*相当于调用
    sum = cacl(a, b, ::plus)
    sub = cacl(a, b, ::sub)
    println(sum)
    println(sub)
/* 输出：
 */
```
### 1.2.37. Lambda表达式
#### 1.2.37.1. lambda表达式单独存在
> lambda表达式返回值是表达式中的最后一行 
##### 1.2.37.1.1. 无参情况下：
```kotlin
    /*无参的lambda单独存在*/
    { println("此行代码不会执行，相当于只定义了一个lambda表达式，但没有调用") }
    { println("此行代码会执行。在定义后的lambda表达式后加括号相当于调用了表达式") }();
```
##### 1.2.37.1.2. 有参情况下：
```kotlin
    // 不执行的有参lambda表达式
    { a: Int, b: Int ->
        a + b
    }
    // 执行的有参lambda表达式,表达式后加括号表示调用，在调用时传入参数即可
    val result = { a: Int, b: Int ->
        a + b
    }(3, 6)
    println("result=$result")
```
#### 1.2.37.2. 高阶函数与lambda表达式同时使用
> lambda表达式就是匿名函数，也就是说函数没有名字
```kotlin
//高阶函数，传入两个Int类型和一个函数，返回Int
fun caclary(a: Int, b: Int, block: (Int, Int) -> Int): Int {
    return block(a, b)
}
// 调用
    val a = 10
    val b = 20
    // 使用匿名函数代替传统的函数
    val sum = caclary(a, b, { a, b ->
        a + b
    })
    // 如果调用的函数是最后一个参数，则括号可以前移，单独将函数放置在外部
    val sub = cacle(a,b) {a,b -> a-b}
/* 输出：
30
-10
 */
```
#### 1.2.37.3. it的使用
> 当传入的高阶函数仅有1个参数时，可以直接使用it
```kotlin
fun add30(a: Int, blook: (Int) -> Unit) = blook(a + 30)
// 调用
val num = 10
    add30(num) { a -> println("a的值最后变成了${a}") }
    // 当传入的高阶函数仅有一个参数时，可以省略传入的形参，使用时用it来代替
    add30(num) { println("a的值最后变成了${it}") }
/* 输出：a的值最后变成了40
 */
```
#### 1.2.37.4. lambda表达式访问外部变量、属性
```kotlin
    /* lambda表达式访问外部属性 */
    // 在kt中，函数与类都是一等公民
    val who = "哪吒"
    {
        println(who)
    }()
```
### 1.2.38. 总结
#### 1.2.38.1. apply{}表达式
> 任意类型、属性都具有一个函数*apply()*
```kotlin
    // 1.任意类型都有apply()扩展函数
    // 2.apply扩展函数内部的作用域只有其内部本身
    // 3.它的返回值就是自己本身
    var list = mutableListOf("张","王","李","赵","周","武","郑","孙")
    list.apply {
        this.add("钱")
        add("马")
    }.add("黄")
    // 在实际开发中，有时频繁操作某个属性时需要反复判断是否为空 xx.?
    // 因此可以使用apply{}扩起来，一次判断多次使用
```
// TODO
#### 1.2.38.2. let{}表达式
#### 1.2.38.3. with{}表达式
#### 1.2.38.4. last{}表达式
#### 1.2.38.5. binarySearch{}表达式

### 1.2.39. filter实战
```kotlin
val list = getPersonRepository() // 获取到数据源
    /* 统计广东省人数 */
    val gds = list.filter {
        it.province == "广东省"
    }
    println("广东省的人数是：${gds.size}")

    /* 统计广东省男人人数 */
    val gdMale = list.filter {
        it.province == "广东省" && it.sex == "男"
    }
    println("广东省有${gdMale.size}个男人")

    /* 统计20-35岁女人人数 */
    // 获取当前年份，得到20-35岁年份的区间
    val nowYear = Calendar.getInstance().get(Calendar.YEAR)
    val down = nowYear - 35
    val up = nowYear - 20
    println("20-35岁的女人有${list.filter {
        val birthday = it.idNum.substring(6, 10).toInt() //得到出生日期
        birthday in down..up && it.sex == "女"
    }.size}位")

    /* 统计2016.2.13-2016.2.15的人数 */
    // 1.转换2016.2.13-2016.2.15为long时间
    val sdf = SimpleDateFormat("yyyy-MM-DD")
    val startTime = sdf.parse("2016-02-13").time
    val endTime = sdf.parse("2016-02-15").time
    val rangeList = list.filter {
        it.startTime in startTime..endTime
    }
    println("这段时间开放的信息是${rangeList.size}")

    /* 统计2016.2.13-2016.2.15中范冰冰的开房信息 */
    val fbb = rangeList.filter {
        it.name == "范冰冰"
    }
    println("2016.2.13-2016.2.15中范冰冰的开房信息有${fbb.size}条")

    /* 统计2016.2.13-2016.2.15中范冰冰的开房信息,并根据开房信息分类 */
    val grouping = fbb.groupBy {
        it.hotel
    }
    // 打印
    grouping.forEach { (key, value) ->
        for (c in value) {
            println("${key}: ${c.name}--${c.idNum} - ${c.startTime}")
        }
    }

    /* 统计2016.2.13-2016.2.15中范冰冰的开房信息,并根据时间排序 */
    val sort = fbb.sortedBy { it.startTime }
    for (c in sort) {
        println("根据时间排序后${c.startTime}")
    }

```