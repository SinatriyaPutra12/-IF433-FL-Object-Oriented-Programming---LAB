@'
package oop_00000070427_sinatriyaariaputra.week01

fun calculateStatus(score: Int) = if (score > 75) "Lulus" else "Tidak Lulus"

fun main() {
    val name = "Sinatriya Aria Putra"
    val score = 80
    println("Nama: $name, Nilai: $score")
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89  -> "B"
        in 70..79  -> "C"
        else       -> "D"
    }
    println("Grade kamu: $grade")
    println("Status: ${calculateStatus(score)}")
    val studentId: String? = null
    val idLength = studentId?.length ?: 0
    println("Panjang ID: $idLength")
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week01\GradingSystem.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week01

fun checkSize(area: Double) = if (area > 100) "This is a Big Circle" else "This is a Small Circle"

fun mainCircle() {
    val radius = 7.0
    val pi = 3.14
    val area = pi * radius * radius
    println("Radius: $radius, Area: $area")
    println(checkSize(area))
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week01\CircleCalculator.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week01

fun calculateDiscount(price: Int): Int =
    if (price > 500000) (price * 0.80).toInt() else (price * 0.90).toInt()

fun printReceipt(title: String, finalPrice: Int, note: String) {
    println("===== STEAMKW RECEIPT =====")
    println("Judul    : $title")
    println("Harga Bayar: Rp $finalPrice")
    println("Catatan  : $note")
    println("===========================")
}

fun mainGameStore() {
    val gameTitle = "Elden Ring"
    val price = 600000
    val finalPrice = calculateDiscount(price)
    val userNote: String? = null
    val note = userNote ?: "Tidak ada catatan"
    printReceipt(title = gameTitle, finalPrice = finalPrice, note = note)
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week01\GameStore.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week02

class Student(
    val name: String,
    val nim: String,
    var gpa: Double = 0.0,
    var major: String
) {
    init {
        if (nim.length != 5) {
            println("WARNING: Objek tercipta dengan NIM ($nim) yang tidak valid!")
            println("Data mahasiswa $name mungkin akan bermasalah di sistem.")
        } else {
            println("LOG: Objek Student $name berhasil dialokasikan di Memory.")
        }
    }
    constructor(name: String, nim: String) : this(name, nim, major = "Non-Matriculated") {
        println("LOG: Menggunakan constructor jalur umum (Tanpa Jurusan).")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week02\Student.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(source = System.`in`)
    println("--- APLIKASI PMB UMN ---")
    print("Masukkan Nama: ")
    val name = scanner.nextLine()
    print("Masukkan NIM (Wajib 5 Karakter): ")
    val nim = scanner.next()
    scanner.nextLine()
    if (nim.length != 5) {
        println("ERROR: Pendaftaran dibatalkan. NIM harus 5 karakter!")
    } else {
        print("Pilih Jalur (1. Reguler, 2. Umum): ")
        val type = scanner.nextInt()
        scanner.nextLine()
        if (type == 1) {
            print("Masukkan Jurusan: ")
            val major = scanner.nextLine()
            val s1 = Student(name, nim, major = major)
            println("Status: Pendaftaran Selesai.")
            println("Terdaftar di: ${s1.major} dengan GPA awal ${s1.gpa}")
        } else if (type == 2) {
            val s2 = Student(name, nim)
            println("Terdaftar di: ${s2.major} dengan GPA awal ${s2.gpa}")
        } else {
            println("Pilihan ngawur, pendaftaran batal!")
        }
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week02\Main.kt" -Encoding UTF8

@'
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
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week02\Loan.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week02

import java.util.Scanner

class Hero(val name: String, val baseDamage: Int, var hp: Int = 100) {
    fun attack(targetName: String) { println("$name menebas $targetName!") }
    fun takeDamage(damage: Int) { hp -= damage; if (hp < 0) hp = 0 }
    fun isAlive() = hp > 0
}

fun mainHero() {
    val scanner = Scanner(System.`in`)
    print("Nama Hero: ")
    val heroName = scanner.nextLine()
    print("Stat Damage: ")
    val damage = scanner.nextInt()
    scanner.nextLine()
    val hero = Hero(heroName, damage)
    var enemyHp = 100
    println("\n=== BATTLE START ===")
    while (hero.isAlive() && enemyHp > 0) {
        println("\n[${hero.name}] HP: ${hero.hp} | Musuh HP: $enemyHp")
        println("1. Serang  2. Kabur")
        print("Pilihan: ")
        when (scanner.nextInt()) {
            1 -> {
                hero.attack("Musuh")
                enemyHp -= hero.baseDamage
                if (enemyHp < 0) enemyHp = 0
                println("Musuh tersisa HP: $enemyHp")
                if (enemyHp > 0) {
                    val inc = (10..20).random()
                    println("Musuh membalas dengan $inc damage!")
                    hero.takeDamage(inc)
                    println("${hero.name} tersisa HP: ${hero.hp}")
                }
            }
            2 -> { println("${hero.name} kabur!"); break }
            else -> println("Pilihan tidak valid!")
        }
    }
    println("\n=== BATTLE END ===")
    when {
        enemyHp <= 0    -> println("${hero.name} MENANG!")
        !hero.isAlive() -> println("${hero.name} KALAH!")
        else            -> println("${hero.name} berhasil kabur.")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week02\Hero.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week03

class Employee(val name: String) {
    var salary: Int = 0
        set(value) {
            if (value < 0) { println("ERROR: Gaji tidak boleh negatif! Di-set ke 0."); field = 0 }
            else field = value
        }
    private var performanceRating: Int = 3
    fun increasePerformance() { performanceRating++; println("Kinerja $name meningkat! Rating: $performanceRating") }
    fun printStatus() { println("Karyawan: $name, Rating: $performanceRating") }
    val tax: Double get() = salary * 0.1
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week03\Employee.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week03

fun main() {
    val e = Employee("Budi")
    e.salary = -1000
    e.salary = 5000000
    println("Gaji: ${e.salary}")
    e.increasePerformance()
    println("Pajak yang harus dibayar: ${e.tax}")
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week03\Main.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week03

class Weapon(val name: String) {
    var damage: Int = 0
        set(value) {
            when {
                value < 0    -> println("WARNING: Damage tidak boleh negatif! Nilai tidak diubah.")
                value > 1000 -> { println("WARNING: Damage terlalu tinggi! Dipaksa menjadi 1000."); field = 1000 }
                else         -> field = value
            }
        }
    val tier: String get() = when {
        damage > 800 -> "Legendary"
        damage > 500 -> "Epic"
        else         -> "Common"
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week03\Weapon.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week03

class Player(val username: String) {
    private var xp: Int = 0
    val level: Int get() = (xp / 100) + 1
    fun addXp(amount: Int) {
        if (amount <= 0) { println("WARNING: XP harus positif!"); return }
        val levelBefore = level
        xp += amount
        println("$username mendapat $amount XP. Total XP: $xp")
        if (level > levelBefore) println("Level Up! Selamat $username naik ke level $level")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week03\Player.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

open class Vehicle(val brand: String) {
    var speed: Int = 0
    open fun accelerate() { speed += 10; println("$brand melaju. Kecepatan: $speed km/jam") }
    open fun honk() { println("Beep beep!") }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Vehicle.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

open class Car(brand: String, val numberOfDoors: Int) : Vehicle(brand) {
    fun openTrunk() { println("Bagasi mobil $brand dengan $numberOfDoors pintu dibuka.") }
    override fun honk() { println("TIN TIN! Mobil $brand lewat!") }
    override fun accelerate() {
        super.accelerate()
        println("Mobil $brand menggunakan transmisi gigi untuk menambah kecepatan.")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Car.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

class ElectricCar(brand: String, numberOfDoors: Int, val batteryCapacity: Int) : Car(brand, numberOfDoors) {
    final override fun accelerate() {
        println("$brand berakselerasi dalam sunyi. Kapasitas baterai: $batteryCapacity%.")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\ElectricCar.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

open class Employee(val name: String, val baseSalary: Int) {
    open fun work() { println("$name sedang bekerja.") }
    open fun calculateBonus(): Int = (baseSalary * 0.10).toInt()
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Employee.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

class Manager(name: String, baseSalary: Int) : Employee(name, baseSalary) {
    override fun work() { println("$name sedang memimpin rapat divisi.") }
    override fun calculateBonus(): Int = super.calculateBonus() + 500000
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Manager.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

class Developer(name: String, baseSalary: Int, val programmingLanguage: String) : Employee(name, baseSalary) {
    override fun work() { println("$name sedang ngoding menggunakan $programmingLanguage.") }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Developer.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week04

fun main() {
    println("--- Testing Vehicle ---")
    val generalVehicle = Vehicle(brand = "Sepeda Onthel")
    generalVehicle.honk()
    generalVehicle.accelerate()
    println("\n--- Testing Car ---")
    val myCar = Car(brand = "Toyota", numberOfDoors = 4)
    myCar.openTrunk()
    myCar.honk()
    myCar.accelerate()
    println("\n--- Testing ElectricCar ---")
    val myEV = ElectricCar(brand = "Tesla", numberOfDoors = 4, batteryCapacity = 87)
    myEV.accelerate()
    myEV.honk()
    myEV.openTrunk()
    println("\n--- Testing Employee Hierarchy ---")
    val manager = Manager("Andi", 10000000)
    val developer = Developer("Budi", 8000000, "Kotlin")
    manager.work()
    println("Bonus Manager: Rp ${manager.calculateBonus()}")
    developer.work()
    println("Bonus Developer: Rp ${developer.calculateBonus()}")
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week04\Main.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week05

abstract class Pegawai(val nama: String) {
    abstract fun bekerja()
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\Pegawai.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week05

class Dosen(nama: String, val nidn: String) : Pegawai(nama) {
    override fun bekerja() { println("[$nama] sedang menyiapkan materi perkuliahan dan merevisi RPKPS.") }
    fun mengajar() { println("[$nama] sedang mengajar mahasiswa di kelas.") }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\Dosen.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week05

class Admin(nama: String) : Pegawai(nama) {
    override fun bekerja() { println("[$nama] sedang duduk di depan komputer melayani administrasi.") }
    fun doAdminWork() { println("[$nama] sedang merekap data absensi mahasiswa.") }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\Admin.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week05

class MathHelper {
    fun hitungLuas(sisi: Int): Int = sisi * sisi
    fun hitungLuas(panjang: Int, lebar: Int): Int = panjang * lebar
    fun hitungLuas(jariJari: Double): Double = 3.14 * jariJari * jariJari
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\MathHelper.kt" -Encoding UTF8

@'
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
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\PaymentMethod.kt" -Encoding UTF8

@'
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
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week05\Main.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

interface Clickable {
    fun click()
    fun showOff() { println("I am clickable!") }
}

class Button : Clickable {
    override fun click() { println("Button clicked!") }
}

class ImageView : Clickable {
    override fun click() { println("ImageView clicked!") }
    override fun showOff() { println("I am a clickable ImageView!") }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\Clickable.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

interface Identifiable {
    val id: String
    val displayInfo: String get() = "ID: $id"
}

class Employee(override val id: String, val name: String) : Identifiable

class Product(override val id: String, val productName: String) : Identifiable {
    override val displayInfo: String get() = "Product[$id]: $productName"
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\Identifiable.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

interface CanCamera { fun takePhoto() }
interface CanWifi   { fun connect() }
interface CanPhone  { fun makeCall() }
interface InterfaceA { fun show() { println("Implementasi dari Interface A") } }
interface InterfaceB { fun show() { println("Implementasi dari Interface B") } }

class Smartphone : CanCamera, CanWifi, CanPhone {
    override fun takePhoto() { println("Click! Foto diambil.") }
    override fun connect()   { println("Terhubung ke WiFi.") }
    override fun makeCall()  { println("Menelepon...") }
}

class DeviceC : InterfaceA, InterfaceB {
    override fun show() {
        super<InterfaceA>.show()
        println("Tambahan logika custom dari DeviceC")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\SmartDevice.kt" -Encoding UTF8

@'
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
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\PaymentMethod.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

interface Flyable  { fun fly(); fun altitude(): String = "Ketinggian standar" }
interface Swimmable { fun swim() }
interface Runnable  { fun run() }

abstract class Animal(val name: String) { abstract fun makeSound() }

class Duck(name: String) : Animal(name), Flyable, Swimmable, Runnable {
    override fun makeSound() = println("$name: Kwek kwek!")
    override fun fly()       = println("$name sedang terbang rendah.")
    override fun swim()      = println("$name sedang berenang.")
    override fun run()       = println("$name berlari di tepi danau.")
    override fun altitude()  = "$name terbang di ketinggian 5 meter"
}

class Eagle(name: String) : Animal(name), Flyable {
    override fun makeSound() = println("$name: Kreeee!")
    override fun fly()       = println("$name melayang tinggi di angkasa.")
    override fun altitude()  = "$name terbang di ketinggian 500 meter"
}

class Fish(name: String) : Animal(name), Swimmable {
    override fun makeSound() = println("$name: ...")
    override fun swim()      = println("$name berenang di dalam air.")
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\Flyable.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

interface Printable {
    val documentName: String
    fun print()
    fun preview() { println("[PREVIEW] $documentName siap untuk dicetak.") }
}

interface Saveable { fun save(filename: String) }

class PDFDocument(override val documentName: String, val content: String) : Printable, Saveable {
    override fun print() { println("[PDF] Mencetak '$documentName'...\nIsi: $content") }
    override fun save(filename: String) { println("[PDF] Menyimpan sebagai '$filename.pdf'") }
}

class WordDocument(override val documentName: String, val author: String) : Printable, Saveable {
    override fun print() { println("[WORD] Mencetak '$documentName'...\nAuthor: $author") }
    override fun save(filename: String) { println("[WORD] Menyimpan sebagai '$filename.docx'") }
    override fun preview() { println("[WORD PREVIEW] '$documentName' oleh $author") }
}

class ConsolePrinter(override val documentName: String, val text: String) : Printable {
    override fun print() { println("[CONSOLE] === $documentName ===\n$text\n[CONSOLE] ==================") }
}

fun sendToPrinter(doc: Printable) { doc.preview(); doc.print(); println() }
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\Printable.kt" -Encoding UTF8

@'
package oop_00000070427_sinatriyaariaputra.week06

fun main() {
    println("=== 1. Clickable ===")
    val button = Button(); val imageView = ImageView()
    button.click(); button.showOff()
    imageView.click(); imageView.showOff()
    println("\n=== 2. Identifiable ===")
    val emp = Employee(id = "EMP-001", name = "Sinatriya")
    val prod = Product(id = "PRD-999", productName = "Laptop Gaming")
    println(emp.displayInfo); println(prod.displayInfo)
    println("\n=== 3. Multiple Interface ===")
    val phone = Smartphone()
    phone.takePhoto(); phone.connect(); phone.makeCall()
    println("\n=== 4. Diamond Problem ===")
    val deviceC = DeviceC(); deviceC.show()
    println("\n=== 5. Payment Interface ===")
    val payments: List<PaymentMethod> = listOf(Gopay("Sinatriya"), OVO("Sinatriya"), CreditCard("BCA"))
    for (p in payments) { processCheckout(method = p, amount = 150000.0); println() }
    println("=== TUGAS 1: Animal Capabilities ===")
    val duck = Duck("Donald"); val eagle = Eagle("Sam"); val fish = Fish("Nemo")
    duck.makeSound(); duck.fly(); duck.swim(); duck.run(); println(duck.altitude())
    println(); eagle.makeSound(); eagle.fly(); println(eagle.altitude())
    println(); fish.makeSound(); fish.swim()
    println("\n-- Yang bisa terbang --")
    listOf(duck, eagle).forEach { it.fly(); println(it.altitude()) }
    println("\n-- Yang bisa berenang --")
    listOf(duck, fish).forEach { it.swim() }
    println("\n=== TUGAS 2: Document Printer ===")
    val pdf  = PDFDocument("Laporan OOP", "Bab 1: Interface adalah kontrak")
    val word = WordDocument("Tugas IF433", "Sinatriya Aria Putra")
    val cons = ConsolePrinter("Info System", "Sistem berjalan normal.")
    sendToPrinter(pdf); sendToPrinter(word); sendToPrinter(cons)
    println("-- Save dokumen --")
    listOf(pdf, word, cons).forEach { doc ->
        if (doc is Saveable) doc.save("backup_${doc.documentName.replace(" ", "_")}")
        else println("[INFO] ${doc.documentName} tidak mendukung save.")
    }
}
'@ | Set-Content "src\oop_00000070427_sinatriyaariaputra\week06\Main.kt" -Encoding UTF8

git add .
git status