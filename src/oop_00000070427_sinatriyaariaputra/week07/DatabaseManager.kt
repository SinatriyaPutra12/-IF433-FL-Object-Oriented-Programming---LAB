package oop_00000070427_sinatriyaariaputra.week07

object DatabaseManager {
    var connectionStatus: String = "Disconnected"
    fun connect() {
        connectionStatus = "Connected to Server"
        println("Database is ready.")
    }
}
