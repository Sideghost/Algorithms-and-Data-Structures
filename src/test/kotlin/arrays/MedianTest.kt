package arrays

import exercices.arrays.median
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianTest {
	@Test
	fun median_onArrayWith1Element() {
		val array = arrayOf(1)
		assertEquals(1, median(array, 0, 0))
	}

	@Test
	fun median_onArrayWith2Elements() {
		val array = arrayOf(1, 3)
		assertEquals(2, median(array, 0, 1))
	}

	@Test
	fun median_onArrayWithOdNumberOfElements() {
		val array = arrayOf(20, 2, 10, 9, 7, 6, 5, 4, 30, 50, 60, 1, 0)
		assertEquals(7, median(array, 0, array.size - 1))
	}

	@Test
	fun median_onArrayWithEvenNumberOfElements() {
		val array = arrayOf(20, 2, 10, 9, 7, 6, 5, 4, 30, 50, 60, 1, 0, 70)
		assertEquals(8, median(array, 0, array.size - 1))
	}
}