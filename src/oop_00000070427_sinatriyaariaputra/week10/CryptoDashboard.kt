package oop_00000070427_SinatriyaAriaPutra.week10

fun main() {
    // ----- COIN REPOSITORY -----
    val coinRepo = WalletRepository<Coin>()

    // Populate coin repository
    coinRepo.add(Coin("BTC", 0.85))
    coinRepo.add(Coin("ETH", 12.5))
    coinRepo.add(Coin("USDT", 500.0))

    // Wrap into ApiResponse
    val response = ApiResponse("200 OK", coinRepo.getAll())

    // Display dashboard
    println("=== CRYPTO DASHBOARD ===")
    println("Status: ${response.status}")
    println("--- Daftar Koin ---")
    response.data.forEach { coin ->
        println("Koin: ${coin.name} | Saldo: ${coin.balance}")
    }

    // ----- TRANSACTION REPOSITORY -----
    val txRepo = WalletRepository<Transaction>()
    txRepo.add(Transaction("TXN-001", 0.05))
    txRepo.add(Transaction("TXN-002", 250.0))
    txRepo.add(Transaction("TXN-003", 1.75))

    val txResponse = ApiResponse("200 OK", txRepo.getAll())

    println("\n--- Riwayat Transaksi ---")
    println("Status: ${txResponse.status}")
    txResponse.data.forEach { tx ->
        println("ID: ${tx.id} | Jumlah: ${tx.amount}")
    }

    println("\n=== END OF DASHBOARD ===")
}
