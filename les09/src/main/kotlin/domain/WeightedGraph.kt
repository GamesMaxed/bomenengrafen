package domain

import java.util.ArrayList

class WeightedGraph(private val weightedMatrix: Array<DoubleArray>) {
    companion object {
        val POSITIVE_INFINITY = java.lang.Double.POSITIVE_INFINITY
    }

    init {
        if (weightedMatrix.size != weightedMatrix[0].size) throw IllegalArgumentException("No valid weightedMatrix")
    }

    fun findDistances(): Array<IntArray> {
        val path = Array(weightedMatrix.size) { IntArray(weightedMatrix.size) }
        val distanceMatrix = Array(weightedMatrix.size) { DoubleArray(weightedMatrix.size) }
        weightedMatrix.indices.forEach { i ->
            weightedMatrix.indices.forEach { j -> distanceMatrix[i][j] = weightedMatrix[i][j] }
        }

        // oefening 2.3

        return path
    }

    fun getShortestPath(i: Int, j: Int, path: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()

        // oefening 2.4

        return res

    }

    fun calculateLength(path: List<Int>): Int {
        val sum = 0

        // oefening 2.5

        return sum
    }
}
