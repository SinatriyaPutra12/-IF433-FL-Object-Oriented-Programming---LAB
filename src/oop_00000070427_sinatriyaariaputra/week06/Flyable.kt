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
