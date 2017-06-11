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
    boom.addNode(10)
    boom.addNode(11)
    boom.removeNode(6)
    boom.removeNode(9)
    boom.removeNode(11)
    boom.printInOrder()
    println()
    println("Path naar 7: [${boom.path(7).joinToString(", ")}]")
    println("Path naar 4: [${boom.path(4).joinToString(", ")}]")
    println("Path naar 8: [${boom.path(8).joinToString(", ")}]")
    println("De grootste waarde uit deze boom = " + boom.searchGreatest())
    println("De kleinste waarde uit deze boom = " + boom.searchSmallest())
    println("Boomgrootte ${boom.size}")
}