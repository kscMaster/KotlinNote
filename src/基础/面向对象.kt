package 基础

data class Girl(var chactor: String, var voice: String) {
    internal var name: String? = null

    override fun toString(): String =
        "${this.name}  ${this.chactor}  ${this.voice}"

    fun smaile() {
        println("${name}笑了")
    }

    private fun dosex()
    {
        println("私人空间，不可外泄")
    }
}

fun main() {
    var girl = Girl("开朗", "甜美")
    girl.name = "王二小"
    girl.smaile()
    println(girl.toString())
}

class WashMachine(var module: String, var size: Int) {

}