package oop_00000070427_sinatriyaariaputra.week02

import java.util.Scanner

class Hero(val name: String, val baseDamage: Int, var hp: Int = 100) {
    fun attack(targetName: String) { println("$name menebas $targetName!") }
    fun takeDamage(damage: Int) { hp -= damage; if (hp < 0) hp = 0 }
    fun isAlive() = hp > 0
}

fun mainHero() {
    val scanner = Scanner(System.`in`)
    print("Nama Hero: ")
    val heroName = scanner.nextLine()
    print("Stat Damage: ")
    val damage = scanner.nextInt()
    scanner.nextLine()
    val hero = Hero(heroName, damage)
    var enemyHp = 100
    println("\n=== BATTLE START ===")
    while (hero.isAlive() && enemyHp > 0) {
        println("\n[${hero.name}] HP: ${hero.hp} | Musuh HP: $enemyHp")
        println("1. Serang  2. Kabur")
        print("Pilihan: ")
        when (scanner.nextInt()) {
            1 -> {
                hero.attack("Musuh")
                enemyHp -= hero.baseDamage
                if (enemyHp < 0) enemyHp = 0
                println("Musuh tersisa HP: $enemyHp")
                if (enemyHp > 0) {
                    val inc = (10..20).random()
                    println("Musuh membalas dengan $inc damage!")
                    hero.takeDamage(inc)
                    println("${hero.name} tersisa HP: ${hero.hp}")
                }
            }
            2 -> { println("${hero.name} kabur!"); break }
            else -> println("Pilihan tidak valid!")
        }
    }
    println("\n=== BATTLE END ===")
    when {
        enemyHp <= 0    -> println("${hero.name} MENANG!")
        !hero.isAlive() -> println("${hero.name} KALAH!")
        else            -> println("${hero.name} berhasil kabur.")
    }
}
