package oop_00000070427_sinatriyaariaputra.week07

fun main() {
    println("=== TEST SINGLETON ===")
    println("Status: {DatabaseManager.connectionStatus}")
    DatabaseManager.connect()

    println("\n=== TEST COMPANION OBJECT ===")
    val client = NetworkClient.createClient()
    client.connect()

    println("\n=== TEST REGULAR CLASS ===")
    val reg1 = RegularUser("Alice", 22)
    val reg2 = RegularUser("Alice", 22)
    println(reg1) // Akan mencetak memori hash
    println("Sama? {reg1 == reg2}") // False
}
