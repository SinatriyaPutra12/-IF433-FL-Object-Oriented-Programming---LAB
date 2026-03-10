package oop_00000070427_sinatriyaariaputra.week06

interface Identifiable {
    val id: String
    val displayInfo: String get() = "ID: $id"
}

class Employee(override val id: String, val name: String) : Identifiable

class Product(override val id: String, val productName: String) : Identifiable {
    override val displayInfo: String get() = "Product[$id]: $productName"
}
