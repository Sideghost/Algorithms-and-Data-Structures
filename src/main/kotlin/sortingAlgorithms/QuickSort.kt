package sortingAlgorithms

import otherAlgorithms.exchange

/**
 * Quick Sort Algorithm of a generic [Array].
 *
 * Time Complexity: O(nlog₂n)
 * @param array array.
 * @param left left index.
 * @param right right index.
 * @param cmp Comparator criteria.
 */
fun <E> quickSort(array: Array<E>, left: Int, right: Int, cmp: Comparator<E>) {
	if (left > right) return
	val index = partition(array, left, right, cmp)
	quickSort(array, left, index - 1, cmp)
	quickSort(array, index + 1, right, cmp)
}

/**
 * Auxiliar Partition Algorithm of a generic [Array].
 *
 * Time Complexity: O(n).
 * @param array array.
 * @param left left index.
 * @param right right index.
 * @return index of pivot.
 */
fun <E> partition(array: Array<E>, left: Int, right: Int, cmp: Comparator<E>): Int {
	var i = left - 1
	var j = right
	val pivot = array[right]
	while (true) {
		while (i < right && cmp.compare(array[++i], pivot) < 0);
		while (j > left && cmp.compare(array[--j], pivot) > 0);
		if (j == left || i >= j) break
		exchange(array, i, j)
	}
	exchange(array, i, right)
	return i
}
