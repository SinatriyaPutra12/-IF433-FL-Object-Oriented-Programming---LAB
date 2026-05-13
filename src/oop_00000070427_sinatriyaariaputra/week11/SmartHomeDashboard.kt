package oop_00000070427_sinatriyaariaputra.week11

fun main() {
    // Penampung perangkat
    val homeDevices = mutableListOf<SmartDevice>()

    // Konfigurasi Pencahayaan (apply & also)
    SmartDevice("Philips WiZ Living Room", "Lighting").apply {
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }

    // Konfigurasi Keamanan (apply & also)
    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    // Konfigurasi AC & Kabel (run)
    val ac = run {
        SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
    }
    homeDevices.add(ac)

    // Tambah alat pakan peliharaan
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    // Pencarian Aman dengan let
    val searchResult = homeDevices.find { it.category == "Camera" }
    searchResult?.let {
        println(it.diagnose())
    }

    // with untuk Format Summary
    with(homeDevices) {
        println("\n=== SMART HOME DASHBOARD ===")
        println("Total perangkat terdaftar: ${this.size}")
    }

    // Kalkulasi Daya dengan run
    val totalPower = homeDevices.run { sumOf { it.powerLoad } }
    println("Total konsumsi daya: $totalPower Watt")

    // forEach diagnose semua perangkat
    println("\n=== DIAGNOSTIK SEMUA PERANGKAT ===")
    homeDevices.forEach {
        println(it.diagnose())
    }

    println("\n=== SMART HOME CONFIGURATION PIPELINE SELESAI ===")
}
