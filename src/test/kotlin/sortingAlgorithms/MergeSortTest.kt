package sortingAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class MergeSortTest {

	@Test
	fun `sort array`() {
		val array = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = array
		expected.sort()
		mergeSort(array, 0, array.size - 1) { a, b -> a - b }
		assertArrayEquals(expected, array)
	}

	@Test
	fun `sort array with negative numbers`() {
		val array = Array(10) { ((Math.random() * 10) - 5).roundToInt() }
		val expected = array
		expected.sort()
		mergeSort(array, 0, array.size - 1) { a, b -> a - b }
		assertArrayEquals(expected, array)
	}
}
