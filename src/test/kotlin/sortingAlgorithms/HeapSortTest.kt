package sortingAlgorithms

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class HeapSortTest {

	@Test
	fun `sort array with known array`() {
		val array = arrayOf(12, 11, 13, 5, 6, 7)
		val expected = arrayOf(5, 6, 7, 11, 12, 13)
		heapSort(array) { a, b -> a - b }

		assertArrayEquals(array, expected)
	}
}
