package oop_00000070427_sinatriyaariaputra.week09

// Domain Model untuk Tugas Mandiri Crypto Trading Dashboard
// roe = Return on Equity dalam persentase
// status = "OPEN" atau "CLOSED"
data class TradeLog(
    val pair: String,
    val position: String,
    val leverage: Int,
    val roe: Double,
    val status: String
)
