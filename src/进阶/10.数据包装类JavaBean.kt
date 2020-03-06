package 进阶

import java.util.*

data class Sms(val time:Long,val from:String,val content:String)

fun main() {
    val sms1 = Sms(1111111L,"李波", "我是个短信内容")
    val sms2 = Sms(1111111L,"李波", "我是个短信内容")
    println(sms1.hashCode().equals(sms2.hashCode()))
    println(sms1.equals(sms2))
    println(sms1.toString())
}