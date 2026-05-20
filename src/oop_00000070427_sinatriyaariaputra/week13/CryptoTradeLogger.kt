package oop_00000070427_sinatriyaariaputra.week13

import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

// Serialization: TradeRecord -> CSV string
fun TradeRecord.toCsv(): String = "id,symbol,type,margin,pnl"

// Deserialization: CSV string -> TradeRecord? dengan error handling robust
fun fromCsvTrade(line: String): TradeRecord? {
    return try {
        val parts = line.split(",")
        TradeRecord(
            id     = parts[0].toInt(),
            symbol = parts[1],
            type   = parts[2],
            margin = parts[3].toDouble(),
            pnl    = parts[4].toDouble()
        )
    } catch (e: Exception) {
        println("(Log) Data korup diabaikan: line")
        null
    }
}

// Write System: simpan list trades ke CSV dengan use block
fun saveTrades(trades: List<TradeRecord>, path: String) {
    File(path).printWriter().use { writer ->
        trades.forEach { trade ->
            writer.println(trade.toCsv())
        }
    }
}

// Load System: baca CSV, skip baris null (korup), tangkap FileNotFoundException
fun loadTrades(path: String): List<TradeRecord> {
    return try {
        File(path).readLines().mapNotNull { fromCsvTrade(it) }
        // mapNotNull otomatis membuang hasil null dari fromCsvTrade
    } catch (e: FileNotFoundException) {
        println("Error: File trades tidak ditemukan!")
        emptyList()
    }
}
