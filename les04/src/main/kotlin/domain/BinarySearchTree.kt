package domain

class BinarySearchTree<E : Comparable<E>> constructor(private val data: E) {
    private val leftTree: BinarySearchTree<E>? = null
    private val rightTree: BinarySearchTree<E>? = null

    fun printInOrder() {
            leftTree?.printInOrder()
            print("${this.data} ")
            rightTree?.printInOrder()

    }

    fun lookup(data: E): Boolean {
        val x = data.compareTo(this.data)
        return when {
            x < 0 -> if (this.leftTree == null) false else leftTree.lookup(data)
            x == 0 -> true
            else -> if(this.rightTree == null) false else rightTree.lookup(data)
        }
    }

    fun addNode(data: E): Boolean {
        return true
    }

    fun removeNode(data: E): Boolean {
        return true
    }

    fun searchGreatest(): E {
        return this.data
    }


    fun searchSmallest(): E {
        return this.data
    }
}
