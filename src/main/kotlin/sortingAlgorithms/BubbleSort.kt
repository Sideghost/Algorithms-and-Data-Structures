package sortingAlgorithms

import otherAlgorithms.exchange

/**
 * Bubble Sort Algorithm of a generic [Array].
 *
 * Time complexity O(n^2)
 * @param array Array to Sort.
 * @param cmp Generic Comparator.
 */
fun <T> bubbleSort(array: Array<T>, cmp: Comparator<T>) {
	for (i in array.indices)
		for (j in array.lastIndex downTo i + 1)
			if (cmp.compare(array[j], array[j - 1]) < 0)
				exchange(array, j, j - 1)
}
