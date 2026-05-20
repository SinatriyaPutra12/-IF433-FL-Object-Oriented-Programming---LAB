package oop_00000070427_sinatriyaariaputra.week13

import java.io.File

fun main() {
    println("=== TEST UNSAFE RESOURCE HANDLING ===")
    val unsafeFile = File(pathname = "unsafe_logs.txt")

    // Membuka stream secara manual
    val writer = unsafeFile.printWriter()

    writer.println("Log 1: Membuka koneksi database...")
    writer.println("Log 2: Menulis data pengguna...")

    // BAHAYA: Jika terjadi Exception di baris ini (misalnya pembagian dengan nol atau error tak terduga),
    // program akan crash dan metode writer.close() di bawahnya TIDAK AKAN PERNAH TEREKSEKUSI!
    // File akan terus terkunci oleh OS.

    // Wajib dipanggil secara manual jika tidak memakai blok 'use'
    writer.close()
    println("Proses penulisan unsafe selesai.")
}
