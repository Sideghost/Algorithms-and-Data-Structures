package dataStructures.hashSet

/**
 * Interface for a HashSet
 */
interface HashSet<E> {

	/**
	 * Adds a new element to the HashSet
	 *
	 * @param new element to add
	 * @return true if the element was added, false otherwise
	 */
	fun add(new: E): Boolean

	/**
	 * Removes an element from the HashSet
	 *
	 * @param toRemove element to remove
	 */
	fun remove(toRemove: E)

	/**
	 * Checks if an element is in the HashSet
	 *
	 * @param toCheck element to check
	 * @return true if the element is in the HashSet, false otherwise
	 */
	fun contains(toCheck: E): Boolean

	/**
	 * Checks if the HashSet is empty
	 *
	 * @return true if the HashSet is empty, false otherwise
	 */
	fun isEmpty(): Boolean

	/**
	 * Searches for an element in the HashSet and returns it
	 *
	 * @param elem element to search
	 * @return the element if it is in the HashSet, null otherwise
	 */
	fun search(elem: E): E?
}

