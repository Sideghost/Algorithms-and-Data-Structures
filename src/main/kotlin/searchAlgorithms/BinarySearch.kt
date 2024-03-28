package searchAlgorithms

/**
 * Binary Search Algorithm.
 *
 * Time complexity O(log₂n).
 * @param array array to search for [elem].
 * @param l index.
 * @param r index.
 * @param elem element to search.
 * @return Returns the index of the element or -1 as an error message.
 */
fun <E> binarySearch(array: Array<E>, l: Int, r: Int, elem: E, cmp: Comparator<E>): Int {
	if (l > r) return -1
	val mid = l - (l - r) / 2
	if (cmp.compare(elem, array[mid]) == 0) return mid
	return if (cmp.compare(elem, array[mid]) > 0)
		binarySearch(array, mid + 1, r, elem, cmp)
	else binarySearch(array, l, mid - 1, elem, cmp)
}
