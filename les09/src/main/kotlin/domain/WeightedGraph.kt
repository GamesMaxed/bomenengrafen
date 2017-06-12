package domain

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
                        distanceMatrix[row][column] = distanceMatrix[time][column] + distanceMatrix[row][time]
                        path[row][column] = time + 1
                    }
                }
            }
        }

        return path
    }

    fun getShortestPath(from: Int, to: Int, path: List<List<Int>>): List<Int> {
        if (from == to) return listOf()

        val by = path[from - 1][to - 1]
        return when (by) {
            0 -> listOf(from, to)
            else -> getShortestPath(from, by, path)
                    .toMutableList()
                    .apply { addAll(getShortestPath(by, to, path)) }
                    .distinct()
        }
    }

    fun calculateLength(path: List<Int>): Double {
        var sum = 0.toDouble()
        val amountOfNodes = path.size
        var current: Int
        var next: Int
        for(i in 0 until amountOfNodes - 1) {
            current = path[i]
            next = path[i + 1]
            sum += weightedMatrix[current - 1][next - 1]
        }
        return sum
    }
}
