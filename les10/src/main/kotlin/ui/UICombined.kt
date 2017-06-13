package ui

import domain.Graph

fun main(args: Array<String>) {
    println("[0] Dijkstra")
    println("[1] Oef1")
    val choice = 0 // For now, IRL you probably need a scanner
    when (choice) {
        0 -> dijkstra()
        1 -> oef1()
        else -> {
            dijkstra()
            oef1()
        }
    }
}

fun dijkstra() {
    val gewichtenMatrix = listOf(
            listOf(0, 5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
            listOf(5, 0, 3, 8, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
            listOf(9, 3, 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE),
            listOf(Integer.MAX_VALUE, 8, 2, 0, Integer.MAX_VALUE, 3, 7, Integer.MAX_VALUE, Integer.MAX_VALUE),
            listOf(Integer.MAX_VALUE, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 8, Integer.MAX_VALUE),
            listOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 1, 0, 5, 10, Integer.MAX_VALUE),
            listOf(Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 12, Integer.MAX_VALUE),
            listOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, 10, 12, 0, Integer.MAX_VALUE),
            listOf(1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0)
    )
    val graph = Graph(gewichtenMatrix)
    println(graph.calculatePath(1))
}

fun oef1() {
    val matrix = listOf(
            listOf(0, 7, 0, 6, 0, 0, 0, 0),
            listOf(7, 0, 4, 0, 2, 6, 0, 0),
            listOf(3, 4, 0, 0, 0, 0, 0, 0),
            listOf(6, 0, 1, 0, 0, 0, 0, 9),
            listOf(0, 0, 5, 0, 0, 3, 8, 0),
            listOf(0, 6, 0, 0, 3, 0, 6, 0),
            listOf(0, 0, 0, 0, 8, 6, 0, 7),
            listOf(0, 0, 0, 9, 4, 0, 0, 0)
    )
    val graph = Graph(matrix)

    println(graph.calculatePath(3))
}
