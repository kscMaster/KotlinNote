package 基础

fun main() {
    val gender = returnParm(9)
    println(gender)
}

fun returnParm(x: Int): String {
    return when (x) {
        is Int -> "没毛病"
        in 1..6 -> "未上学" // 使用in关键字表示区间
        7 -> "小学"
        in 8 until 12 -> "正在上小学"
        12 -> "初中"
        13, 14 -> "正在上初中"
        15 -> "高中"
        16, 17, 18 -> "正在读高中"
        19 -> "大学"
        else -> "毕业"
    }
}

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