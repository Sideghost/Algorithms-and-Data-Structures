package sortingAlgorithms

import otherAlgorithms.exchange

/**
 * Selection Sort Algorithm for a generic [Array]
 * TIme Complexity: O(n^2)
 *
 * @param array: [Array] of [T] type
 *
 */
fun <T> selectionSort(array: Array<T>, cmp: Comparator<T>) {
	for (i in array.indices) {
		var minIndex = i
		for (j in i + 1 until array.size) {
			if (cmp.compare(array[j], array[minIndex]) < 0) {
				minIndex = j
			}
		}
		exchange(array, i, minIndex)
	}
}
