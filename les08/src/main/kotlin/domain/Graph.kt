package domain

import java.util.LinkedList

class Graph(matrix: Array<IntArray>) {
    companion object {
        val MAX_INFINITY = Integer.MAX_VALUE
    }

    private val verbindingsMatrix: Array<BooleanArray>

    init {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw IllegalArgumentException("No valid nabijheidsmatrix")

        this.verbindingsMatrix = Array(matrix.size) { BooleanArray(matrix.size) }
        for (i in matrix.indices)
            for (j in matrix.indices)
                this.verbindingsMatrix[i][j] = matrix[i][j] == 1
    }

    private fun isGeldigeVerbindingsMatrix(matrix: Array<IntArray>?): Boolean {
        if (matrix == null || matrix.size != matrix[0].size)
            return false

        for (i in matrix.indices) {
            if (matrix[i][i] != 0) return false
        }

        for (i in matrix.indices) {
            for (j in matrix.indices) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) return false
            }
        }
        return true
    }

    private val aantalKnopen: Int
        get() = this.verbindingsMatrix.size

    private fun findAncestors(start: Int, destination: Int): IntArray {// nummering van
        // start-knoop
        // (1..aantal_knopen)
        // naar
        // eindKnoop
        // (destination)
        val ancestors = IntArray(this.aantalKnopen)
        initArray(ancestors, MAX_INFINITY)

        val queue = LinkedList<Int>()
        queue.add(start)
        ancestors[start - 1] = 0

        // oefening 1.4

        return ancestors
    }

    fun findPath(start: Int, destination: Int): List<Int> {
        if (start <= 0 || start > this.aantalKnopen || destination <= 0 || destination > this.aantalKnopen)
            throw IllegalArgumentException()

        val ancestors = this.findAncestors(start, destination)
        val path = LinkedList<Int>()

        // oefening 1.5

        return path

    }

    private fun initArray(array: IntArray, value: Int) {
        for (i in array.indices)
            array[i] = value
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    fun geefAncestors(start: Int, destination: Int): String {
        var res = "Ancestors van $start naar $destination:\n"
        val ancestors = this.findAncestors(start, destination)
        for (a in ancestors.indices)
            res += if (ancestors[a] != MAX_INFINITY) ancestors[a] else "MAX_INFINITY" + " "

        return res
    }




}