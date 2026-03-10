package oop_nim_nama.week05

abstract class Pegawai(val nama: String) {

    abstract fun bekerja()

    fun info() {
        println("Pegawai: $nama")
    }
}