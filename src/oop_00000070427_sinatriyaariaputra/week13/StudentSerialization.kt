package oop_00000070427_sinatriyaariaputra.week13

import java.io.File
import java.io.FileNotFoundException

data class Student(val name: String, val age: Int, val gpa: Double)

// Serialization (Object -> CSV)
fun Student.toCsv(): String = "name,age,gpa"

// Deserialization (CSV -> Object)
fun fromCsv(line: String): Student {
    val parts = line.split(delimiters = ",")
    return Student(name = parts[0], age = parts[1].toInt(), gpa = parts[2].toDouble())
}

fun saveStudents(students: List<Student>, path: String) {
    File(pathname = path).writeText(students.joinToString(separator = "\n") { it.toCsv() })
}

fun loadStudents(path: String): List<Student> {
    return try {
        File(pathname = path).readLines().map { fromCsv(line = it) }
    } catch (e: FileNotFoundException) {
        println("Error: File tidak ditemukan!")
        emptyList()
    }
}

fun main() {
    val students = listOf(
        Student(name = "Alice", age = 20, gpa = 3.8),
        Student(name = "Bob",   age = 22, gpa = 3.5)
    )

    saveStudents(students, path = "students.csv")

    val loaded = loadStudents(path = "students.csv")
    println("=== LOADED STUDENT DATA ===")
    loaded.forEach { println(it) }
}
