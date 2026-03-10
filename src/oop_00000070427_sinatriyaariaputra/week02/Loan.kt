package oop_00000070427_sinatriyaariaputra.week02

import java.util.Scanner

class Loan(
    val bookTitle: String,
    val borrower: String,
    val loanDuration: Int = 1
) {
    fun calculateFine(): Int =
        if (loanDuration > 3) (loanDuration - 3) * 2000 else 0
}

fun mainLoan() {
    val scanner = Scanner(System.`in`)
    print("Judul Buku: ")
    val title = scanner.nextLine()
    print("Nama Peminjam: ")
    val borrower = scanner.nextLine()
    print("Lama Pinjam (hari): ")
    var duration = scanner.nextInt()
    if (duration < 0) duration = 1
    val loan = Loan(title, borrower, duration)
    println("\n--- Detail Peminjaman ---")
    println("Buku     : ${loan.bookTitle}")
    println("Peminjam : ${loan.borrower}")
    println("Durasi   : ${loan.loanDuration} hari")
    println("Denda    : Rp ${loan.calculateFine()}")
}
