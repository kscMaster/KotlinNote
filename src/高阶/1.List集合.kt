package 高阶

import java.util.*


fun main() {
    /*  集合基础*/
    // Any相当于Java里的Object
    // 通过listOf创建的集合是一个不可修改的集合，只读不写
    var anyListOnlyRead = listOf<Any>("zhangsan", "", true, 1);
    println("${anyListOnlyRead.get(0)} : ${anyListOnlyRead[0]}")
    // 当元素不确定或需要修改的时候，使用mutableListOf
    var anyListReadWrite = mutableListOf<Any>("zhangsan", "", true, 1)
    anyListReadWrite.add("赵信")
    anyListReadWrite[0] = "张三"
    println("${anyListReadWrite.get(0)} : ${anyListReadWrite[0]}")

//    ArrayList、LinkedList、Vector
    var arrayList = arrayListOf<Any>("zhangsan", "", true, 1) // 线程不安全，适用于单线程
    var linkedList = LinkedList<Any>() // 线程不安全，适用于单线程
    linkedList.add("zhangsan")
    var vector = Vector<String>() // 线程安全，适用于多线程
    vector.add("娃娃")

    /*集合遍历*/
    var bl = listOf<Any>("aa", 'c', true, 1);
    for (aa in bl) {
        println(aa)
    }
    for ((index, value) in bl.withIndex()) {
        println("${index}:${value}")
    }
    bl.forEach { it }
    bl.forEachIndexed { index, value -> println("${index}:${value}") }
    /* 集合过滤 */
    // 取出'张'姓的人
    val all = listOf<String>("张三", "张5", "李四", "李4", "王五", "王5")
    val zhang = all.filter { it.startsWith("张") }
    println(zhang)
    // 将多个集合中特定的元素放到同一个集合中
    val list1 = listOf<String>("张三", "张5", "李四", "李6", "王五", "王7")
    val list2 = listOf<String>("张4", "张6", "李5", "李7", "王6", "王8")
    var mutableList = mutableListOf<String>()
    list1.filterTo(mutableList) { it.startsWith("张") }
    list2.filterTo(mutableList) { it.startsWith("张") }
    println(mutableList)
    // 过滤角标为偶数的元素
    val ouShu = list1.filterIndexed { index, s -> index % 2 == 0 }
    // 排序
    println(list1.sorted())
    println(list1.sortedDescending())
    // 对象排序
    var humans = listOf<Man>(
        Man("张三", 10)
        , Man("李四", 20)
        , Man("王麻子", 30)
        , Man("潘金莲", 40)
        , Man("西门庆", 80)
    )
    println(humans.sortedBy { it.age })
    println(humans.sortedByDescending { it.age })
    // 自定义比较器,需要传递一个比较规则
    println(humans.sortedWith(object : Comparator<Man> {
        override fun compare(o1: Man, o2: Man): Int {
            return o1.age - o2.age
        }
    }))

    /*分组*/
    // 将不同的姓氏分组存放
    val listName = listOf<String>("张三", "张5", "李四", "李6", "王五", "王7")
    val mapName = listName.groupBy {
        when {
            it.startsWith("张") -> "张氏"
            it.startsWith("李") -> "李氏"
            it.startsWith("王") -> "王氏"
            else -> "未知"
        }
    }
    println(mapName)
    println(humans.groupBy {
        when {
            it.age in 10..30 -> "青少年人"
            it.age in 31..50 -> "中年人"
            else -> "将死之人"
        }
    })
    /*joinToString*/
    println(humans.joinToString(separator = "|", prefix = "(", postfix = ")"))
}

data class Man(var name: String, val age: Int)