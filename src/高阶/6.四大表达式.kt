package 高阶

fun main() {
    // 1.任意类型都有apply()扩展函数
    // 2.apply扩展函数内部的作用域只有其内部本身
    // 3.它的返回值就是自己本身
    var list = mutableListOf("张","王","李","赵","周","武","郑","孙")
    list.apply {
        this.add("钱")
        add("马")
    }.add("黄")
    // 在实际开发中，有时频繁操作某个属性时需要反复判断是否为空 xx.?
    // 因此可以使用apply{}扩起来，一次判断多次使用
}