package exercices.binarySearchTrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateBSTFromRangeTest {

	@Test
	fun creatBSTFromRange_empty_trees() {
		val tree = emptyBST()
		val resultTree = createBSTFromRange(0, -1)
		assertEqual(tree, resultTree)
	}

	/**
	 * Assert Equals for a BST
	 *
	 * @param root1 expected
	 * @param root2 actual
	 */
	private fun <E> assertEqual(root1: Node<E>?, root2: Node<E>?) {
		if (root1 != null && root2 != null) {
			assertEquals(root1.item, root2.item)
			assertEqual(root1.left, root2.left)
			assertEqual(root1.right, root2.right)
		}
		assertEquals(root1, root2)
	}
}
