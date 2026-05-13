package oop_00000070427_sinatriyaariaputra.week11

// Extension function dengan receiver 'this'
fun String.addGreeting(): String {
    return "Hello, $this"
}

// Extension function dengan parameter
fun String.repeatTimes(n: Int): String {
    return this.repeat(n)
}

// Nullable receiver - 'this' bisa bernilai null
fun String?.isNullOrEmptyCustom(): Boolean {
    return this == null || this.isEmpty()
}
