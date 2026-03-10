package oop_00000070427_sinatriyaariaputra.week06

interface PaymentMethod {
    fun pay(amount: Double)
    fun printReceipt(amount: Double) {
        println("===== RECEIPT =====")
        println("Jumlah: Rp$amount")
        println("===================")
    }
}

class Gopay(val accountName: String) : PaymentMethod {
    override fun pay(amount: Double) { println("Processing Rp$amount via Gopay for $accountName") }
}

class OVO(val accountName: String) : PaymentMethod {
    override fun pay(amount: Double) { println("Processing Rp$amount via OVO for $accountName") }
}

class CreditCard(val bankName: String) : PaymentMethod {
    override fun pay(amount: Double) { println("Contacting $bankName Bank for Rp$amount") }
    override fun printReceipt(amount: Double) {
        println("===== CREDIT CARD RECEIPT =====")
        println("Bank: $bankName")
        println("Jumlah: Rp$amount")
        println("================================")
    }
}

fun processCheckout(method: PaymentMethod, amount: Double) {
    method.pay(amount)
    method.printReceipt(amount)
}
