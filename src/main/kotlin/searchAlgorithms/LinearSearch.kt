package searchAlgorithms

/**
 * Linear Search Algorithm of a generic [Array].
 *
 * Time complexity O(n).
 * @param array Array to search for [element]
 * @param element Element to search.
 * @param cmp Comparator criteria.
 * @return Index of the first element.
 */
fun <E> linearSearch(array: Array<E>, element: E, cmp: Comparator<E>): Int {
	for (i in array.indices)
		if (cmp.compare(element, array[i]) == 0)
			return i
	return -1
}
