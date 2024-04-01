package exercices.binarySearchTrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsCompleteTest {

	private val cmpNaturalOrder = { i1: Int, i2: Int -> i1.compareTo(i2) }

	@Test
	fun `isComplete on a empty tree`() {
		val tree = emptyBST()
		assertEquals(-1, height(tree))
		assertTrue(isComplete(tree))
	}

	@Test
	fun `isComplete in a single Node BST`() {
		var tree = singleNodeBST(10)
		assertTrue(isComplete(tree))
		tree = add(tree, 0, cmpNaturalOrder)
		assertEquals(1, height(tree))
		assertFalse(isComplete(tree))
		tree = add(tree, 20, cmpNaturalOrder)
		assertEquals(1, height(tree))
		assertTrue(isComplete(tree))
	}

	@Test
	fun `isComplete on a complete BST`() {
		val tree = populatedBST(intArrayOf(10, 5, 12, 4, 6, 16, 11))
		assertEquals(2, height(tree))
		assertTrue(isComplete(tree))
	}

	@Test
	fun `isComplete on a non-complete BST`() {
		val tree = populatedBST(intArrayOf(30, 10, 5, 12, 4, 3, 0, 11, 40, 50))
		assertEquals(5, height(tree))
		assertFalse(isComplete(tree))
	}
}
