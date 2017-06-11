package domain

/**
 * This class is not concurrent safe
 */
class BinarySearchTree<E : Comparable<E>> constructor(private var data: E?) {
    private var leftTree: BinarySearchTree<E>? = null
    private var rightTree: BinarySearchTree<E>? = null

    val isLeaf: Boolean
        get() = rightTree == null && leftTree == null

    fun printInOrder() {
        leftTree?.printInOrder()
        print("${this.data.toString()} ")
        rightTree?.printInOrder()
    }

    fun lookup(data: E): Boolean {
        val x = data.compareTo(this.data!!)
        return when {
            x < 0 -> if (this.leftTree == null) false else leftTree!!.lookup(data)
            x == 0 -> true
            else -> if (this.rightTree == null) false else rightTree!!.lookup(data)
        }
    }

    fun addNode(data: E): Boolean {
        val x = data.compareTo(this.data!!)
        return when {
            x < 0 -> {
                if (this.leftTree == null) {
                    this.leftTree = BinarySearchTree(data)
                    return true
                } else return this.leftTree!!.addNode(data)
            }
            x == 0 -> false
            else -> {
                if (this.rightTree == null) {
                    this.rightTree = BinarySearchTree(data)
                    return true
                } else return this.rightTree!!.addNode(data)
            }
        }
    }

    fun cleanup() {
        if (leftTree != null) {
            if (leftTree?.data == null) leftTree = null
            else leftTree?.cleanup()
        }
        if (rightTree != null) {
            if (rightTree?.data == null) rightTree = null
            else rightTree?.cleanup()
        }
    }

    fun removeNode(data: E): Boolean {
        cleanup()
        if (this.data == null) return false
        val comparedValues = data.compareTo(this.data!!)
        return when {
            comparedValues < 0 -> when (leftTree) {
                null -> false
                else -> this.leftTree!!.removeNode(data)
            }
            comparedValues > 0 -> when (rightTree) {
                null -> false
                else -> this.rightTree!!.removeNode(data)
            }
            else -> {
                if (isLeaf) {
                    this.data = null
                    cleanup()
                } else if (this.leftTree != null) {
                    val greatest = leftTree!!.searchGreatest()
                    this.data = greatest
                    this.leftTree!!.removeNode(greatest)
                } else if (this.rightTree != null) {
                    val smallest = rightTree!!.searchSmallest()
                    this.data = smallest
                    this.rightTree!!.removeNode(smallest)
                }
                return true
            }
        }
    }

    fun searchGreatest(): E {
        cleanup()
        return when (this.rightTree) {
            null -> data!!
            else -> return rightTree!!.searchGreatest()
        }
    }

    fun searchSmallest(): E {
        cleanup()
        return when (this.leftTree) {
            null -> data!!
            else -> return leftTree!!.searchSmallest()
        }
    }

    fun path(element: E): MutableList<E> {
        if (!lookup(element)) {
            return mutableListOf()
        }
        val result = mutableListOf(data!!)

        val compared = element.compareTo(data!!)
        if (compared == 0) return result
        else if (compared < 0) {
            result.addAll(leftTree!!.path(element))
        } else {
            result.addAll(rightTree!!.path(element))
        }
        return result
    }


    val size: Int
        get() {
            fun add(a: Int?, b: Int?): Int = when {
                a == null && b != null -> b
                a != null && b == null -> a
                a == null && b == null -> 0
                else -> a!! + b!!
            }

            return 1 + add(leftTree?.size, rightTree?.size)
        }
}

