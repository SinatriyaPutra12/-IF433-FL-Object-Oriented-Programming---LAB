package oop_00000070427_sinatriyaariaputra.week05

fun main() {
    val dosen1 = Dosen(nama = "Pak Alex", nidn = "0123456")
    val admin1 = Admin(nama = "Bu Siti")
    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)
    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai) {
        pegawai.bekerja()
        when (pegawai) {
            is Dosen -> { println("=> Dosen (NIDN: ${pegawai.nidn})"); pegawai.mengajar() }
            is Admin -> { println("=> Admin"); pegawai.doAdminWork() }
        }
        println("-------------------------")
    }
    println("\n=== MATH HELPER ===")
    val math = MathHelper()
    println("Luas Persegi (sisi 5): ${math.hitungLuas(5)}")
    println("Luas Persegi Panjang (4x6): ${math.hitungLuas(4, 6)}")
    println("Luas Lingkaran (r=7.0): ${math.hitungLuas(7.0)}")
    println("\n=== SISTEM PEMBAYARAN ===")
    val eWallet = EWallet("Sinatriya", 50000.0)
    val creditCard = CreditCard("Sinatriya", 100000.0)
    val payments: List<PaymentMethod> = listOf(eWallet, creditCard)
    for (method in payments) {
        method.processPayment(75000.0)
        if (method is EWallet) { method.topUp(50000.0); method.processPayment(75000.0) }
    }
}
