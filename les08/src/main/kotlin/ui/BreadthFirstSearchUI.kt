package ui

import domain.Graph

fun main(args: Array<String>) {

    val data = arrayOf(
            intArrayOf(0, 1, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 1, 0),
            intArrayOf(0, 1, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0)
    ) // nabijheidsmatrix van graf  uit  figuur  1.5  van  cursus
    val bfs = Graph(data)

    var start = 1
    var destination = 7
    // deelresultaat afdrukken
    println(bfs.giveAncestors(start, destination))
    // eindresultaat
    println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)))

    start = 7
    destination = 1
    // deelresultaat afdrukken
    println(bfs.giveAncestors(start, destination))
    // eindresultaat
    println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)))
}

private fun zetPadOmNaarString(start: Int, destination: Int, path: List<Int>): String {
    if (path.isEmpty()) {
        return "Er is geen pad van $start naar $destination"
    }
    else {
        return "Kortste pad van " + start + " naar " + destination + " is " + path.size + " knopen lang en bestaat uit volgende knopen  : " + path
    }
}