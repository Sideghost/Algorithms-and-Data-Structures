package sortingAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class QuickSortTest {

	@Test
	fun `sort array`() {
		val array = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = array
		expected.sort()
		quickSort(array, 0, array.size - 1) { a, b -> a - b }

		assertArrayEquals(expected, array)
	}

	@Test
	fun `sort array with negative numbers`() {
		val array = Array(10) { ((Math.random() - 0.5) * 10).roundToInt() }
		val expected = array
		expected.sort()
		quickSort(array, 0, array.size - 1) { a, b -> a - b }

		assertArrayEquals(expected, array)
	}

	@Test
	fun `sort array with chars`() {
		val array = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
		val expected = array
		expected.sort()
		quickSort(array, 0, array.size - 1) { a, b -> a.compareTo(b) }

		assertArrayEquals(expected, array)
	}
}
