package oop_00000070427_sinatriyaariaputra.week04

open class Vehicle(val brand: String) {

    open fun honk() {
        println("$brand berbunyi Beep beep!")
    }

    open fun accelerate() {
        println("$brand sedang berakselerasi.")
    }
}