package oop_00000070427_sinatriyaariaputra.week13

import java.io.File

fun main() {
    println("=== TEST UNSAFE RESOURCE HANDLING ===")
    val unsafeFile = File(pathname = "unsafe_logs.txt")
    val writer = unsafeFile.printWriter()
    writer.println("Log 1: Membuka koneksi database...")
    writer.println("Log 2: Menulis data pengguna...")
    writer.close()
    println("Proses penulisan unsafe selesai.")

    println("\n=== TEST SAFE RESOURCE HANDLING ===")
    val safeFile = File("safe_logs.txt")

    // Writer akan OTOMATIS di-close saat keluar dari blok kurawal pembungkusnya
    safeFile.printWriter().use { out ->
        for (i in 1..100) {
            out.println("Safe Log entry #i: System status OK.")
        }
    }
    println("100 baris log berhasil di-generate dengan sangat aman.")
}
