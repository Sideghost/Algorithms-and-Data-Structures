package sortingAlgorithms

import kotlin.math.roundToInt
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RadixSortTest {

	@Test
	fun `sort array`() {
		val array = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = array
		expected.sort()
		radixSort(array, 10)

		assertArrayEquals(expected, array)
	}

	@Test
	fun `sort array with negative numbers`() {
		val array = Array(10) { ((Math.random() * 10) - 5).roundToInt() }
		val expected = array
		expected.sort()
		radixSort(array, 10)

		assertArrayEquals(expected, array)
	}
}
