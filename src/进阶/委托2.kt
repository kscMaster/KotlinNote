package 进阶

interface IWashBowl
{
    fun washing()
}

class BigSon() : IWashBowl
{
    init {
        println("菊花一紧，似乎要让我洗碗了")
    }
    override fun washing() {
        println("只能儿子去洗了")
    }
}

class Fathers(): IWashBowl by BigSon()
{
//    override fun washing() {
//        println("给儿子洗")
//    }
}

class MaMa(): IWashBowl by Fathers()
{
//    override fun washing() {
//        println("让他爹洗")
//    }
}

fun main() {
    val mama = MaMa()
    mama.washing()
}