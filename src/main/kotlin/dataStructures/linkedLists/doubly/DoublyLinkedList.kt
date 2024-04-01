package dataStructures.linkedLists.doubly

/**
 * Interface for the Doubly Linked List data structure
 *
 * @param E type of the elements in the Doubly Linked List
 */
interface DoublyLinkedList<E> {

	/**
	 * Interface for the Doubly Linked Node
	 *
	 * @param E type of the elements in the Doubly Linked List
	 */
	interface DoublyLinkedNode<E> {
		val item: E?
	}

	val size: Int

	/**
	 * Adds an element to the Doubly Linked List
	 *
	 * @param elem element to add to the Doubly Linked List
	 * @return the element added to the Doubly Linked List
	 * or null if the element is already in the Doubly Linked List
	 */
	fun add(elem: E): E?

	/**
	 * Removes an element from the Doubly Linked List
	 *
	 * @param elem element to remove from the Doubly Linked List
	 * @return the element removed from the Doubly Linked List
	 * or null if the element is not in the Doubly Linked List
	 */
	fun remove(elem: E): E?

	/**
	 * Checks if the Doubly Linked List is empty
	 *
	 * @return true if the Doubly Linked List is empty, false otherwise
	 */
	fun isEmpty(): Boolean

	/**
	 * Checks if the Doubly Linked List contains an element
	 *
	 * @param elem element to check if it is in the Doubly Linked List
	 * @return true if the Doubly Linked List contains the element, false otherwise
	 */
	fun contains(elem: E): Boolean
}
