package dataStructures.linkedLists.doubly

/**
 * Implementation of the Doubly Linked List data structure
 *
 * @param E type of the elements in the Doubly Linked List
 */
class DoublyLinkedListStructure<E> : DoublyLinkedList<E> {

	/**
	 * Node class for the Doubly Linked List data structure
	 *
	 * @property item value of the current Node
	 * @property next reference of the next node for the current Node
	 * @property previous reference of the previous node for the current Node
	 */
	private class Node<E>(override val item: E?) : DoublyLinkedList.DoublyLinkedNode<E> {

		var next: Node<E>? = null

		var previous: Node<E>? = null

	}

	private var head: Node<E>? = Node(null)

	override var size: Int = 0

	/**
	 * Adds an element to the Doubly Linked List
	 *
	 * @param elem element to add to the Doubly Linked List
	 * @return the element added to the Doubly Linked List
	 * or null if the element is already in the Doubly Linked List
	 */
	override fun add(elem: E): E? {
		val nodeToAd = search(elem)
		if (nodeToAd == null) {
			val node = Node(elem)
			head!!.next = node
			head!!.previous!!.next = node
			node.previous = head!!.previous
			node.next = head
			size++
			return node.item
		}
		return null
	}

	/**
	 * Removes an element from the Doubly Linked List
	 *
	 * @param elem element to remove from the Doubly Linked List
	 * @return the element removed from the Doubly Linked List
	 * or null if the element is not in the Doubly Linked List
	 */
	override fun remove(elem: E): E? {
		val nodeToRemove = search(elem) ?: return null
		nodeToRemove.previous!!.next = nodeToRemove.next
		nodeToRemove.next!!.previous = nodeToRemove.previous
		return nodeToRemove.item
	}

	/**
	 * Checks if the Doubly Linked List is empty
	 *
	 * @return true if the Doubly Linked List is empty, false otherwise
	 */
	override fun isEmpty(): Boolean {
		return head == head!!.next
	}

	/**
	 * Checks if the Doubly Linked List contains an element
	 *
	 * @param elem element to check if it is in the Doubly Linked List
	 * @return true if the Doubly Linked List contains the element, false otherwise
	 */
	override fun contains(elem: E): Boolean {
		return search(elem) != null
	}

	/**
	 * Searches for an element in the Doubly Linked List
	 *
	 * @param elem element to search for in the Doubly Linked List
	 * @return the Node with the element if it is in the Doubly
	 * Linked List, null otherwise
	 */
	private fun search(elem: E): Node<E>? {
		var node = head
		while (node!!.next != head) {
			if (node.item == elem)
				return node
			node = node.next
		}
		return null
	}
}