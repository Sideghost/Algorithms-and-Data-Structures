package exercices.binarySearchTrees

/**
 * Searches for an element in a binary search tree
 * Complexity O(log n)
 *
 * @param root Node<E>? the root of the binary search tree
 * @param element E the element to search for
 * @param comparator Function2<E, E, Int> the comparator function
 * @return Returns true if the element is found in the binary search tree
 */
fun <E> searchRecursive1(root: Node<E>?, element: E, comparator: (E, E) -> Int): Boolean {
	if (root == null) return false
	return searchRecursive1(root.left, element, comparator) &&
			searchRecursive1(root.right, element, comparator)
}

/**
 * Searches for an element in a binary search tree
 * Complexity O(log n)
 *
 * @param root Node<E>? the root of the binary search tree
 * @param element E the element to search for
 * @param comparator Function2<E, E, Int> the comparator function
 * @return Returns true if the element is found in the binary search tree
 */
fun <E> searchRecursive(root: Node<E>?, element: E, comparator: (E, E) -> Int): Boolean {
	if (root == null) return false
	return if (comparator(root.item, element) > 0)
		searchRecursive(root.left, element, comparator)
	else searchRecursive(root.right, element, comparator)
}

/**
 * Searches for an element in a binary search tree
 * Complexity O(log n)
 *
 * @param root Node<E>? the root of the binary search tree
 * @param element E the element to search for
 * @param comparator Function2<E, E, Int> the comparator function
 * @return Returns true if the element is found in the binary search tree
 */
fun <E> search(root: Node<E>?, element: E, comparator: (E, E) -> Int): Boolean {
	var current = root
	while (current != null) {
		current =
			if (comparator(current.item, element) == 0)
				return true
			else
				if (comparator(current.item, element) > 0)
					current.left
				else current.right
	}
	return false
}