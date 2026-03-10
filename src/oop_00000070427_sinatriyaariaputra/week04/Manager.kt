package oop_00000070427_sinatriyaariaputra.week04

class Manager(name: String, baseSalary: Int) : Employee(name, baseSalary) {
    override fun work() { println("$name sedang memimpin rapat divisi.") }
    override fun calculateBonus(): Int = super.calculateBonus() + 500000
}
