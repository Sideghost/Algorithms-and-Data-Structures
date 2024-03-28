package sortingAlgorithms

import kotlin.math.roundToInt
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BubbleSortTest {

	@Test
	fun `sort array`() {
		val sut = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = sut
		expected.sort()
		bubbleSort(sut) { a, b -> a - b }
		assertArrayEquals(sut, expected)
	}

	@Test
	fun `sort array with known array`() {
		val sut = arrayOf(4, 3, 12, 1, 5, 5, 3, 9)
		val expected = sut
		expected.sort()
		bubbleSort(sut) { a, b -> a - b }
		assertArrayEquals(sut, expected)
	}

	@Test
	fun `reverse sort`() {
		val sut = Array(10) { (Math.random() * 10).roundToInt() }
		val expected = sut
		expected.sortDescending()
		bubbleSort(sut) { a, b -> b - a }
		assertArrayEquals(sut, expected)
	}
}
