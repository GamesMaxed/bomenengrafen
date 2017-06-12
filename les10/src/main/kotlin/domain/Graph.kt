package domain

import java.util.ArrayList

class Graph(matrix: Array<IntArray>?) {
    private val gewichtenMatrix: Array<IntArray>

    init {
        if (matrix == null || matrix.size == 0 || matrix.size != matrix[0].size) {
            throw IllegalArgumentException()
        }

        this.gewichtenMatrix = matrix.clone()
    }

    private fun initMatrixDijkstra(vanKnoop: Int): Array<IntArray> {
        val res = Array(this.gewichtenMatrix.size + 1) { IntArray(this.gewichtenMatrix.size) }
        // eerste rij is rij met kortste lengtes vanuit vanKnoop

        // oefening 3.3

        return res
    }

    fun Dijkstra(vanKnoop: Int): Array<IntArray> {
        val res = initMatrixDijkstra(vanKnoop)

        println("Initiele matrix: \n")
        printIntMatrix(res)

        // oefening 3.4

        return res
    }

    private fun vindPad(vanKnoop: Int, naarKnoop: Int, res: Array<IntArray>): ArrayList<Int> {
        val pad = ArrayList<Int>()
        // oefening 3.5
        return pad
    }

    fun berekenPaden(vanKnoop: Int): String {
        var uit = ""
        val res = this.Dijkstra(vanKnoop)

        println("Resulterende matrix: \n")
        printIntMatrix(res)

        for (i in 0..res[0].size - 1) {
            if (i + 1 != vanKnoop) {
                if (res[0][i] == Integer.MAX_VALUE) {
                    uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n"
                } else {
                    uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[0][i] + "\n"
                    uit += "via "

                    val j = i + 1
                    val pad = vindPad(vanKnoop, j, res)
                    uit += pad + "\n"
                }
            }
        }
        return uit
    }

    private fun printIntMatrix(matrix: Array<IntArray>) {
        var result = ""
        for (i in matrix.indices) {
            for (j in 0..matrix[0].size - 1) {
                result += (if (matrix[i][j] == Integer.MAX_VALUE) "inf" else matrix[i][j]).toString() + "\t"
            }
            result += "\n"
        }
        result += "\n"

        println(result)
    }

}
