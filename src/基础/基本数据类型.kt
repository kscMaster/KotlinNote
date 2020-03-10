package 基础

fun main() {
    println("基础.hello")
    val minB: Byte = Byte.MIN_VALUE
    val maxB: Byte = Byte.MAX_VALUE
    val minS: Short = Short.MIN_VALUE
    val maxS: Short = Short.MAX_VALUE

    val minI: Int = Int.MIN_VALUE
    val maxI: Int = Int.MAX_VALUE
    val minF: Float = Float.MIN_VALUE
    val maxF: Float = Float.MAX_VALUE
    val minD: Double = Double.MIN_VALUE
    val maxD: Double = Double.MAX_VALUE
    val minL: Long = Long.MIN_VALUE
    val maxL: Long = Long.MAX_VALUE

    val name = "智能类型推断" // 自动推测数据类型
    val name2: String = "智能类型推断" // 自动推测数据类型

    var num = 0
    var s = "8"
    num = s.toInt()
    println(num)
    println(num)

    val str1 = """
         智能  
         类型  
         推断  啊啊
    """.trimIndent()
    println(str1.trim())
    val str2 = """
        |智能  
        |类型  
        |推断  啊啊
    """.trimMargin("|")
    println(str2.trim())

    val space = "   space   "
    println("原格式：$space , 去空格${space.trim()}")

    val x1 = "Hello"
    val x2 = String(charArrayOf('H', 'e', 'l', 'l', 'o'))
    println(x1 == x2) // 值比较， true
    println(x1.equals(x2)) // 值比较， true
    println(x1 === x2) // 地址比较，false

    // 两种创建二元元祖的方式
    val double1 = Pair("张三", 20)
    val double2 = "张三" to 20
    println("double1的第一个元素是：${double1.first},第二个元素是${double1.second}")
    println("double2的第一个元素是：${double2.first},第二个元素是${double2.second}")
    // 三元元祖仅一种方式创建
    val triple1 = Triple("张三", "李四", 23)
    println("triple1的第一个元素是：${triple1.first},第二个元素是${triple1.second},第三个元素是${triple1.third}")

    //可空变量类型：String是一个不可为空的类型，若要赋值null需要该类型为String?
    val string: String? = null
    // 空安全调用符 ?
    println("---${string?.toInt()}") // 若不为空则运行toInt()函数，否则不执行并返回null
    // 非空断言 !! ->相当于告诉编译器，这个地方一定不会为空
//    println(string!!.toString()) // 如果还是空，仍然会抛出异常
    val sr: String? = null
    val result = sr?.toInt() ?: 0
    println(result)

// 输入输出
    while (true) {
        println("请随意输入内容，回车键结束：")
        var input: String
        input = readLine() ?: "-1"
        println(
            when {
                input == "-1" -> "您啥都没输入"
                else -> "您刚刚输入的内容是：${input}"
            }
        )
        Thread.sleep(1000)
    }


}