package exercices.binarySearchTrees

fun <E> isComplete(root: Node<E>?): Boolean {
	return isCompleteAux(root) != -1
}

fun <E> isCompleteAux(root: Node<E>?): Int {
	if (root == null) return 0
	val l = isCompleteAux(root.left)
	val r = isCompleteAux(root.right)
	if (l == -1 || r == -1) return -1
	return if (r - l == 0) l + 1 else -1
}