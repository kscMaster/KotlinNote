import java.io.File
import kotlin.math.max

data class Person(
    val name: String,
    val idNum: String,
    val province: String,
    val sex: String,
    val hotel: String,
    val startTime: Long,
    val endTime: Long
) {}

private val list = mutableListOf<Person>()

fun getPersonRepository(): List<Person> {
    if (list.size != 0) return list

    File("src/高阶函数实战/repo.data").readLines().forEach {
        val split = it.split("\t")
        val name = split[0]
        val idNum = split[1]
        val province = split[2]
        val sex = split[3]
        val hotel = split[4]
        val startTime = split[5]
        val endTime = split[6]
        list.add(Person(name, idNum, province, sex, hotel, startTime.toLong(), endTime.toLong()))
    }
    return list
}

infix fun List<Person>.查找某省所有人(mProvince: String): List<Person> {
    return filter { it.province == mProvince }
}

infix fun List<Person>.查找特定性别(gender: String): List<Person> {
    return filter { it.sex == gender }
}