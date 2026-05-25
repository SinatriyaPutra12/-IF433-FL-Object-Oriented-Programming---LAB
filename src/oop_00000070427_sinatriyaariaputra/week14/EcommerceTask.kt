package oop_00000070427_sinatriyaariaputra.week14
import java.io.File

// ===========================================================================
// BAD CODE - BadOrderProcessor (SOLID violations)
// ===========================================================================
class BadOrderProcessor {
    // VIOLATION: Hardcoded File I/O (DIP), melakukan kalkulasi + I/O + notifikasi sekaligus (SRP)
    private val file = File("orders.csv")

    fun processOrder(itemName: String, basePrice: Double, customerType: String) {

        // VIOLATION: Kaku jika ada tipe customer/diskon baru di masa depan (OCP)
        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP"     -> basePrice * 0.90 // Diskon 10%
            else      -> basePrice
        }

        println("Memproses pesanan $itemName seharga $finalPrice")

        // VIOLATION SRP/DIP: Menulis file langsung di class bisnis
        file.appendText("$itemName,$finalPrice,$customerType\n")

        // VIOLATION SRP/DIP: Notifikasi terikat kuat dengan sistem order
        println("Email terkirim: Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

// ===========================================================================
// REFACTORED - Applying SRP + DIP
// ===========================================================================

// --- Abstraksi Repository (SRP + DIP) ---
interface OrderRepository {
    fun saveOrder(itemName: String, price: Double, customerType: String)
}

class CsvOrderRepository : OrderRepository {
    override fun saveOrder(itemName: String, price: Double, customerType: String) {
        File("orders.csv").use { /* safe resource handling */ }
        println("[CSV] Menyimpan order: $itemName, $price, $customerType")
    }
}

// --- Abstraksi Notifikasi (SRP + DIP) ---
interface NotificationService {
    fun sendNotification(itemName: String)
}

class EmailNotifier : NotificationService {
    override fun sendNotification(itemName: String) {
        println("[EMAIL] Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

// --- Main Processor (dependency injection via constructor) ---
class SafeOrderProcessor(
    private val repo: OrderRepository,
    private val notifier: NotificationService
) {
    fun processOrder(itemName: String, basePrice: Double, strategy: PricingStrategy) {
        val finalPrice = strategy.calculate(basePrice)
        println("Memproses pesanan $itemName seharga $finalPrice")
        repo.saveOrder(itemName, finalPrice, strategy.javaClass.simpleName)
        notifier.sendNotification(itemName)
    }
}

// ===========================================================================
// REFACTORED - Fix OCP dengan PricingStrategy
// ===========================================================================
interface PricingStrategy {
    fun calculate(price: Double): Double
}

class RegularPricing : PricingStrategy {
    override fun calculate(price: Double) = price
}

class VipPricing : PricingStrategy {
    override fun calculate(price: Double) = price * 0.90
}

class FlashSalePricing : PricingStrategy {
    override fun calculate(price: Double) = price * 0.50
}

// ===========================================================================
// DEMO
// ===========================================================================
fun main() {
    println("=== BAD ORDER PROCESSOR ===")
    val bad = BadOrderProcessor()
    bad.processOrder("Sepatu Nike", 500000.0, "VIP")

    println("\n=== SAFE ORDER PROCESSOR (SOLID) ===")
    val repo = CsvOrderRepository()
    val notifier = EmailNotifier()
    val processor = SafeOrderProcessor(repo, notifier)

    processor.processOrder("Sepatu Adidas", 450000.0, RegularPricing())
    processor.processOrder("Tas Gucci", 5000000.0, VipPricing())
    processor.processOrder("Kaos Polos", 100000.0, FlashSalePricing())

    println("\n=== SELESAI ===")
}
