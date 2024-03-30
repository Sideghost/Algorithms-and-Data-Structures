package exercices.arrays

import kotlin.math.abs

/**
 * Function that finds the minimal difference between 2 arrays. Complexity O(n).
 * @param elem1 IntArray.
 * @param elem2 IntArray.
 * @return Returns the minimal difference between any element in both arrays or -1 as a flag if any array is empty.
 */
fun findMinDifference(elem1: IntArray, elem2: IntArray): Int {
	//if any array is empty return a flag
	if (elem1.isEmpty() || elem2.isEmpty()) return -1

	//Variable initialization
	var idx1 = 0
	var idx2 = 0

	var a: Int
	var b: Int

	var difference: Int
	var bestDifference = abs(elem1.first() - elem2.first())

	//based on binary search algorithm
	while (idx1 < elem1.size && idx2 < elem2.size) {

		a = elem1[idx1]
		b = elem2[idx2]

		difference = abs(a - b)

		if (a > b) idx2++ else idx1++

		if (difference < bestDifference) bestDifference = difference

		//optimization
		if (bestDifference == 0) break

	}
	return bestDifference
}

fun main() {
	println("Find Min Difference:")
	val arrayA = intArrayOf(3, 27, 45, 68, 70, 81, 99)
	val arrayB = intArrayOf(9, 16, 25, 35, 75, 84)
	println("Test 1: Expected 2 -> ${findMinDifference(arrayA, arrayB)}")
}