package oop_00000070427_sinatriyaariaputra.week13

import java.io.File

fun main() {
    println("=== TEST WRITE TEXT ===")
    val file = File("notes.txt")
    file.writeText("Line 1: Inisialisasi sistem.\n")
    println("File berhasil dibuat dan ditulis.")

    file.appendText("Line 2: Menambahkan konfigurasi baru.\n")
    println("Teks berhasil di-append.")

    println("\n=== TEST READ TEXT ===")
    val fullContent = file.readText() // Mengambil seluruh isi file sebagai satu String
    println("Membaca sekaligus:\nfullContent")

    println("=== TEST READ LINES ===")
    val lines = file.readLines() // Mengambil per baris sebagai List<String>
    lines.forEachIndexed { index, line ->
        println("Isi Index index: line")
    }
}
