package exercices.binarySearchTrees

fun <E> insert(root: Node<E>?, element: E, comparator: (E, E) -> Int): Node<E> {
	val new = Node<E>(element, null, null)
	var current = root
	if (root == null) return new
	var previous: Node<E>? = null
	while (current != null) {
		previous = current
		if (comparator(current.item, element) < 0) {
			current = current.right
		} else current = current.left
	}
	if (previous != null) {
		if (comparator(previous.item, element) < 0) previous.right = new
		else previous.left = new
	}
	return root
}