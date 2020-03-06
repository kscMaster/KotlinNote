package 基础

fun main() {
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

    // 将小于10的整数全部打印
    var i = 0
    while (i <= 10)
    {
        println("${i++}")
    }
    // 将小于100的整数和加起来
    var j = 0
    var sum = 0
    while ( j <= 100)
    {
        sum += j
        j++
    }
    println(sum)
    // Range区间
    val range1 = 1..100 // 闭区间，最大100
    val range = 1.rangeTo(5)
    val range2 = 1 until 100 // 开区间，最大99
    val range3 = 'A' ..'Z'
    val range4 = 'A' until 'Z'
    val range5 = 1L .. 10L

    for ((index, value ) in range5.withIndex())
    {
        println("$index,$value")
    }

    var range6 = 10..1
    for (r in range6)
    {
        println(r)
    }
    for (r in range6.reversed())
    {
        println(r)
    }
    var range7 = 10 downTo 1
    range7.reversed().forEach{
        println("$it")
    }
}