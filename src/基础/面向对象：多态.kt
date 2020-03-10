package 基础

fun main() {
    val dog: Animals = Dog()
    dog.voice()
    dog.eat()
    val cat: Cat = Cat()
    cat.voice()
    cat.eat()
}

abstract class Animals(var name:String) {
    open fun voice() = println("动物叫的方法")
    abstract fun eat()
}

class Cat : Animals("猫") {
    override fun voice() {
        println("${this.name}meow")
    }

    override fun eat() {
        println("猫吃饭很挑剔")
    }
}

class Dog : Animals("狗") {
    override fun voice() {
        println("${this.name}woof")
    }

    override fun eat() {
        println("狗改不了吃屎")
    }
}