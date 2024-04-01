package exercices.binarySearchTrees

import kotlin.math.abs
import kotlin.math.max

/**
 * Checks if a binary search tree is balanced
 * Complexity O(n)
 *
 * @param root Node<E>?
 * @return Returns true if the binary search tree is balanced
 */
fun <E> isBalanced(root: Node<E>?): Boolean {
	return isBalancedAux(root) != -1
}

/**
 * Auxiliary function to check if a binary search tree is balanced
 * Complexity O(n)
 *
 * @param root Node<E>?
 * @return Returns the height of the binary search tree or -1 if it is not balanced
 */
fun <E> isBalancedAux(root: Node<E>?): Int {
	if (root == null) return 0
	val l = isBalancedAux(root.left)
	val r = isBalancedAux(root.right)
	if (l == -1 || r == -1) return -1
	return if (abs(l - r) <= 1) max(l, r) + 1 else -1
}