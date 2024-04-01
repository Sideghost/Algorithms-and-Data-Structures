package exercices.arrays

import sortingAlgorithms.quickSort

/**
 *  Function that returns the median element if it is odd or the
 *  average of the two middle elements if it is even.
 *  Complexity O(n log n)
 *
 *  @param v IntArray
 *  @param l first index to iterate
 *  @param r last index to iterate
 *  @return median of the IntArray
 */
fun median(v: Array<Int>, l: Int, r: Int): Int {
	quickSort(v, l, r) { a, b -> a - b }
	return if (v.size % 2 == 0)
			((v[v.size / 2] + v[(v.size / 2) - 1]) / 2)
	else v[v.size / 2]
}
