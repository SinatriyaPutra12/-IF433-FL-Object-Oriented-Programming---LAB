package oop_00000070427_sinatriyaariaputra.week11

fun main() {
    // ================================================================
    // INISIALISASI LIST PENAMPUNG PERANGKAT
    // ================================================================
    val homeDevices = mutableListOf<SmartDevice>()

    // ================================================================
    // KONFIGURASI PENCAHAYAAN: apply untuk setup, also untuk add ke list
    // ================================================================
    SmartDevice("Philips WiZ Living Room", "Lighting").apply {
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }

    // ================================================================
    // KONFIGURASI KEAMANAN: apply + also untuk logging & add ke list
    // ================================================================
    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    // ================================================================
    // KONFIGURASI AC & KABEL: run untuk membuat & return objek baru
    // ================================================================
    val acUnit = run {
        SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
    }
    homeDevices.add(acUnit)

    // Tambah alat pakan peliharaan
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    // ================================================================
    // PENCARIAN AMAN DENGAN let
    // ================================================================
    val searchResult = homeDevices.find { it.category == "Camera" }
    searchResult?.let {
        println(it.diagnose())
    }

    // ================================================================
    // SUMMARY DENGAN with
    // ================================================================
    println("\n=== SMART HOME DASHBOARD ===")
    with(homeDevices) {
        println("Total Perangkat Terdaftar: ${this.size}")
    }

    // ================================================================
    // KALKULASI DAYA DENGAN run
    // ================================================================
    val totalPower = homeDevices.run { sumOf { it.powerLoad } }
    println("Total Konsumsi Daya: $totalPower Watt")

    // ================================================================
    // EKSEKUSI DIAGNOSTIK SEMUA PERANGKAT
    // ================================================================
    println("\n--- DIAGNOSTIK SEMUA PERANGKAT ---")
    homeDevices.forEach { println(it.diagnose()) }
    println("==================================")
}
