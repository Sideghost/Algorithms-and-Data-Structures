package dataStructures.hashSet

/**
 * Implementation of a HashSet
 */
class HashSetStructure<E>(var size: Int) : HashSet<E> {

	private inner class Node<E>(val value: E?, var next: Node<E>? = null, var previous: Node<E>? = null)

	private var collection: Array<Node<E>?>? = null

	private var dimension = 0

	constructor() : this(0) {
		collection = Array(10) { null }
		dimension = 10
	}

	/**
	 * Adds a new element to the HashSet
	 *
	 * @param new element to add
	 * @return true if the element was added, false otherwise
	 */
	override fun add(new: E): Boolean {
		val index = index(new)
		val node = search(new, index)
		if (node != null) return false

		val nodeToAdd = Node(new, collection?.get(index))
		if ((size / dimension).toDouble() > 0.75) resize()
		if (collection?.get(index) != null) {
			collection?.get(index)?.previous = nodeToAdd
		}
		collection?.set(index, nodeToAdd)
		size++
		return true
	}

	/**
	 * Removes an element from the HashSet
	 *
	 * @param toRemove element to remove
	 */
	override fun remove(toRemove: E) {
		val index = index(toRemove)
		val node = search(toRemove, index) ?: return
		val previous = node.previous
		val next = node.next
		if (previous == null) {
			collection?.set(index, next)
		} else {
			previous.next = next
		}
		if (next != null) {
			next.previous = previous
		}
	}

	/**
	 * Checks if an element is in the HashSet
	 *
	 * @param toCheck element to check
	 * @return true if the element is in the HashSet, false otherwise
	 */
	override fun contains(toCheck: E): Boolean {
		return search(toCheck, index(toCheck)) != null
	}

	/**
	 * Checks if the HashSet is empty
	 *
	 * @return true if the HashSet is empty, false otherwise
	 */
	override fun isEmpty(): Boolean {
		return collection?.all { it == null } ?: true
	}

	/**
	 * Searches for an element in the HashSet and returns it
	 *
	 * @param elem element to search
	 * @return the element if it is in the HashSet, null otherwise
	 */
	override fun search(elem: E): E? {
		val index = index(elem)
		val node = search(elem, index)
		return node?.value
	}

	/**
	 * Find the index of the element
	 *
	 * @param value element to find the index
	 * @return index of the element
	 */
	private fun index(value: E): Int {
		val pos = value.hashCode() % dimension
		return if (pos < 0) pos + dimension else pos
	}

	/**
	 * Search for an element in the HashSet
	 *
	 * @param value element to search
	 * @param index index of the element
	 * @return the element if it is in the HashSet, null otherwise
	 */
	private fun search(value: E, index: Int): Node<E>? {
		var current = collection?.get(index)
		while (current != null) {
			if (current.value == value) return current
			current = current.next
		}
		return null
	}

	/**
	 * Resize the HashSet
	 */
	private fun resize() {
		dimension = (dimension * 1.75).toInt()
		val newCollection = Array<Node<E>?>(dimension) { null }
		for (i in collection!!.indices) {
			var current = collection?.get(i)
			while (current != null) {
				val newIndex = index(current.value!!)
				val node = Node(current.value)
				if (newCollection[newIndex] == null) {
					newCollection[newIndex] = node
				} else {
					var currentNew = newCollection[newIndex]
					while (currentNew?.next != null) {
						currentNew = currentNew.next
					}
					currentNew?.next = node
				}
				current = current.next
			}
		}
	}
}