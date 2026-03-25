package oop_00000070427_sinatriyaariaputra.week07

class NetworkClient private constructor(val url: String) {
    fun connect() {
        println("Connecting to $url...")
    }
}
