package ui

import domain.WeightedGraph

internal val POSITIVE_INFINITY = WeightedGraph.POSITIVE_INFINITY

fun main(args: Array<String>) {

    val matrix = arrayOf(
            doubleArrayOf(0.0, 1.0, POSITIVE_INFINITY, 1.0, 5.0),
            doubleArrayOf(9.0, 0.0, 3.0, 2.0, POSITIVE_INFINITY),
            doubleArrayOf(POSITIVE_INFINITY, POSITIVE_INFINITY, 0.0, 4.0, POSITIVE_INFINITY),
            doubleArrayOf(POSITIVE_INFINITY, POSITIVE_INFINITY, 2.0, 0.0, 3.0),
            doubleArrayOf(3.0, POSITIVE_INFINITY, POSITIVE_INFINITY, POSITIVE_INFINITY, 0.0)
    )
    //double[][] matrix = {{0,2,3,11,POSITIVE_INFINITY},{POSITIVE_INFINITY,0,POSITIVE_INFINITY,7,POSITIVE_INFINITY},{POSITIVE_INFINITY,POSITIVE_INFINITY,0,4,POSITIVE_INFINITY},{POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,0,1},{POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,POSITIVE_INFINITY,0}};

    printMatrix("Matrix:", matrix.map { it.toTypedArray() }.toTypedArray())

    val g = WeightedGraph(matrix)
    val p_matrix = g.findDistances()

    printMatrix("Weighted matrix:", matrix.map { it.toTypedArray() }.toTypedArray())

    val sb = StringBuilder()
    sb.append("Kortste paden: \n")
    (1..matrix.size).forEach { i ->
        (1..matrix.size).forEach { j ->
            val pad = g.getShortestPath(i, j, p_matrix)
            sb.append(when {
                pad.isEmpty() -> "Er is geen pad van $i naar $j\n"
                else ->"Kortste pad van $i naar $j lengte = ${g.berekenLengte(pad)} via: $pad \n"
            })

        }
        sb.append("\n")
    }
    println(sb.toString())
}

private fun <T : Comparable<T>> printMatrix(name: String, matrix: Array<Array<T>>) {
    val sb = StringBuilder()
    sb.append("$name: \n")
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            sb.append(if (matrix[i][j] == POSITIVE_INFINITY) "inf" else matrix[i][j]).toString() + "\t")
        }
        sb.append("\n")
    }
    sb.append("\n")

    println(sb.toString())
}