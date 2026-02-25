package oop_<00000070427>_<Sinatriya Aria Putra>.week01

enum class Grade(val description: String) {
    A("Excellent"),
    B("Good"),
    C("Average"),
    D("Poor")
}

fun calculateGrade(score: Int): Grade =
    when {
        score >= 85 -> Grade.A
        score >= 70 -> Grade.B
        score >= 60 -> Grade.C
        else -> Grade.D
    }

fun main() {
    print("Masukkan nama mahasiswa: ")
    val name = readLine()?.ifBlank { null } ?: "Unknown"

    print("Masukkan nilai: ")
    val score = readLine()?.toIntOrNull() ?: 0

    val grade = calculateGrade(score)

    println("\n=== HASIL ===")
    println("Nama  : $name")
    println("Nilai : $score")
    println("Grade : ${grade.name} (${grade.description})")
}

