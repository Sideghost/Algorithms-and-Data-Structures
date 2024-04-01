package exercices.binarySearchTrees

/**
 * Checks if a binary search tree is complete
 * Complexity O(n)
 *
 * @param root Node<E>?
 * @return Returns true if the binary search tree is complete
 */
fun <E> isComplete(root: Node<E>?): Boolean {
	return isCompleteAux(root) != -1
}

/**
 * Auxiliary function to check if a binary search tree is complete
 * Complexity O(n)
 *
 * @param root Node<E>?
 * @return Returns the height of the binary search tree or -1 if it is not complete
 */
fun <E> isCompleteAux(root: Node<E>?): Int {
	if (root == null) return 0
	val l = isCompleteAux(root.left)
	val r = isCompleteAux(root.right)
	if (l == -1 || r == -1) return -1
	return if (r - l == 0) l + 1 else -1
}