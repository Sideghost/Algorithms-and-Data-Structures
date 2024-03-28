package sortingAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class InsertionSortTest {

	@Test
	fun `sort array`() {
		val array = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = array
		expected.sort()
		insertionSort(array) { a, b -> a - b }

		assertArrayEquals(array, expected)
	}

	@Test
	fun `sort array with known array`() {
		val array = arrayOf(4, 3, 12, 1, 5, 5, 3, 9)
		val expected = array
		expected.sort()
		insertionSort(array) { a, b -> a - b }

		assertArrayEquals(array, expected)
	}
}
