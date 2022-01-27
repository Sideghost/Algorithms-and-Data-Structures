package search_Algorithms

import kotlin.math.roundToInt

/**
 * Linear Search Algorithm of a generic [Array].
 *
 * Time complexity O(n).
 * @param array Array to search for [element]
 * @param element Element to search.
 * @param cmp Comparator criteria.
 * @return Index of the first element.
 */
fun <E> linearSearch(array: Array<E>, element: E, cmp: Comparator<E>): Int{
    for (i in array.indices)
        if (cmp.compare(element, array[i]) == 0)
            return i
    return -1
}

fun main() {

    println("First Array-----------")

    val array = Array(50) {(Math.random()*50).roundToInt()}
    println(array.asList())

    val element = array.random()
    val index = linearSearch(array, element) {a, b -> a - b}

    println("Element to Search -> $element")
    println("Index of Element -> $index")
    println()

    println("Second Array----------")

    val secondArray = Array(50) {(Math.random()*50).roundToInt()}
    println(secondArray.asList())

    val secondElement = (51..Int.MAX_VALUE).random()
    val secondIndex = linearSearch(secondArray, secondElement) {a, b -> a - b}

    println("Element to Search -> $secondElement")
    println("Index of Element -> $secondIndex")
    if (secondIndex == -1) println("Element not found")
}