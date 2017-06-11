package ui

import domain.BinaryTree

fun main(args: Array<String>) {
    val boom =
            BinaryTree("C",
                BinaryTree("A",
                        BinaryTree("D"),
                        BinaryTree("F")
                ),
                BinaryTree("G",
                        BinaryTree("E",
                                BinaryTree("H")
                        ),
                        BinaryTree("B")
                )
            )

    boom.printPreorder()
}