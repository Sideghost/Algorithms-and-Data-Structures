package dataStructures.stack

class StackStructure<E> : Stack<E> {
	class Node<E>(val value: E?, val next: Node<E>?)

	private val sentinel: Node<E>? = null

	var currentNode = sentinel

	override fun peek(): E? {
		return currentNode?.value
	}

	override fun isEmpty(): Boolean {
		return currentNode == null
	}

	override fun pop(): E? {
		if (isEmpty()) return null
		val nodeToRemove = peek()
		currentNode = currentNode?.next
		return nodeToRemove
	}

	override fun push(new: E) {
		val nodeToAdd = Node(new, currentNode)
		currentNode = nodeToAdd
	}
}