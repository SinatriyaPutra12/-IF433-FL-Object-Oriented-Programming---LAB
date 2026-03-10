package oop_00000070427_sinatriyaariaputra.week05

abstract class PaymentMethod(val accountName: String) {
    abstract fun processPayment(amount: Double)
}

class EWallet(accountName: String, var balance: Double) : PaymentMethod(accountName) {
    override fun processPayment(amount: Double) {
        if (balance >= amount) { balance -= amount; println("[$accountName] Bayar Rp$amount berhasil. Sisa: Rp$balance") }
        else println("[$accountName] Saldo tidak cukup!")
    }
    fun topUp(amount: Double) { balance += amount; println("[$accountName] Top up Rp$amount. Saldo: Rp$balance") }
}

class CreditCard(accountName: String, val limit: Double) : PaymentMethod(accountName) {
    var usedAmount: Double = 0.0
    override fun processPayment(amount: Double) {
        if (usedAmount + amount <= limit) { usedAmount += amount; println("[$accountName] Bayar Rp$amount berhasil. Terpakai: Rp$usedAmount") }
        else println("[$accountName] Transaksi ditolak! Limit tidak cukup.")
    }
}
