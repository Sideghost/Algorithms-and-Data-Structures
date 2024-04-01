package dataStructures.stack

/**
 * Implementation of the stack data structure
 *
 * @param E the type of the elements in the stack
 */
class StackStructure<E> : Stack<E> {

	/**
	 * Node class for the stack
	 *
	 * @param value the value of the node
	 * @param next the next node
	 */
	class Node<E>(val value: E?, val next: Node<E>?)

	private val sentinel: Node<E>? = null

	var currentNode = sentinel

	/**
	 * Pushes a new element to the stack
	 *
	 * @param new the new element to be pushed
	 */
	override fun push(new: E) {
		val nodeToAdd = Node(new, currentNode)
		currentNode = nodeToAdd
	}

	/**
	 * Pops the top element from the stack
	 *
	 * @return the top element from the stack
	 */
	override fun pop(): E? {
		if (isEmpty()) return null
		val nodeToRemove = peek()
		currentNode = currentNode?.next
		return nodeToRemove
	}

	/**
	 * Peeks the top element from the stack
	 *
	 * @return the top element from the stack
	 */
	override fun peek(): E? {
		return currentNode?.value
	}

	/**
	 * Checks if the stack is empty
	 *
	 * @return true if the stack is empty, false otherwise
	 */
	override fun isEmpty(): Boolean {
		return currentNode == null
	}

}