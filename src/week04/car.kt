package oop_00000070427_sinatriyaariaputra.week04

open class Car(
    brand: String,
    val numberOfDoors: Int
) : Vehicle(brand) {

    override fun honk() {
        println("$brand berbunyi Tiiin tiiin!")
    }

    override fun accelerate() {
        super.accelerate()
        println("Mobil dengan $numberOfDoors pintu melaju lebih cepat.")
    }

    fun openTrunk() {
        println("$brand membuka bagasi.")
    }
}