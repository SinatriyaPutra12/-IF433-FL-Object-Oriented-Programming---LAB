package oop_00000070427_sinatriyaariaputra.Lecture_Week13

import java.io.File

fun main() {
    val file1 = File( "src/oop_00000070427_sinatriyaariaputra/Lecture_Week13/contohfile.txt")
    val IsiContent = file1.readText()
    println(IsiContent)

    println("=== CARA2 - BACA ISI FILE ===")
    val contentsaya = file1.readLines()
    contentsaya.forEach {
        println(it)
    }
}