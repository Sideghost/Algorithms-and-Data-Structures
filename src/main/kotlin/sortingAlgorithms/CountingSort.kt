package sortingAlgorithms

/**
 * Counting sort algorithm for an array of integers.
 * Time complexity: O(n + k), where n is the number of
 * elements in the input array and k is the range of the input.
 *
 * @param inputArray The array to be sorted.
 * @param cmp The comparator to be used.
 * @return The sorted array.
 */
fun countingSort(inputArray: Array<Int>, cmp: Comparator<Int>): Array<Int> {
	var maxElem: Int = -1
	for (i in inputArray.indices) {
		if (cmp.compare(inputArray[i], maxElem) > 0) {
			maxElem = inputArray[i]
		}
	}

	val cumulativeFreq = Array(maxElem + 1) { 0 }
	for (i in inputArray.indices) {
		cumulativeFreq[inputArray[i]]++
	}

	val outputArray = Array(inputArray.size) { 0 }
	for (i in inputArray.size - 1 downTo 0) {
		outputArray[cumulativeFreq[inputArray[i]] - 1] = inputArray[i]
		cumulativeFreq[inputArray[i]]--
	}

	return outputArray
}
