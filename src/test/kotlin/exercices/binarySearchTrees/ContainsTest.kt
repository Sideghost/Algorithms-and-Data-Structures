package exercices.binarySearchTrees

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsTest {

	private val cmp = { i1: Int, i2: Int -> i1 - i2 }

	@Test
	fun contains_empty_trees() {
		val tree = emptyBST()
		assertFalse(contains(tree, 0, 3, cmp))
	}


	@Test
	fun contains_singleNodeBST() {
		val tree = singleNodeBST(1)
		assertTrue(contains(tree, 1, 1, cmp))
		assertTrue(contains(tree, 0, 3, cmp))
		assertFalse(contains(tree, 2, 4, cmp))

	}

	@Test
	fun contains_fullBST() {
		val tree = populatedBST(intArrayOf(10, 5, 12, 4, 2, 16, 11))
		assertFalse(contains(tree, -3, 1, cmp))
		assertTrue(contains(tree, 2, 16, cmp))
		assertTrue(contains(tree, 12, 16, cmp))
		assertTrue(contains(tree, 11, 12, cmp))
		assertTrue(contains(tree, 4, 5, cmp))
		assertTrue(contains(tree, 5, 5, cmp))
		assertFalse(contains(tree, 17, 20, cmp))

	}

	@Test
	fun contains_bigBST() {
		val tree = populatedBST(intArrayOf(30, 10, 5, 12, 4, 3, 0, 11, 40, 50))
		assertFalse(contains(tree, -30, -1, cmp))
		assertTrue(contains(tree, 2, 30, cmp))
		assertTrue(contains(tree, 30, 50, cmp))
		assertTrue(contains(tree, 3, 4, cmp))
		assertTrue(contains(tree, 4, 11, cmp))
		assertTrue(contains(tree, 40, 50, cmp))
		assertFalse(contains(tree, 51, 60, cmp))
	}
}
