package oop_00000070427_sinatriyaariaputra.week01

fun calculateDiscount(price: Int): Int =
    if (price > 500000) (price * 0.80).toInt() else (price * 0.90).toInt()

fun printReceipt(title: String, finalPrice: Int, note: String) {
    println("===== STEAMKW RECEIPT =====")
    println("Judul    : $title")
    println("Harga Bayar: Rp $finalPrice")
    println("Catatan  : $note")
    println("===========================")
}

fun mainGameStore() {
    val gameTitle = "Elden Ring"
    val price = 600000
    val finalPrice = calculateDiscount(price)
    val userNote: String? = null
    val note = userNote ?: "Tidak ada catatan"
    printReceipt(title = gameTitle, finalPrice = finalPrice, note = note)
}
