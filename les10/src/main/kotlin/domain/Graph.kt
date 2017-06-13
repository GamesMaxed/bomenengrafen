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
        val res = initMatrixDijkstra(from - 1)

        printMatrix("Initiele matrix:", res)

        // oefening 3.4

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
