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
