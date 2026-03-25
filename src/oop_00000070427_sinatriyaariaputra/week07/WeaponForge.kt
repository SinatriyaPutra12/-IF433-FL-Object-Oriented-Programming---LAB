package oop_00000070427_sinatriyaariaputra.week07

class Weapon private constructor(val item: GameItem, val durability: Int) {

    companion object {
        fun forgeStarterSword(): Weapon {
            val item = GameItem("Pedang Kayu Bapuk", 5, ItemRarity.COMMON)
            return Weapon(item, 50)
        }

        fun forgeEpicSword(): Weapon {
            val item = GameItem("Pedang Naga Api", 85, ItemRarity.EPIC)
            return Weapon(item, 200)
        }
    }

    override fun toString(): String {
        return "Weapon(name=${item.name}, damage=${item.damage}, rarity=${item.rarity}, durability=$durability)"
    }
}
