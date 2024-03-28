package sortingAlgorithms

/**
 * Insertion sort algorithm of a generic [Array].
 * Time complexity O(n^2)
 *
 * @param array Array to sort.
 * @param cmp Comparator criteria.
 */
fun <E> insertionSort(array: Array<E>, cmp: Comparator<E>) {
	for (i in 1 until array.size) {
		val value = array[i]
		var curIdx = i

		while (curIdx > 0 && cmp.compare(array[curIdx - 1], value) > 0) {
			array[curIdx] = array[--curIdx]
		}
		array[curIdx] = value
	}
}
