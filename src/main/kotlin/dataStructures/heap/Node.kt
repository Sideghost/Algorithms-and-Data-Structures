package dataStructures.heap

/**
 * Node class for the Heap data structure
 *
 * @property previous reference of the previous node for the current Node
 * @property next reference of the next node for the current Node
 * @property value value of current Node
 * @constructor sets a value for [Node.value]
 */
class Node<E> {
	var previous: Node<E>? = null
	var next: Node<E>? = null
	var value: E? = null

	constructor()
	constructor(e: E) {
		value = e
	}
}
