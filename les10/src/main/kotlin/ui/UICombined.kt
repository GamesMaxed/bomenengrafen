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
    val gewichtenMatrix = arrayOf(
            intArrayOf(0, 5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(5, 0, 3, 8, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(9, 3, 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, 8, 2, 0, Integer.MAX_VALUE, 3, 7, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 8, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 1, 0, 5, 10, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 12, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, 10, 12, 0, Integer.MAX_VALUE),
            intArrayOf(1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0)
    )
    val g = Graph(gewichtenMatrix)
    println(g.berekenPaden(1))
}

fun oef1() {
    val m = arrayOf(
            intArrayOf(0, 7, 0, 6, 0, 0, 0, 0),
            intArrayOf(7, 0, 4, 0, 2, 6, 0, 0),
            intArrayOf(3, 4, 0, 0, 0, 0, 0, 0),
            intArrayOf(6, 0, 1, 0, 0, 0, 0, 9),
            intArrayOf(0, 0, 5, 0, 0, 3, 8, 0),
            intArrayOf(0, 6, 0, 0, 3, 0, 6, 0),
            intArrayOf(0, 0, 0, 0, 8, 6, 0, 7),
            intArrayOf(0, 0, 0, 9, 4, 0, 0, 0)
    )
    val g = Graph(m)

    println(g.berekenPaden(3))
}
