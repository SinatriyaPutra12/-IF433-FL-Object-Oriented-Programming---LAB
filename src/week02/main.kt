package oop_00000070427_sinatriyaariaputra.week02

class Hero(
    val name: String,
    val baseDamage: Int,
    hp: Int = 100
) {
    var hp = hp
        private set

    fun attack(): Int {
        println("$name menyerang dengan damage $baseDamage!")
        return baseDamage
    }

    fun takeDamage(damage: Int) {
        hp = (hp - damage).coerceAtLeast(0)
        println("$name menerima $damage damage. Sisa HP: $hp")
    }

    fun isAlive() = hp > 0
}