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
fun <E> binarySearch(array: Array<E>, elem: E, cmp: Comparator<E>, l: Int, r: Int): Int {
	if (l > r) return -1
	val mid = l + (r - l) / 2
	return when {
		cmp.compare(elem, array[mid]) == 0 -> mid
		cmp.compare(elem, array[mid]) > 0 -> binarySearch(array, elem, cmp, mid + 1, r)
		else -> binarySearch(array, elem, cmp, l, mid - 1)
	}
}
