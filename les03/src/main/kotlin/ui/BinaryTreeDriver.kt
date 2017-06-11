package ui

import domain.BinaryTree

fun main(args: Array<String>) {
    val nodeD = BinaryTree("D")
    val nodeF = BinaryTree("F")
    val nodeB = BinaryTree("B")
    val nodeH = BinaryTree("H")

    // knoop A heeft links D en rechts F
    val nodeA = BinaryTree("A", nodeD, nodeF)
    // knoop E heeft links H
    val nodeE = BinaryTree("E", nodeH, null)
    // knoop G heeft links E en rechts B
    val nodeG = BinaryTree("G", nodeE, nodeB)

    // boom heeft root C en heeft links A en rechts G
    val boom = BinaryTree("C", nodeA, nodeG)
    boom.printPreorder()
}