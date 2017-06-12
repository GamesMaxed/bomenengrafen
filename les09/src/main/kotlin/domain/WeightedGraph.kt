package domain

import java.util.ArrayList

class WeightedGraph(private val gewichtenMatrix: Array<DoubleArray>) {
    companion object {
        val POSITIVE_INFINITY = java.lang.Double.POSITIVE_INFINITY
    }

    init {
        if (gewichtenMatrix.size != gewichtenMatrix[0].size) throw IllegalArgumentException("No valid gewichtenmatrix")
    }

    fun findDistances(): Array<IntArray> {
        val path = Array(gewichtenMatrix.size) { IntArray(gewichtenMatrix.size) }
        val distanceMatrix = Array(gewichtenMatrix.size) { DoubleArray(this.gewichtenMatrix.size) }
        gewichtenMatrix.indices.forEach { i ->
            gewichtenMatrix.indices.forEach { j -> distanceMatrix[i][j] = this.gewichtenMatrix[i][j] }
        }

        // oefening 2.3

        return path
    }

    fun getShortestPath(i: Int, j: Int, path: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()

        // oefening 2.4

        return res

    }

    fun berekenLengte(pad: List<Int>): Int {
        val som = 0

        // oefening 2.5

        return som
    }
}
