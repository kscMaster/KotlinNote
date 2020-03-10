fun main() {
    val nam1e: String ? = null
    println(nam1e?.toInt() ?: 0)
    println(test1(null))
}

fun test1(x: String? = "默认为三"): String {
    return if (x == "a") "a" else x?: "dwadaw"
}

fun level(x: Int): String {
    return when (x)
    {
        10 -> "满分"
        9 -> "干得不错"
        8 -> "分还可以"
        7 -> "还需努力"
        6 -> "刚好及格"
        else -> "不及格，加油吧"
    }
}

fun level2(x: Int): String {
    return when
    {
//        x.rangeTo(91..100)  -> "满分"
        x == 9 -> "干得不错"
        x == 8 -> "分还可以"
        x == 7 -> "还需努力"
        x == 6 -> "刚好及格"
        else -> "不及格，加油吧"
    }
}

