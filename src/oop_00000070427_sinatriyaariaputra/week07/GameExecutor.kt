package oop_00000070427_sinatriyaariaputra.week07

fun processEvent(event: BattleState) {
    when (event) {
        is BattleState.MonsterEncounter -> {
            println("[ENCOUNTER] Waspada! Kamu bertemu: !")
        }
        is BattleState.LootDropped -> {
            println("[LOOT] Item jatuh:  | Damage:  | Rarity:  (Drop Chance: %)")
        }
        is BattleState.GameOver -> {
            println("[GAME OVER] Permainan berakhir. Alasan: ")
        }
        BattleState.SafeZone -> {
            println("[SAFE ZONE] Kamu berada di zona aman. Istirahat sejenak...")
        }
    }
}
