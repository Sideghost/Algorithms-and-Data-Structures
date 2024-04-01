package exercices.arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubKSequencesTest {
	@Test
	fun countSubKSequences_EmptyArray() {
		assertEquals(0, countSubKSequences(IntArray(0), 1))
		assertEquals(0, countSubKSequences(IntArray(0), 3))
	}

	@Test
	fun countSubKSequences_SingletonArray() {
		val a = intArrayOf(1)
		assertEquals(1, countSubKSequences(a, 1))
		assertEquals(0, countSubKSequences(a, 3))
	}

	@Test
	fun countSubKSequences_Example() {
		val a = intArrayOf(1, 2, 3, 4, 1)
		assertEquals(2, countSubKSequences(a, 3))
	}

	@Test
	fun countSubKSequences_AllEquals() {
		val a = intArrayOf(3, 3, 3, 3, 3, 3, 3)
		assertEquals(7, countSubKSequences(a, 1))
		assertEquals(5, countSubKSequences(a, 3))
		assertEquals(0, countSubKSequences(a, 9))
	}
}
