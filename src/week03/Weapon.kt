package oop_00000070427_sinatriyaariaputra.week03

class Weapon(
    val name: String,
    damage: Int
) {

    var damage = damage
        set(value) {
            when {
                value < 0 -> println("Damage tidak boleh negatif!")
                value > 1000 -> field = 1000
                else -> field = value
            }
        }

    val tier: String
        get() = when {
            damage > 800 -> "Legendary"
            damage > 500 -> "Epic"
            else -> "Common"
        }
}