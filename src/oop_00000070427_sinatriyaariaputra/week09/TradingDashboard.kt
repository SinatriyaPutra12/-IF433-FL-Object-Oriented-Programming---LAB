package oop_00000070427_sinatriyaariaputra.week09

fun main() {
    // ================================================================
    // INISIALISASI DATA UJI
    // Campuran: OPEN & CLOSED, ROE positif & negatif, minimal 2 koin
    // ================================================================
    val tradeHistory = listOf(
        TradeLog("BTCUSDT", "LONG",  20,  15.5,  "CLOSED"),
        TradeLog("BTCUSDT", "SHORT", 10,  -5.2,  "CLOSED"),
        TradeLog("ETHUSDT", "LONG",  15,  22.3,  "CLOSED"),
        TradeLog("ETHUSDT", "SHORT",  5,  -12.8, "CLOSED"),
        TradeLog("SOLUSDT", "LONG",  25,   8.7,  "CLOSED"),
        TradeLog("SOLUSDT", "SHORT", 10,  -3.1,  "CLOSED"),
        TradeLog("BTCUSDT", "LONG",  20,   6.4,  "OPEN"),
        TradeLog("ETHUSDT", "SHORT", 15,  -2.0,  "OPEN")
    )

    // ================================================================
    // PIPELINE 1: Filter hanya CLOSED trades
    // ================================================================
    val closedTrades = tradeHistory
        .filter { it.status == "CLOSED" }

    // ================================================================
    // PIPELINE 2: Winning Trades (roe > 0)
    // ================================================================
    val winningTrades = closedTrades
        .filter { it.roe > 0 }

    // ================================================================
    // PIPELINE 3: Losing Trades (roe <= 0)
    // ================================================================
    val losingTrades = closedTrades
        .filter { it.roe <= 0 }

    // ================================================================
    // PIPELINE 4: Top Performers - Sorted descending, mapped to String
    // ================================================================
    val topPerformersString = winningTrades
        .sortedByDescending { it.roe }
        .map { "WIN [${it.pair} - ${it.position}]: +${it.roe}% ROE (Lev: ${it.leverage}x)" }

    // ================================================================
    // PIPELINE 5: Worst Performers - Sorted ascending (paling minus duluan)
    // ================================================================
    val worstPerformersString = losingTrades
        .sortedBy { it.roe }
        .map { "LOSS [${it.pair} - ${it.position}]: ${it.roe}% ROE (Lev: ${it.leverage}x)" }

    // ================================================================
    // PIPELINE TAMBAHAN: Unique trading pairs (pakai Set buat hilangkan duplikat)
    // ================================================================
    val uniquePairs = tradeHistory
        .map { it.pair }
        .toSet()

    // ================================================================
    // TAMPILKAN DASHBOARD
    // ================================================================
    println("=== CRYPTO TRADING DASHBOARD ===")
    println()

    // Win Rate Calculation (masih boleh pakai size, bukan for-loop)
    val totalClosed = closedTrades.size
    val totalWin    = winningTrades.size
    val winRate     = if (totalClosed > 0) (totalWin.toDouble() / totalClosed * 100) else 0.0
    println("📊 Total Closed Trades : $totalClosed")
    println("✅ Winning Trades       : $totalWin")
    println("❌ Losing Trades        : ${losingTrades.size}")
    println("🎯 Win Rate             : ${"%.1f".format(winRate)}%")
    println()

    println("--- TOP PERFORMERS (Profit) ---")
    topPerformersString.forEach { println("  $it") }
    println()

    println("--- WORST PERFORMERS (Loss) ---")
    worstPerformersString.forEach { println("  $it") }
    println()

    println("--- UNIQUE TRADING PAIRS ---")
    println("  $uniquePairs")
    println()
    println("=================================")
}
