package domain

class BinaryMinHeap<E : Comparable<E>> {
    private val values = mutableListOf<E>()

    val min
        get() = values[0]

    private fun parentIndex(i: Int): Int = Math.floorDiv(i - 1, 2)
    private fun hasParent(i: Int): Boolean = i >= 1
    private fun parent(i: Int) = values.getOrNull(parentIndex(i))
    private fun leftIndex(i: Int) = 2 * i + 1
    private fun hasLeft(i: Int) = leftIndex(i) < values.size
    private fun left(i: Int) = values.getOrNull(leftIndex(i))
    private fun rightIndex(i: Int) = 2 * i + 2
    private fun hasRight(i: Int) = rightIndex(i) < values.size
    private fun right(i: Int) = values.getOrNull(rightIndex(i))
    private fun hasChildren(i: Int) = hasLeft(i) || hasRight(i)

    private fun swap(a: Int, b: Int) {
        val tmp = values[a]
        values[a] = values[b]
        values[b] = tmp
    }

    fun check(): Boolean {
        for ((i, current) in values.withIndex()) {
            if (hasLeft(i) && left(i)!! <= current) return false
            if (hasRight(i) && right(i)!! <= current) return false
        }
        return true
    }

    fun print() {
        println(values)
    }

    fun addValue(value: E?): Boolean {
        if (value == null) throw IllegalArgumentException()
        values.add(value) //achteraan toevoegen
        this.bubbleUp() //bubbleUp vanaf de laatste zie slides theorie
        return true
    }


    private fun bubbleUp() {
        var index = values.size - 1
        while (hasParent(index) && parent(index)!! > values[index]) {
            val parentIndex = parentIndex(index)
            swap(index, parentIndex)
            index = parentIndex
        }
    }

    fun removeSmallest(): E {
        val res = min// res bevat de kleinste = eerste element van de lijst
        values[0] = values[values.size - 1]// verwissel eerste met de laatste
        values.removeAt(values.size - 1) // verwijder de laatste
        bubbleDown() // bubble down van eerste naar beneden zie theorie
        return res
    }

    private fun bubbleDown() {
        for ((i, current) in values.withIndex()) {
            if (hasChildren(i)) {
                val left = left(i)
                val right = right(i)
                when {
                    left != null && right != null -> {
                        if (left <= right) {
                            if (current > left) {
                                swap(i, leftIndex(i))
                            }
                        } else {
                            if (current > right) {
                                swap(i, rightIndex(i))
                            }
                        }
                    }
                    left != null && right == null && current > left -> swap(i, leftIndex(i))
                    left == null && right != null && current > right -> swap(i, rightIndex(i))
                    else -> {
                    } // No need to do anything
                }
            }
        }
    }

    fun getPath(value: E): List<E> {
        val indexOfValue = values.indexOf(value)
        if (indexOfValue == -1) return listOf() // If it is not in the values

        val indexes = mutableListOf<Int>()
        var currentIndex = indexOfValue
        while (currentIndex >= 0) {
            indexes.add(currentIndex)
            currentIndex = parentIndex(currentIndex)
        }
        return indexes.map { values[it] }.reversed()
    }
}
