package oop_00000070427_sinatriyaariaputra.week08

class ApiParser {

    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // Ekstrak id dan name, wajib ada — throw IllegalArgumentException jika tidak ada
        val id   = requireNotNull(rawJson["id"] as? String)   { "API Invalid: Missing ID" }
        val name = requireNotNull(rawJson["name"] as? String) { "API Invalid: Missing Name" }

        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                val warranty = rawJson["warranty"] as? Int ?: 12 // fallback Elvis jika corrupt
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                val size = rawJson["size"] as? String ?: "All Size" // fallback Elvis
                Product.Clothing(id, name, size)
            }
            else -> null // Unknown type atau null -> skip
        }
    }

    fun checkout(product: Product) {
        val id = when (product) {
            is Product.Electronic -> product.id
            is Product.Clothing   -> product.id
        }

        // Kita yakin Java service selalu berhasil -> gunakan !!
        val transactionId = JavaPaymentService.processPayment(id)!!
        println("[CHECKOUT] Transaction ID: transactionId")
    }
}
