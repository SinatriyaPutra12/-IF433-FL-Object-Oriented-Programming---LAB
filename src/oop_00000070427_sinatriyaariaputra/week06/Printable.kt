package oop_00000070427_sinatriyaariaputra.week06

interface Printable {
    val documentName: String
    fun print()
    fun preview() { println("[PREVIEW] $documentName siap untuk dicetak.") }
}

interface Saveable { fun save(filename: String) }

class PDFDocument(override val documentName: String, val content: String) : Printable, Saveable {
    override fun print() { println("[PDF] Mencetak '$documentName'...\nIsi: $content") }
    override fun save(filename: String) { println("[PDF] Menyimpan sebagai '$filename.pdf'") }
}

class WordDocument(override val documentName: String, val author: String) : Printable, Saveable {
    override fun print() { println("[WORD] Mencetak '$documentName'...\nAuthor: $author") }
    override fun save(filename: String) { println("[WORD] Menyimpan sebagai '$filename.docx'") }
    override fun preview() { println("[WORD PREVIEW] '$documentName' oleh $author") }
}

class ConsolePrinter(override val documentName: String, val text: String) : Printable {
    override fun print() { println("[CONSOLE] === $documentName ===\n$text\n[CONSOLE] ==================") }
}

fun sendToPrinter(doc: Printable) { doc.preview(); doc.print(); println() }
