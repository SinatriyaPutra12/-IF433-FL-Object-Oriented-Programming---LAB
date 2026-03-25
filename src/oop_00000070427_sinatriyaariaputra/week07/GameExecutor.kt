package oop_00000070427_sinatriyaariaputra.week07

fun processEvent(event: BattleState) {
    when (event) {
        is BattleState.MonsterEncounter -> println("Waspada! Monster muncul: ${event.monsterName}. Bersiap untuk bertarung!")
        is BattleState.LootDropped -> println("Loot didapat: ${event.item.name} | Damage: ${event.item.damage} | Rarity: ${event.item.rarity} (Drop Chance: ${event.item.rarity.dropChance}%)")
        is BattleState.GameOver -> println("Game Over! Alasan: ${event.reason}")
        BattleState.SafeZone -> println("Kamu berada di Safe Zone. Aman untuk beristirahat.")
    }
}
