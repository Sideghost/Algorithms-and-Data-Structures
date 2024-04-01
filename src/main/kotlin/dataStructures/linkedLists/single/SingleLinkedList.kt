package dataStructures.linkedLists.single

/**
 * Interface for the Single Linked List data structure
 *
 * @param E type of the elements in the Single-Linked List
 */
interface SingleLinkedList<E> {

	/**
	 * Interface for the Single Linked Node
	 *
	 * @param E type of the elements in the Single-Linked List
	 */
	interface SingleLinkedNode<E> {
		val item: E?
	}

	val size: Int

	/**
	 * Adds an element to the Single Linked List
	 *
	 * @param elem element to add to the Single Linked List
	 * @return the element added to the Single Linked List
	 * or null if the element is already in the Single-Linked List
	 */
	fun add(elem: E): E?

	/**
	 * Removes an element from the Single Linked List
	 *
	 * @param elem element to remove from the Single-Linked List
	 * @return the element removed from the Single Linked List
	 * or null if the element is not in the Single-Linked List
	 */
	fun remove(elem: E): E?

	/**
	 * Checks if the Single-Linked List is empty
	 *
	 * @return true if the Single-Linked List is empty, false otherwise
	 */
	fun isEmpty(): Boolean

	/**
	 * Checks if the Single-Linked List contains an element
	 *
	 * @param elem element to check if it is in the Single-Linked List
	 * @return true if the Single-Linked List contains the element,
	 * false otherwise
	 */
	fun contains(elem: E): Boolean
}
