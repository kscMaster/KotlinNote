package 高阶函数实战

import getPersonRepository
import java.util.*

fun main() {
    val list = getPersonRepository() // 获取到数据源

    // 找年龄最小的人
    val youngest = list.maxBy { it.idNum.substring(6, 10).toInt() }
    println(youngest)

    // 最早入住的人
    val earlyest = list.minBy { it.startTime }
    println(earlyest)

    // 判断是否有存在32岁的人
    val nowYear = Calendar.getInstance().get(Calendar.YEAR)
    val condition = nowYear - 32
    val isExist = list.any {
        it.idNum.substring(6, 10).toInt() == condition
    }
    println(if (isExist) "存在" else "不存在")

    // 统计满足条件的个数
    println(list.count { it.sex == "女" && it.province == "广东省" })

    // 返回第一个/最后一个符合条件的元祖
    println(list.find { it.sex == "女" })
    println(list.findLast { it.sex == "女" })

    // 分组
    println(list.groupBy { "按照省份分组： ${it.province}" })
    // 分组过滤广东人
    println("广东省的人： ${list.groupBy { it.province }["广东省"]}")
    // 遍历广东省的人，
    list.groupBy { it.province }["广东省"]?.forEach { println(it) }

    // 年龄最小的女人
    println("${list.filter { it.sex == "女" }.maxBy { it.idNum.substring(6, 10).toInt() }}是全天下最小的女人")
}