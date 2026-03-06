package oop_00000070427_sinatriyaariaputra.week04

fun main() {

    println("=== Vehicle & Car Test ===")
    val car = Car("Toyota", 4)
    car.honk()
    car.accelerate()
    car.openTrunk()

    println("\n=== Electric Car Test ===")
    val tesla = ElectricCar("Tesla", 4, 85)
    tesla.honk()
    tesla.accelerate()
    tesla.openTrunk()

    println("\n=== Employee Hierarchy Test ===")
    val manager = Manager("Budi", 10000000)
    manager.work()
    println("Bonus Manager: Rp ${manager.calculateBonus()}")

    val developer = Developer("Andi", 8000000, "Kotlin")
    developer.work()
    println("Bonus Developer: Rp ${developer.calculateBonus()}")
}