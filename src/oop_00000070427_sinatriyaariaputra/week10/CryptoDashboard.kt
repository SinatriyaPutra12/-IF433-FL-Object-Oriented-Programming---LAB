package oop_00000070427_sinatriyaariaputra.week10

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
    println("Total Koin Terdaftar: ${coinRepo.count()}")
    println("--- Daftar Koin ---")
    response.data.forEach { coin ->
        println("Koin: ${coin.name} | Saldo: ${coin.balance}")
    }

    // Total balance
    val totalBalance = response.data.sumOf { it.balance }
    println("Total Balance: $totalBalance")

    // Search example
    val highBalance = coinRepo.search { it.balance > 1.0 }
    println("\n--- Koin dengan Saldo > 1.0 ---")
    highBalance.forEach { println("  ${it.name}: ${it.balance}") }

    // ----- TRANSACTION REPOSITORY -----
    val txRepo = WalletRepository<Transaction>()
    txRepo.add(Transaction("TXN-001", 0.05))
    txRepo.add(Transaction("TXN-002", 250.0))
    txRepo.add(Transaction("TXN-003", 1.75))

    val txResponse = ApiResponse("200 OK", txRepo.getAll())

    println("\n--- Riwayat Transaksi ---")
    println("Status: ${txResponse.status}")
    println("Total Transaksi: ${txRepo.count()}")
    txResponse.data.forEach { tx ->
        println("ID: ${tx.id} | Jumlah: ${tx.amount}")
    }

    val totalTx = txResponse.data.sumOf { it.amount }
    println("Total Volume Transaksi: $totalTx")

    println("\n=== END OF DASHBOARD ===")
}
