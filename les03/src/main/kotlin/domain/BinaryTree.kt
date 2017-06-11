package domain

data class BinaryTree<E> constructor(private val data: E,
                                     private val leftTree: BinaryTree<E>? = null,
                                     private val rightTree: BinaryTree<E>? = null) {
    fun printPreorder() {
        print(this.data.toString() + " ")
        this.leftTree?.printPreorder()
        this.rightTree?.printPreorder()
    }
}