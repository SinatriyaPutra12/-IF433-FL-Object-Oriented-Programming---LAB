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
