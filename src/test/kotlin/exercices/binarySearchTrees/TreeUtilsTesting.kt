package exercices.binarySearchTrees

import kotlin.math.max

// Natural number comparator
val cmp = { i1: Int, i2: Int -> i1 - i2 }

/**
 * Creates an empty BST
 *
 * @return the root of the tree
 */
fun emptyBST(): Node<Int>? = null

/**
 * Creates a single node BST
 *
 * @param i the value of the node
 * @return the root of the tree
 */
fun singleNodeBST(i: Int): Node<Int> = add(null, i, cmp)

/**
 * Creates a populated BST from an array
 *
 * @param array the array to populate the BST
 * @return the root of the tree
 */
fun populatedBST(array: IntArray): Node<Int>? {
	var tree: Node<Int>? = null
	for (i in array) tree = add(tree, i, cmp)
	return tree
}

/**Generic BST Functions**/
fun <E> height(root: Node<E>?): Int {
	return if (root == null) -1
	else 1 + max(height(root.left), height(root.right))
}

/**
 * Searches for a key in the tree
 *
 * @param root the root of the tree
 * @param key the key to search
 * @param cmp the comparator
 * @return the node containing the key or null if the key is not in the tree
 */
fun <E> search(root: Node<E>?, key: E, cmp: Comparator<E>): Node<E>? {
	return if (root == null || cmp.compare(key, root.item) == 0) root
	else if (cmp.compare(key, root.item) < 0) search(root.left, key, cmp)
	else search(root.right, key, cmp)
}

/**
 * Adds a new node to the tree
 *
 * @param root the root of the tree
 * @param e the element to add
 * @return the root of the tree
 */
fun <E> add(root: Node<E>?, e: E, cmp: Comparator<E>): Node<E> {
	var r = root
	if (r == null) r = Node(e, null, null)
	else if (cmp.compare(e, r.item) < 0) r.left = add(r.left, e, cmp)
	else r.right = add(r.right, e, cmp)
	return r
}

/**
 * Prints the tree in prefix order
 *
 * @param root the root of the tree
 */
fun <E> preorder(root: Node<E>?) {
	if (root != null) {
		print("$root.item ")
		preorder(root.left)
		preorder(root.right)
	}
}

/**
 * Prints the tree in infix order
 *
 * @param root the root of the tree
 */
fun <E> inorder(root: Node<E>?) {
	if (root != null) {
		inorder(root.left)
		print("$root.item")
		inorder(root.right)
	}
}

/**
 * Prints the tree in postfix order
 *
 * @param root the root of the tree
 */
fun <E> postorder(root: Node<E>?) {
	if (root != null) {
		postorder(root.left)
		postorder(root.right)
		print("$root.item")
	}
}
