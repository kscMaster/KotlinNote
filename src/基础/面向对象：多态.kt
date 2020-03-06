package 基础

fun main() {
    val animals = Animals()
    animals.voice()
    val dog: Animals = Dog()
    dog.voice()
    val cat : Cat= Cat()
    cat.voice()
}
open  class Animals {
    open fun voice() = println("动物叫的方法")
}
class Cat : Animals() {
    override fun voice() {
        println("meow")
    }
}
class Dog : Animals() {
    override fun voice() {
        super.voice()
        println("woof")
    }
}