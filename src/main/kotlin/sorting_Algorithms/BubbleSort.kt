package sorting_Algorithms

import other_Algorithms.exchange
import kotlin.math.roundToInt

/**
 * Bubble Sort Algorithm of a generic [Array].
 *
 * Time complexity O(n^2)
 * @param array Array to Sort.
 * @param cmp Generic Comparator.
 */
fun <E> bubbleSort(array: Array<E>, cmp: Comparator<E>){
    for (i in array.indices)
        for (j in array.lastIndex downTo i + 1)
            if (cmp.compare(array[j], array[j-1]) < 0)
                exchange(array, j, j-1)
}

fun main() {
    println("Unsorted Array")
    val array = Array(10) {(Math.random() *10).roundToInt()}

    println("Sorted Array")
    bubbleSort(array) {a, b -> a - b}
    println(array.asList())
}