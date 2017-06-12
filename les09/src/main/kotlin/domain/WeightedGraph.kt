package domain

import java.util.ArrayList

class WeightedGraph(private val weightedMatrix: List<List<Double>>) {
    companion object {
        val POSITIVE_INFINITY = java.lang.Double.POSITIVE_INFINITY
    }

    init {
        if (weightedMatrix.size != weightedMatrix[0].size) throw IllegalArgumentException("No valid weightedMatrix")
    }


    /**
     * Returns a PointerMatrix
     */
    fun findDistances(): List<List<Int>> {
        val path = MutableList(weightedMatrix.size) { MutableList(weightedMatrix.size) { 0 } }
        val distanceMatrix = weightedMatrix.map { it.toMutableList() }

        // Loop to create P(0..size)
        distanceMatrix.indices.forEach { time ->
            distanceMatrix.withIndex().forEach { (row, rowArray) ->
                rowArray.withIndex().forEach { (column, current) ->
                    // If a more optimal path is found
                    if (distanceMatrix[time][column] + distanceMatrix[row][time] < current) {
                        distanceMatrix[row][column] = current
                        path[row][column] = time + 1
                    }
                }
            }
        }
        return path
    }

    fun getShortestPath(i: Int, j: Int, path: List<List<Int>>): List<Int> {
        val res = mutableListOf<Int>()

        // oefening 2.4

        return res

    }

    fun calculateLength(path: List<Int>): Int {
        val sum = 0

        // oefening 2.5

        return sum
    }
}
