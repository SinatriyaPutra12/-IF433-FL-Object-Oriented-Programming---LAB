package oop_00000070427_sinatriyaariaputra.week10

class WalletRepository<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items.toList()
    }

    fun remove(item: T): Boolean {
        return items.remove(item)
    }

    fun count(): Int {
        return items.size
    }

    fun clear() {
        items.clear()
    }

    fun search(predicate: (T) -> Boolean): List<T> {
        return items.filter(predicate)
    }
}
