package dataStructures.linkedLists.doubly

interface DoublyLinkedList<E> {
	interface DoublyLinkedNode<E> {
		val item: E?
		//var previous: DoublyLinkedNode<E>?
		//var next: DoublyLinkedNode<E>?
	}

	//val sentinel: DoublyLinkedNode<E>
	val size: Int
	fun add(elem: E): E?
	fun remove(elem: E): E?
	fun isEmpty(): Boolean
	fun contains(elem: E): Boolean
}