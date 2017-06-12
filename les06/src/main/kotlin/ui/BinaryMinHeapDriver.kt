package ui

import domain.BinaryMinHeap

fun main(args: Array<String>) {
    val heap = BinaryMinHeap<Int>()
    heap.addValue(3)
    heap.addValue(2)
    heap.addValue(1)
    heap.addValue(0)
    heap.addValue(-1)
    heap.addValue(-2)
    heap.addValue(-4)
    heap.addValue(2)
    heap.addValue(-7)
    heap.print()
    println()
    println("Kleinste waarde = " + heap.min)
    println()
    heap.removeSmallest()
    heap.print()
    println()
    println("Kleinste waarde = " + heap.min)

    println(heap.getPath(3))
    println(heap.getPath(2))
    println(heap.getPath(5))
}