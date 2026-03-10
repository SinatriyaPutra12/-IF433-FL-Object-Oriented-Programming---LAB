package oop_00000070427_sinatriyaariaputra.week04

open class Employee(val name: String, val baseSalary: Int) {
    open fun work() { println("$name sedang bekerja.") }
    open fun calculateBonus(): Int = (baseSalary * 0.10).toInt()
}
