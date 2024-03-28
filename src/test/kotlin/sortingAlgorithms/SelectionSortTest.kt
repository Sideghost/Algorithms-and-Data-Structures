package sortingAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class SelectionSortTest {

	@Test
	fun `sort array`() {
		val array = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = array
		expected.sort()
		selectionSort(array) { a, b -> a - b }

		assertArrayEquals(expected, array)
	}

	@Test
	fun `sort array with negative numbers`() {
		val array = Array(10) { ((Math.random() * 10) - 5).roundToInt() }
		val expected = array
		expected.sort()
		selectionSort(array) { a, b -> a - b }

		assertArrayEquals(expected, array)
	}
}
