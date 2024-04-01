package exercices.binarySearchTrees

/**
 * Checks if a binary search tree contains elements between [min] and [max]
 * Complexity O(log n)
 *
 * @param root Node<E>?
 * @param min E
 * @param max E
 * @param cmp Function2<E, E, Int>
 * @return Returns true if the binary search tree contains
 * elements between [min] and [max]
 */
fun <E> contains(root: Node<E>?, min: E, max: E, cmp: (e1: E, e2: E) -> Int): Boolean {
	if (root?.item == null) return false
	if (cmp(min, root.item) <= 0 && cmp(max, root.item) >= 0) return true
	if (cmp(root.item, min) < 0) return contains(root.right, min, max, cmp)
	if (cmp(max, root.item) < 0) return contains(root.left, min, max, cmp)
	return false
}