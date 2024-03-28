package searchAlgorithms

import kotlin.math.roundToInt
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals
import sortingAlgorithms.quickSort

class LinearSearchTest {

	@Test
	fun `linear Search in a sorted array`() {
		val array = Array(50) { (Math.random() * 50).roundToInt() }
		val element = array.random()

		quickSort(array, 0, array.lastIndex) { a, b -> a - b }
		val index = linearSearch(array, element) { a, b -> a - b }

		assertEquals(array[index], element)
	}

	@Test
	fun `linear Search in an unsorted array`() {
		val array = Array(50) { (Math.random() * 50).roundToInt() }
		val element = array.random()

		val index = linearSearch(array, element) { a, b -> a - b }

		assertEquals(array[index], element)
	}
}
