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

    print("PreOrder: ")
    boom.printPreOrder()
    println()
    print("InOrder: ")
    boom.printInOrder()
    println()
    print("PostOrder: ")
    boom.printPostOrder()
    println()
    println("Size: ${boom.size}")
    println("Depth: ${boom.depth}")
    println("Leaves: ${boom.countLeaves()}")
    println("Contains D: ${boom.contains("D")}")
    println("Contains H: ${boom.contains("H")}")
    println("Contains F: ${boom.contains("F")}")
    println("Contains G: ${boom.contains("G")}")
    println("Contains Z: ${boom.contains("Z")}")
}