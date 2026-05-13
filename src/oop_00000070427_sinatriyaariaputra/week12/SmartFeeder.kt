package oop_00000070427_sinatriyaariaputra.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    // Validasi input: porsi harus lebih dari 0
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    // Validasi hardware: cek apakah dispenser tersangkut
    if (isJammed) {
        throw DispenserJamException()
    }

    // Validasi stok: cek apakah stok cukup
    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    var currentKibbleStock = 50

    // ==========================================================
    // JADWAL MAKAN 1: Pagi - Multiple Catch + Finally
    // ==========================================================
    println("=== JADWAL MAKAN PAGI ===")
    println("Stok awal: $currentKibbleStock gr")
    println("Porsi diminta: 80 gr")

    try {
        val newStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )
        currentKibbleStock = newStock
        println("Stok setelah makan pagi: $currentKibbleStock gr")
    } catch (e: DispenserJamException) {
        println("ALERT - Hardware Error: ${e.message}")
        println("Mohon periksa dispenser secara manual.")
    } catch (e: FoodEmptyException) {
        println("ALERT - Stok Habis: ${e.message}")
        println("Segera isi ulang kibble!")
    } catch (e: Exception) {
        println("ALERT - Error tidak terduga: ${e.message}")
    } finally {
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    // ==========================================================
    // JADWAL MAKAN 2: Sore - runCatching pipeline
    // ==========================================================
    println("\n=== JADWAL MAKAN SORE ===")
    println("Pemilik telah mengisi ulang stok. Stok baru: 1000 gr")
    println("Porsi diminta: 30 gr")

    runCatching {
        dispenseKibble(
            requestedGram = 30,
            availableGram = 1000,
            isJammed = false
        )
    }.onSuccess { newStock ->
        currentKibbleStock = newStock
        println("Makan sore sukses! Sisa stok kibble: $currentKibbleStock gr")
    }.onFailure { error ->
        println("Peringatan ke Pemilik: ${error.message}")
        println("(Opsional: Berikan chicken jerky secara manual)")
    }

    println("\n=== SMART FEEDER PIPELINE SELESAI ===")
}
