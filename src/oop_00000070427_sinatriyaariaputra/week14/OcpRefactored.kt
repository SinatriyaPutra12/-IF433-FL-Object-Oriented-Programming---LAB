package oop_00000070427_sinatriyaariaputra.week14

interface DiscountStrategy {
    fun apply(price: Double): Double
}

class StudentDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.80
}

class MemberDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.85
}

class EmployeeDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.70
}

// Diskon baru ditambah tanpa menyentuh SafeDiscountCalculator sama sekali
class SeniorDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.75
}

class SafeDiscountCalculator(private val strategy: DiscountStrategy) {
    fun calculate(price: Double) = strategy.apply(price)
}
