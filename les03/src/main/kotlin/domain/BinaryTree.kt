package domain

data class BinaryTree<T> constructor(private val data: T,
                                     private val left: BinaryTree<T>? = null,
                                     private val right: BinaryTree<T>? = null) {

    val size: Int
        get() {
            var count = 1
            if(this.left != null) count += this.left.size
            if(this.right != null) count += this.right.size
            return count
        }

    val depth: Int
        get() {
            if (this.left == null && this.right == null) {
                return 1 // No children
            } else if (this.left == null) {
                return 1 + this.right!!.depth // Only children right
            } else if (this.right == null) {
                return 1 + this.left!!.depth // Only children left
            }
            // Children both right and left
            return 1 + Math.max(this.left.depth, this.right.depth)
        }

    val isLeaf: Boolean
        get() = this.left == null && this.right == null

    fun visitInOrder(cb: (Tree: BinaryTree<T>) -> Unit) {
        this.left?.visitInOrder(cb)
        cb(this)
        this.right?.visitInOrder(cb)

    }

    fun visitPreOrder(cb: (Tree: BinaryTree<T>) -> Unit) {
        cb(this)
        this.left?.visitPreOrder(cb)
        this.right?.visitPreOrder(cb)
    }

    fun visitPostOrder(cb: (Tree: BinaryTree<T>) -> Unit) {
        this.left?.visitPostOrder(cb)
        this.right?.visitPostOrder(cb)
        cb(this)
    }

    fun withSpace(Tree: BinaryTree<T>) = ("${Tree.data.toString()} ")
    fun printPreOrder() = visitPreOrder { print(withSpace(it)) }
    fun printInOrder() = visitInOrder { print(withSpace(it)) }
    fun printPostOrder() = visitPostOrder { print(withSpace(it)) }
    fun printDataLeaves() = visitInOrder { if(it.isLeaf) print(withSpace(it)) }

    fun countLeaves(): Int {
        if (isLeaf) return 1

        var count = 0
        if(this.left != null) count += this.left.countLeaves()
        if(this.right != null) count += this.right.countLeaves()
        return count
    }

    fun contains(element: T): Boolean {
        var contains = false
        visitInOrder {
            if(it.data == element) contains = true
        }
        return contains
    }
}