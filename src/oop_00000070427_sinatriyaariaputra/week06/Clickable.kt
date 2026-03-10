package oop_00000070427_sinatriyaariaputra.week06

interface Clickable {
    fun click()
    fun showOff() { println("I am clickable!") }
}

class Button : Clickable {
    override fun click() { println("Button clicked!") }
}

class ImageView : Clickable {
    override fun click() { println("ImageView clicked!") }
    override fun showOff() { println("I am a clickable ImageView!") }
}
