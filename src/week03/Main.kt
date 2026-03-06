package oop_00000070427_sinatriyaariaputra.week03

fun main() {

    println("=== Employee Test ===")
    val emp = Employee("Budi", 5000000)
    emp.salary = -100
    emp.salary = 6000000
    println("Yearly Salary: ${emp.yearlySalary}")

    println("\n=== Weapon Test ===")
    val sword = Weapon("Excalibur", 900)
    println("Tier: ${sword.tier}")
    sword.damage = 9999
    println("Damage setelah set 9999: ${sword.damage}")
    println("Tier: ${sword.tier}")

    println("\n=== Player Test ===")
    val player = Player("Sinatriya")
    player.addXp(50)
    player.addXp(60)
    println(player)
}