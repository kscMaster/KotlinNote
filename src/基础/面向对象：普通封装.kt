package 基础

fun main() {
    val restaurant = Restaurant()
    restaurant.order()
}

class Restaurant {
    fun order() {
        getTicket()
        notifyCooker()
        cooking()
        done()
    }

    private fun getTicket() {
        println("getOrder")
    }

    private fun notifyCooker() {
        println("notifyCooker")
    }

    private fun cooking() {
        println("Cooking")
    }

    private fun done() {
        println("Complete")
    }
}