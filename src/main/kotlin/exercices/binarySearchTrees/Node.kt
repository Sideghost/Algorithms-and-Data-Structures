package exercices.binarySearchTrees

/**
 * Node class for a binary search tree
 *
 * @property item element
 * @property left left node
 * @property right right node
 */
data class Node<E>(var item: E, var left: Node<E>?, var right: Node<E>?)