package domain

import sun.misc.Queue
import java.util.*

class Graph(matrix: Array<IntArray>) {
    companion object {
        val POSITIVE_INFINITY = Float.POSITIVE_INFINITY.toInt()
    }

    private val linkMatrix: Array<BooleanArray>
    private val amountOfNodes: Int
        get() = linkMatrix.size

    init {
        if (!isLegitmateLinkMatrix(matrix))
            throw IllegalArgumentException("No valid nabijheidsmatrix")

        linkMatrix = Array(matrix.size) { BooleanArray(matrix.size) }
        for (i in matrix.indices)
            for (j in matrix.indices)
                this.linkMatrix[i][j] = matrix[i][j] == 1
    }

    private fun isLegitmateLinkMatrix(matrix: Array<IntArray>?): Boolean {
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

    private fun hasLink(from: Int, to: Int) = linkMatrix[from][to]

    private fun findAncestors(start: Int, destination: Int): IntArray {
        val ancestors = IntArray(amountOfNodes) { POSITIVE_INFINITY }

        val queue = Queue<Int>()
        queue.enqueue(start)
        ancestors[start] = POSITIVE_INFINITY // You can't go to the link you started

        var currentNode = queue.dequeue()
        while (currentNode != destination) {
            for(node in 0 until amountOfNodes) {
                if(hasLink(currentNode, node) && ancestors[node] == POSITIVE_INFINITY && node != start) {
                    queue.enqueue(node)
                    ancestors[node] = currentNode
                }
            }
            if(queue.isEmpty) {
                break // No reason to keep on going
            }
            currentNode = queue.dequeue()
        }
        return ancestors
    }

    private fun path(start: Int, destination: Int): List<Int> {
        val ancestors = findAncestors(start, destination)
        if(ancestors.isEmpty() || ancestors[destination] == POSITIVE_INFINITY) {
            return emptyList()
        }

        val path = LinkedList<Int>()
        path.add(ancestors[destination])

        while(path.last != start) {
            if(path.last == POSITIVE_INFINITY) return emptyList()
            path.add(ancestors[path.last])
        }
        return path.reversed()
    }

    fun findPath(start: Int, destination: Int): List<Int> {
        return path(start - 1, destination - 1)
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    fun giveAncestors(start: Int, destination: Int): String {
        val sb = StringBuilder()
        sb.append("Ancestors van $start naar $destination:\n")
        val ancestors = findAncestors(start - 1, destination - 1)
                .map { if (it != POSITIVE_INFINITY) (it + 1).toString() else "POSITIVE_INFINITY" }
                .joinToString(separator = " -> ")
        sb.append(ancestors)
        return sb.toString()
    }


}