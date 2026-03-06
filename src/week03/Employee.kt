package oop_00000070427_sinatriyaariaputra.week03

class Employee(
    val name: String,
    salary: Int
) {

    var salary: Int = salary
        set(value) {
            if (value < 0) {
                println("Salary tidak boleh negatif!")
            } else {
                field = value
            }
        }

    private var performanceRating: Int = 0

    fun updateRating(rating: Int) {
        if (rating in 1..5) {
            performanceRating = rating
        } else {
            println("Rating harus antara 1 sampai 5")
        }
    }

    val yearlySalary: Int
        get() = salary * 12
}