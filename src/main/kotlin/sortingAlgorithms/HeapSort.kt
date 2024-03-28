package sortingAlgorithms

import otherAlgorithms.exchange

/**
 * Heap sort algorithm of a generic [Array].
 * Time complexity O(n log n)
 *
 * @param array Array to sort.
 * @param cmp Comparator criteria.
 */
fun <E> heapSort(array: Array<E>, cmp: Comparator<E>) {
	val n = array.size

	for (i in n / 2 - 1 downTo 0) {
		heapify(array, n, i, cmp)
	}

	for (i in n - 1 downTo 0) {
		exchange(array, 0, i)
		heapify(array, i, 0, cmp)
	}
}

/**
 * Heapify algorithm of a generic [Array].
 *
 * @param array Array to heapify.
 * @param n Size of the array.
 * @param i Index of the array.
 * @param cmp Comparator criteria.
 */
fun <E> heapify(array: Array<E>, n: Int, i: Int, cmp: Comparator<E>) {
	var largest = i
	val left = 2 * i + 1
	val right = 2 * i + 2

	if (left < n && cmp.compare(array[left], array[largest]) > 0) {
		largest = left
	}

	if (right < n && cmp.compare(array[right], array[largest]) > 0) {
		largest = right
	}

	if (largest != i) {
		exchange(array, i, largest)
		heapify(array, n, largest, cmp)
	}
}
