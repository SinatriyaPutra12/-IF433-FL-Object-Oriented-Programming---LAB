package oop_00000070427_sinatriyaariaputra.week08

fun main() {
    println("=== TEST SAFE CALLS & ELVIS ===")
    val emptyOrder = Order(null, null)
    val destination = emptyOrder.deliveryDetails?.address?.city?.name ?: "Kota Tidak Diketahui"
    println("Tujuan pengiriman: destination")

    println("\n=== TEST LET BLOCK ===")
    val validOrder = Order(null, 250000)
    val receipt = validOrder.totalPrice?.let { price ->
        val tax = price * 0.11
        "Transaksi Valid. Harga: Rpprice, Pajak: Rptax"
    } ?: "Transaksi Invalid: Harga belum di-set!"
    println(receipt)

    println("\n=== TEST SAFE CASTING ===")
    val mixedData: List<Any> = listOf(
        "Smartphone",
        1500000,
        UserProfile("Andi", null),
        "Laptop",
        4500000.0
    )

    for (item in mixedData) {
        val text = item as? String
        text?.let {
            println("Ditemukan teks: {it.uppercase()}")
        }
    }

    val someObject: Any = 100
    val safeString = someObject as? String ?: "Unknown String"
    println("Hasil cast + fallback: safeString")

    println("\n=== TEST SMART CAST ===")
    val service = NotificationService()
    val userWithEmail    = UserProfile("Budi", "budi@email.com")
    val userWithoutEmail = UserProfile("Cici", null)
    service.processUser(userWithEmail)
    service.processUser(userWithoutEmail)

    println("\n=== TEST THE RED BUTTON (!!) ===")
    val toxicData: String? = null
    try {
        val length = toxicData!!.length
    } catch (e: NullPointerException) {
        println("CRASH (NPE)! Jangan gunakan !! secara sembarangan.")
    }

    println("\n=== TEST requireNotNull ===")
    val apiResponse: Map<String, String?> = mapOf("status" to "200", "token" to null)
    try {
        val token = requireNotNull(apiResponse["token"]) {
            "CRITICAL EXCEPTION: Token otentikasi tidak ditemukan dari server!"
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    println("\n=== TEST JAVA INTEROP ===")
    val javaResponse = LegacyJavaAPI.fetchServerStatus()
    // Kita menekan tombol !! karena KITA TAHU implementasi Java-nya aman
    val statusLength = javaResponse!!.length
    println("Status dari Java: javaResponse (Length: statusLength)")
}
