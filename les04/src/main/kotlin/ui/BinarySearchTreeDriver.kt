package ui

import domain.BinarySearchTree


fun main(args: Array<String>) {
    val boom = BinarySearchTree(6)
    boom.addNode(4)
    boom.addNode(8)
    boom.addNode(3)
    boom.addNode(5)
    boom.addNode(7)
    boom.addNode(9)
    boom.printInOrder()
    println()
    println("De grootste waarde uit deze boom = " + boom.searchGreatest())
    println("De kleinste waarde uit deze boom = " + boom.searchSmallest())
}