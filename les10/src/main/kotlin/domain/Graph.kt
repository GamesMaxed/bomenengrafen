package domain

class Graph(private val weightedMatrix: List<List<Int>>) {
    companion object {
        val POSITIVE_INFINITY = java.lang.Double.POSITIVE_INFINITY.toInt()
    }

    init {
        if (weightedMatrix.isEmpty() || weightedMatrix.size != weightedMatrix[0].size) {
            throw IllegalArgumentException()
        }
    }

    private fun initMatrixDijkstra(from: Int): List<List<Int>> {
        val res = MutableList(weightedMatrix.size + 1) {
            List(weightedMatrix.size) { if (it == from) 0 else POSITIVE_INFINITY }
        }

        weightedMatrix.withIndex().forEach { (index, row) ->
            res[index + 1] = row.map { if (it == POSITIVE_INFINITY) 0 else it }
        }

        return res
    }

    fun Dijkstra(from: Int): List<List<Int>> {
        val res = initMatrixDijkstra(from - 1).map { it.toMutableList() }

        printMatrix("Initiele matrix:", res)

        // Keep looping until breaked out
        while (true) {
            var indexSmallestJ = 0
            var indexSmallestI = 0
            var smallest = POSITIVE_INFINITY

            weightedMatrix.indices.forEach { i ->
                if (res[0][i] != POSITIVE_INFINITY) {
                    // doorzoek alle knopen waar nog geen kortste pad voor werd
                    // gevonden en die bereikbaar zijn uit knopen waar reeds korste pad voor
                    // werd gevonden en zoek hierin de kleinste afstand
                    weightedMatrix.indices.forEach { j ->
                        if (res[i + 1][j] != 0
                                && res[0][j] == POSITIVE_INFINITY
                                && res[0][i] + res[i + 1][j] < smallest) {
                            indexSmallestI = i + 1
                            indexSmallestJ = j
                            smallest = res[0][i] + res[i + 1][j]
                        }
                    }
                }
            }
            if (smallest == POSITIVE_INFINITY) {
                break
            }
            res[0][indexSmallestJ] = smallest
            weightedMatrix.indices.forEach { i ->
                if (i != indexSmallestI) res[i][indexSmallestJ] = 0
            }
        }

        return res
    }

    private fun findPath(from: Int, to: Int, res: List<List<Int>>): List<Int> {
        val pad = listOf<Int>()
        // oefening 3.5
        return pad
    }

    fun calculatePath(from: Int): String {
        val sb = StringBuilder()
        val res = Dijkstra(from)

        printMatrix("Resulterende matrix", res)

        for (i in 0..res[0].size - 1) {
            if (i + 1 != from) {
                if (res[0][i] == Integer.MAX_VALUE) {
                    sb.append("Er is geen pad van $from naar ${i + 1} = ${res[0][i]}\n")
                } else {
                    sb.append("Kortste afstand van $from naar ${i + 1} = ${res[0][i]}\n")
                    sb.append("via ")

                    sb.append("${findPath(from, i + 1, res)} \n")
                }
            }
        }
        return sb.toString()
    }

    private fun <T : Comparable<T>> printMatrix(name: String, matrix: List<List<T>>) {
        val sb = StringBuilder()
        sb.append("$name: \n")
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                sb.append(when (matrix[i][j]) {
                    POSITIVE_INFINITY -> "+∞"
                    else -> matrix[i][j].toString()
                } + "\t")

            }
            sb.append("\n")
        }
        sb.append("\n")

        println(sb.toString())
    }

}
