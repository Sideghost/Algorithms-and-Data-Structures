package search_Algorithms

import sorting_Algorithms.quickSort
import kotlin.math.roundToInt

/**
 * Binary Search Algorithm.
 *
 * Time complexity O(log2n).
 * @param array array to search for [elem].
 * @param l index.
 * @param r index.
 * @param elem element to search.
 * @return Returns the index of the element or -1 as error message.
 */
fun <E> binarySearch(array :Array<E>, l:Int, r:Int, elem :E, cmp: Comparator<E>) :Int {
    if (l>r) return -1
    val mid = l-(l-r)/2
    if (cmp.compare(elem, array[mid]) == 0) return mid
    return if(cmp.compare(elem, array[mid]) > 0)
        binarySearch(array,mid + 1, r,elem, cmp)
    else binarySearch(array,l, mid-1,elem, cmp)
}

fun main() {
    val array = Array(50) {(Math.random()*50).roundToInt()}

    println("First Array**********")
    println("Unsorted Array-----------")
    println(array.asList())

    val element = array.random()

    quickSort(array, 0, array.lastIndex) { a, b -> a - b}
    val index = binarySearch(array, 0, array.lastIndex, element) {a, b -> a - b}

    println("Sorted Array-----------")
    println(array.asList())

    println("Element to Search -> $element")
    println("Index of Element -> $index")
    println()

    val secondArray = Array(50) {(Math.random()*50).roundToInt()}

    println("Second Array**********")
    println("Unsorted Array-----------")
    println(secondArray.asList())

    val secondElement = (51..Int.MAX_VALUE).random()

    quickSort(secondArray,0,secondArray.lastIndex) {x,y -> x - y}
    val secondIndex = binarySearch(secondArray, 0, array.lastIndex, secondElement) {a, b -> a - b}

    println("Sorted Array-----------")
    println(secondArray.asList())

    println("Element to Search -> $secondElement")
    println("Index of Element -> $secondIndex")
    if (secondIndex == -1) println("Element not found")
}