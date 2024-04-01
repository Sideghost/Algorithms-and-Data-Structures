package exercices.arrays

import kotlin.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionPointTest {
	@Test
	fun partitionPoint_onEmptyArray() {
		assertEquals(0, partitionPoint(IntArray(0), 1))
	}

	@Test
	fun partitionPoint_allGreater() {
		assertEquals(0, partitionPoint(intArrayOf(3), 1))
		assertEquals(0, partitionPoint(intArrayOf(5, 2), 1))
		assertEquals(0, partitionPoint(intArrayOf(5, 2), 1))
		assertEquals(0, partitionPoint(intArrayOf(5, 2, 3), 1))
		assertEquals(0, partitionPoint(getRandomArray(N, 2, N), 1))
		assertEquals(0, partitionPoint(getRandomArray(N, 2, N), 1))
		assertEquals(0, partitionPoint(getRandomArray(N + 1, 2, N + 1), 1))
	}

	@Test
	fun partitionPoint_allLess() {
		assertEquals(1, partitionPoint(intArrayOf(3), Int.MAX_VALUE))
		assertEquals(2, partitionPoint(intArrayOf(5, 2), Int.MAX_VALUE))
		assertEquals(2, partitionPoint(intArrayOf(5, 2), Int.MAX_VALUE))
		assertEquals(3, partitionPoint(intArrayOf(5, 2, 3), Int.MAX_VALUE))
		assertEquals(N, partitionPoint(getRandomArray(N, 0, N), Int.MAX_VALUE))
	}

	@Test
	fun partitionPoint_allEquals() {
		partitionPoint_allZeros(1)
		partitionPoint_allZeros(2)
		partitionPoint_allZeros(3)
		partitionPoint_allZeros(N)
	}

	@Test
	fun test_partition_point_with_value() {
		test_partition_point(N * 2, true)
	}

	@Test
	fun test_partition_point_without_Value() {
		test_partition_point(N, false)
	}

	/**
	 * Test partition point with random values
	 *
	 * @param n the size of the array
	 */
	private fun partitionPoint_allZeros(n: Int) {
		val v = IntArray(n)
		assertEquals(0, partitionPoint(v, -1))
		assertEquals(0, partitionPoint(v, 0))
		assertEquals(n, partitionPoint(v, 1))
	}

	/**
	 * Test partition point with random values
	 *
	 * @param n the size of the array
	 * @param with if the partition point is with the base value
	 */
	private fun test_partition_point(n: Int, with: Boolean) {
		val baseValue = n / 2
		for (partitionPoint in 0 until n) assertEquals(
			partitionPoint,
			partitionPoint(getSegmentedArray(n, partitionPoint, baseValue, with), baseValue)
		)
	}

	/**
	 * Fill an array with random values
	 *
	 * @param v the array to fill
	 * @param l the left index
	 * @param r the right index
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the filled array
	 */
	private fun fillRandom(v: IntArray, l: Int, r: Int, min: Int, max: Int): IntArray {
		for (i in l..r) v[i] = rd.nextInt(max - min + 1) + min
		return v
	}

	/**
	 * Creates a random array
	 *
	 * @param n the size of the array
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the random array
	 */
	private fun getRandomArray(n: Int, min: Int, max: Int): IntArray {
		return fillRandom(IntArray(n), 0, n - 1, min, max)
	}

	/**
	 * Creates a segmented array
	 *
	 * @param n the size of the array
	 * @param partitionPoint the partition point
	 * @param baseValue the base value
	 * @param withValue if the partition point is with the base value
	 * @return the segmented array
	 */
	private fun getSegmentedArray(n: Int, partitionPoint: Int, baseValue: Int, withValue: Boolean): IntArray {
		var bValue = baseValue
		val v = IntArray(n)
		fillRandom(v, 0, partitionPoint - 1, 0, bValue - 1)
		if (!withValue) ++bValue
		v[partitionPoint] = bValue
		fillRandom(v, partitionPoint + 1, n - 1, bValue, n)
		return v
	}

	companion object {
		const val N = 100
		var rd: Random = Random(N)
	}
}