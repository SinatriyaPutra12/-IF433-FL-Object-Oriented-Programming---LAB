package oop_00000070427_sinatriyaariaputra.week03

class Player(val username: String) {
    private var xp: Int = 0
    val level: Int get() = (xp / 100) + 1
    fun addXp(amount: Int) {
        if (amount <= 0) { println("WARNING: XP harus positif!"); return }
        val levelBefore = level
        xp += amount
        println("$username mendapat $amount XP. Total XP: $xp")
        if (level > levelBefore) println("Level Up! Selamat $username naik ke level $level")
    }
}
