package dataStructures.linkedLists.single

/**
 * Implementation of the Single Linked List data structure
 *
 * @param E type of the elements in the Single-Linked List
 */
class SingleLinkedListStructure<E> : SingleLinkedList<E> {

	/**
	 * Node class for the Single Linked List data structure
	 *
	 * @property item value of the current Node
	 * @property next reference of the next node for the current Node
	 */
	private class Node<E>(override var item: E?) : SingleLinkedList.SingleLinkedNode<E> {

		var next: Node<E>? = null
	}

	private var head: Node<E>? = Node(null)

	override var size: Int = 0

	/**
	 * Adds an element to the Single Linked List
	 *
	 * @param elem element to add to the Single Linked List
	 * @return the element added to the Single Linked List
	 * or null if the element is already in the Single-Linked List
	 */
	override fun add(elem: E): E? {
		val nodeToAd = Node(elem)
		var nodeIterated = head
		var previousNode: Node<E>? = null

		while (nodeIterated != null) {
			previousNode = nodeIterated
			nodeIterated = nodeIterated.next
		}

		if (previousNode == null) head = nodeToAd
		else previousNode.next = nodeToAd
		size++
		return nodeToAd.item
	}

	/**
	 * Removes an element from the Single Linked List
	 *
	 * @param elem element to remove from the Single-Linked List
	 * @return the element removed from the Single Linked List
	 * or null if the element is not in the Single-Linked List
	 */
	override fun remove(elem: E): E? {
		val nodeToRemove = search(elem) ?: return null
		val previous = searchForPrevious(elem) ?: return null
		previous.next = nodeToRemove.next
		size--
		return elem
	}

	/**
	 * Checks if the Single-Linked List is empty
	 *
	 * @return true if the Single-Linked List is empty, false otherwise
	 */
	override fun isEmpty(): Boolean {
		return head!!.next == null
	}

	/**
	 * Checks if the Single-Linked List contains an element
	 *
	 * @param elem element to check if it is in the Single-Linked List
	 * @return true if the Single-Linked List contains the element,
	 * false otherwise
	 */
	override fun contains(elem: E): Boolean {
		return search(elem) != null
	}

	/**
	 * Searches for an element in the Single-Linked List
	 *
	 * @param elem element to search for in the Single-Linked List
	 * @return the Node with the element if it is in the Single-Linked List
 	 */
	private fun search(elem: E): Node<E>? {
		var node = head
		while (node != null) {
			if (node.item == elem)
				return node

			node = node.next

		}
		return null
	}

	/**
	 * Searches for the previous element of the element in the
	 * Single-Linked List
	 *
	 * @param elem element to search for in the Single-Linked List
	 * @return the Node with the previous element if it is in
	 * the Single-Linked List
 	 */
	private fun searchForPrevious(elem: E): Node<E>? {
		var node = head
		while (node != null) {
			if (node.next!!.item == elem)
				return node

			node = node.next
		}
		return null
	}
}
