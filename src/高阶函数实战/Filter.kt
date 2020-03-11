package 高阶函数实战

import getPersonRepository
import java.text.SimpleDateFormat
import java.util.*

fun main() {
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
    /* 统计所有河南人 */


}