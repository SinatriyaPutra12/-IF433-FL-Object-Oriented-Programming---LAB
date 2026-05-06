package oop_00000070427_sinatriyaariaputra.week11

data class User(var name: String = "", var age: Int = 0)

fun main() {
    println("=== TEST APPLY ===")
    val user = User().apply {
        name = "Alex"
        age = 25
    }
    println(user)

    println("\n=== TEST ALSO ===")
    val numbers = mutableListOf(1, 2, 3)
    numbers.also {
        println("Log Sebelum ditambah: $it")
    }.add(4)
    println("Setelah ditambah: $numbers")

    println("\n=== TEST WITH ===")
    with(user) {
        println("User Detail -> Nama: $name, Umur: $age")
    }

    val newUser = User("Budi", 20).apply {
        age = 21 // Mengubah umur
    }.also {
        println("User baru berhasil dibuat: $it")
    }
}
