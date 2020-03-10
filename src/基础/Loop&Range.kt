package 基础

fun main() {
    val nums1 = 1..100 // 闭区间，开区间为util
    var  result = 0
    for (n in nums1 step 2)
    {
        result += n
    }
    println("${result}")
    val nums2 = nums1.reversed()
    for( i in nums2 step 2)
    {
        println(i)
    }
        nums1.count()


}