package oop_00000070427_sinatriyaariaputra.week08

class ApiParser {

    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // Ekstrak id dan name, wajib ada — throw IllegalArgumentException jika tidak ada
        val id   = requireNotNull(rawJson["id"] as? String)   { "API Invalid: Missing ID" }
        val name = requireNotNull(rawJson["name"] as? String) { "API Invalid: Missing Name" }

        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                // as? Int dengan Elvis fallback jika warranty corrupt
                val warranty = rawJson["warranty"] as? Int ?: 12
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                // as? String dengan Elvis fallback jika size tidak ada
                val size = rawJson["size"] as? String ?: "All Size"
                Product.Clothing(id, name, size)
            }
            else -> null
        }
    }

    fun checkout(product: Product) {
        // Smart cast via when pada sealed class untuk ekstrak ID
        val id = when (product) {
            is Product.Electronic -> product.id
            is Product.Clothing   -> product.id
        }

        // !! digunakan karena kita YAKIN JavaPaymentService selalu return non-null (Java Interop)
        val transactionId = JavaPaymentService.processPayment(id)!!
        println("[CHECKOUT] Transaction ID: transactionId")
    }
}
