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
