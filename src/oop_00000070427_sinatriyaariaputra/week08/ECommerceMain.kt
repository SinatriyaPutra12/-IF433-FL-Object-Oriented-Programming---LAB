package oop_00000070427_sinatriyaariaputra.week08

fun main() {
    println("========================================")
    println("  E-COMMERCE API PARSER PIPELINE TEST  ")
    println("========================================")

    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop",    "type" to "ELECTRONIC", "warranty" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt",   "type" to "CLOTHING",   "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse",     "type" to "ELECTRONIC", "warranty" to "Not An Integer"), // Corrupted warranty -> fallback 12
        mapOf(               "name" to "Ghost Item","type" to "CLOTHING"),                                    // Missing ID -> exception
        mapOf("id" to "X01", "name" to "Unknown",   "type" to "FOOD")                                        // Unknown type -> null -> skip
    )

    val parser = ApiParser()

    for (raw in rawApiData) {
        try {
            val product = parser.parseProduct(raw)

            product?.let {
                when (it) {
                    is Product.Electronic -> println("[PARSED] Electronic: {it.name} | Warranty: {it.warrantyMonths} bulan")
                    is Product.Clothing   -> println("[PARSED] Clothing  : {it.name} | Size: {it.size}")
                }
                parser.checkout(it)
            } ?: println("[SKIP] Produk tidak dikenali (type tidak valid), dilewati.")

        } catch (e: IllegalArgumentException) {
            println("[ERROR] Data korup diabaikan: {e.message}")
        }
        println("----------------------------------------")
    }

    println("========================================")
    println("  PIPELINE SELESAI                      ")
    println("========================================")
}
