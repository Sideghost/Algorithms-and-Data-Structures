package binarySearchTrees

import exercices.binarySearchTrees.Node
import exercices.binarySearchTrees.createBSTFromRange
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateBSTFromRangeTest {

	val cmp = { i1: Int, i2: Int -> i1 - i2 }

	@Test
	fun creatBSTFromRange_empty_trees() {
		var tree = emptyBST()
		val resultTree = createBSTFromRange(0, -1)
		assertEqual(tree, resultTree)
		tree = singleNodeBST(0)

	}


	fun <E> assertEqual(root1: Node<E>?, root2: Node<E>?) {
		if (root1 != null && root2 != null) {
			assertEquals(root1.item, root2.item)
			assertEqual(root1.left, root2.left)
			assertEqual(root1.right, root2.right)
		}
		assertEquals(root1, root2)
	}
}
