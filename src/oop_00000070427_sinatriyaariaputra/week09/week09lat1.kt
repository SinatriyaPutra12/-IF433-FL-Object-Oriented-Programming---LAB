package oop_00000070427_sinatriyaariaputra.week09

fun main() {
    println("========== LIST OF ==========");
    val arSiswa = listOf("Budi", "Danu", "Susi", "Cica");

    //view
    println(arSiswa); //object -> array

    //panjang array
    println("Banyak siswa: " + arSiswa.size);

    //munculin satu orang aja
    println("Siswa bernama ${arSiswa[1]}");

    //munculin semua orang ---> for-each
    for(a in arSiswa) {
        print("Siswa " + a + " dan ");
    }

    println("========== LIST OF MUTABLE =========");
    val arMatkul = mutableListOf("OOP", "Pemweb", "Matdis", "Kalkulus");
    arMatkul.add("Algo");
    arMatkul[2] = "Aljabar Linear"
    arMatkul.remove("Pemweb");
    println(arMatkul);
}           