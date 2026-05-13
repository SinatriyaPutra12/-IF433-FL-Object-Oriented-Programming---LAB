package oop_00000070427_sinatriyaariaputra.week12

fun main() {
    println("=== TEST RUNCATCHING ===")
    val result: Result<Int> = runCatching {
        "42X".toInt()
    }

    // Pattern: getOrElse
    val safeValue = result.getOrElse { -1 }
    println("Safe Value (getOrElse): $safeValue")

    // Pattern: recover (bisa mengubah tipe kegagalan jadi sukses)
    val recovered = result.recover { 0 }.getOrNull()
    println("Recovered Value: $recovered")

    // Chaining onSuccess & onFailure - success case
    println("\n=== TEST CHAINING ===")
    runCatching {
        "100".toInt()
    }.onSuccess { v ->
        println("Berhasil dikonversi: $v")
    }.onFailure { e ->
        println("Gagal konversi: ${e.message}")
    }

    // Chaining - failure case
    runCatching {
        "INVALID".toInt()
    }.onSuccess { v ->
        println("Berhasil dikonversi: $v")
    }.onFailure { e ->
        println("Gagal konversi: ${e.message}")
    }
}
