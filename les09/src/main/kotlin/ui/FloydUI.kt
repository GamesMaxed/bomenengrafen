package ui

import domain.WeightedGraph

internal val POSITIVE_INFINITY = WeightedGraph.POSITIVE_INFINITY

fun main(args: Array<String>) {
    val matrix = listOf(
            listOf(0.0, 1.0, POSITIVE_INFINITY, 1.0, 5.0),
            listOf(9.0, 0.0, 3.0, 2.0, POSITIVE_INFINITY),
            listOf(POSITIVE_INFINITY, POSITIVE_INFINITY, 0.0, 4.0, POSITIVE_INFINITY),
            listOf(POSITIVE_INFINITY, POSITIVE_INFINITY, 2.0, 0.0, 3.0),
            listOf(3.0, POSITIVE_INFINITY, POSITIVE_INFINITY, POSITIVE_INFINITY, 0.0)
    )
    //double[][] matrix = {{0,2,3,11,POSITIVE_INFINITY},{POSITIVE_INFINITY,0,POSITIVE_INFINITY,7,POSITIVE_INFINITY},{POSITIVE_INFINITY,POSITIVE_INFINITY,0,4,POSITIVE_INFINITY},{POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,0,1},{POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,0}};

    printMatrix("Matrix", matrix)

    val g = WeightedGraph(matrix)
    val p_matrix = g.findDistances()

    printMatrix("Pointer matrix", p_matrix)

    val sb = StringBuilder()
    sb.append("Kortste paden: \n")
    (1..matrix.size).forEach { i ->
        (1..matrix.size).forEach { j ->
            val pad = g.getShortestPath(i, j, p_matrix)
            sb.append(when {
                pad.isEmpty() -> "Er is geen pad van $i naar $j\n"
                else ->"Kortste pad van $i naar $j lengte = ${g.calculateLength(pad)} via: ${pad.joinToString(separator = " -> ")} \n"
            })

        }
        sb.append("\n")
    }
    println(sb.toString())

    //println(g.getShortestPath(2, 1, p_matrix).joinToString(separator = " -> "))
}

fun <T : Comparable<T>> printMatrix(name: String, matrix: List<List<T>>) {
    val sb = StringBuilder()
    sb.append("$name: \n")
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            sb.append(when(matrix[i][j]) {
                POSITIVE_INFINITY  -> "+∞"
                else -> matrix[i][j].toString()
            } + "\t")

        }
        sb.append("\n")
    }
    sb.append("\n")

    println(sb.toString())
}