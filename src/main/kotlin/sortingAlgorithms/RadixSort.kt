package sortingAlgorithms

/**
 * Radix sort for a generic [Array].
 * Time Complexity: O(nk)
 *
 * @param array array.
 * @param radix radix.
 */
fun <E> radixSort(array: Array<E>, radix: Int) {
	val count = IntArray(radix)
	val output = array

	for (i in 0 until radix) {
		count[i] = 0
	}

	for (element in array) {
		val index = (element as Int) / radix
		count[index % radix]++
	}

	for (i in 1 until radix) {
		count[i] += count[i - 1]
	}

	for (i in array.size - 1 downTo 0) {
		val index = (array[i] as Int) / radix
		output[count[index % radix] - 1] = array[i]
		count[index % radix]--
	}

	for (i in array.indices) {
		array[i] = output[i]
	}
}
