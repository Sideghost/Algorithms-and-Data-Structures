package searchAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals
import sortingAlgorithms.quickSort

class BinarySearchTest {
	@Test
	fun `binary Search in a sorted array`() {
		val array = Array(50) { (Math.random() * 50).roundToInt() }
		val element = array.random()

		quickSort(array, 0, array.lastIndex) { a, b -> a - b }
		val index = binarySearch(array, element, { a, b -> a - b }, 0, array.lastIndex)

		assertEquals(array[index], element)
	}

	// non-deterministic test
	@Test
	fun `binary Search in an unsorted array`() {
		val array = arrayOf(9, 2, 7, 4, 5, 6, 3, 8, 1, 0)
		val element = 2

		val index = binarySearch(array, element, { a, b -> a - b }, 0, array.lastIndex)
		assertEquals(array[index], element)
	}
}
