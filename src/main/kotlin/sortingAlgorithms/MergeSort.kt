package sortingAlgorithms

/**
 * Merge Sort Algorithm of a generic [Array].
 * Time Complexity: O(nlog₂n)
 *
 * @param array array.
 * @param left left index.
 * @param right right index.
 * @param cmp Comparator criteria.
 */
fun <E> mergeSort(array: Array<E>, left: Int, right: Int, cmp: Comparator<E>) {
	if (left < right) {
		val middle = (left + right) / 2
		mergeSort(array, left, middle, cmp)
		mergeSort(array, middle + 1, right, cmp)
		merge(array, left, middle, right, cmp)
	}
}

/**
 * Auxiliar Merge Algorithm of a generic [Array].
 * Time Complexity: O(n).
 *
 * @param array array.
 * @param left left index.
 * @param middle middle index.
 * @param right right index.
 * @param cmp Comparator criteria.
 */
fun <E> merge(array: Array<E>, left: Int, middle: Int, right: Int, cmp: Comparator<E>) {
	val leftArray = array.copyOfRange(left, middle)
	val rightArray = array.copyOfRange(middle + 1, right)
	var i = 0
	var j = 0
	var k = left
	while (i < leftArray.size && j < rightArray.size) {
		if (cmp.compare(leftArray[i], rightArray[j]) < 0) {
			array[k++] = leftArray[i++]
		} else {
			array[k++] = rightArray[j++]
		}
	}
	while (i < leftArray.size) {
		array[k++] = leftArray[i++]
	}
	while (j < rightArray.size) {
		array[k++] = rightArray[j++]
	}
}

