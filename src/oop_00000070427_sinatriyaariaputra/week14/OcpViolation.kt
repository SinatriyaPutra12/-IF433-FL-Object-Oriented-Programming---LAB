package oop_00000070427_sinatriyaariaputra.week14

class DiscountCalculator {
    fun calculate(price: Double, type: String): Double {
        return when (type) {
            "student"  -> price * 0.80
            "member"   -> price * 0.85
            "employee" -> price * 0.70
            // Setiap ada diskon baru (misal: senior/VIP), class ini harus dimodifikasi!
            else -> price
        }
    }
}
