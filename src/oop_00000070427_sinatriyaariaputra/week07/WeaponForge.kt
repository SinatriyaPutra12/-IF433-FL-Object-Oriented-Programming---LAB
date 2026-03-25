package oop_00000070427_sinatriyaariaputra.week07

class Weapon private constructor(val item: GameItem, val durability: Int) {

    companion object {
        fun forgeStarterSword(): Weapon {
            val item = GameItem("Pedang Kayu Bapuk", damage = 5, rarity = ItemRarity.COMMON)
            println("Menempa ...")
            return Weapon(item, durability = 50)
        }

        fun forgeEpicSword(): Weapon {
            val item = GameItem("Pedang Naga Merah", damage = 150, rarity = ItemRarity.EPIC)
            println("Menempa ...")
            return Weapon(item, durability = 300)
        }
    }

    override fun toString(): String =
        "Weapon(name=, damage=, rarity=, durability=)"
}
