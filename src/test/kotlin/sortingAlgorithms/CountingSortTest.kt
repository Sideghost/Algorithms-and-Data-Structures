package sortingAlgorithms

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountingSortTest {

	@Test
	fun `sort array`() {
		val sut = Array(10) { (Math.random() * 10).toInt() }
		val expected = sut
		expected.sort()
		countingSort(sut) { a, b -> a - b }
		assertArrayEquals(sut, expected)
	}

	@Test
	fun `sort array with known array`() {
		val sut = arrayOf(4, 3, 12, 1, 5, 5, 3, 9)
		val expected = sut
		expected.sort()
		countingSort(sut) { a, b -> a - b }
		assertArrayEquals(sut, expected)
	}
}
