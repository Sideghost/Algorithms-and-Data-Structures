package exercices.arrays

/**
 * Function that given as array segmented in [element], gives the first index of the number higher or same as
 * [element]. Complexity O(log n).
 *
 * @param v IntArray.
 * @param element Integer to check.
 * @return Returns the first index of the array that is higher or same as element.
 */
fun partitionPoint(v: IntArray, element: Int): Int {
	//Variable initialization
	var l = 0
	var r = v.size - 1
	var mid: Int

	//Lower bound algorithm
	while (l <= r) {
		mid = l + (r - l) / 2

		if (v[mid] < element)
			l = mid + 1
		else r = mid - 1
	}

	return l
}

fun main() {
	println("Partition Point:")
	val array = intArrayOf(2, 3, 1, 4, 3, 2, 5, 7, 9, 8)
	println("Expected 7 -> ${partitionPoint(array, 6)}")
}