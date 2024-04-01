package dataStructures.hashMap

/**
 * Interface that represents a MutableMap
 */
interface MutableMap<K, V> {

	/**
	 * Interface that represents a MutableEntry
	 */
	interface MutableEntry<K, V> {
		val key: K
		val value: V

		/**
		 * Sets a value to the [MutableEntry]
		 *
		 * @param newValue value to override
		 * @return the [newValue] set
		 */
		fun setValue(newValue: V): V
	}

	val size: Int

	/**
	 * Adds an Entry to the Hashmap ([key] and [value])
	 * associated with the given [key]
	 *
	 * @param key Key to serve as an address
	 * @param value Value to put in the address of [key]
	 * @return the value or null if
	 */
	fun put(key: K, value: V): V?

	/**
	 * Removes an Entry of the Hashmap given by a [key]
	 *
	 * @param key to search in the Hashmap to remove an entry
	 * @return Returns the value associated with [key] or null
	 * if [key] is not present in [HashMap]
	 */
	fun remove(key: K): V?

	/**
	 * Function that returns the value of a given
	 * [key] or null if it doesn't exist in the [HashMap]
	 *
	 * @param key Key to find in the Hashmap
	 * @return Returns the first value associated with that
	 * given [key] or null if it isn't present in the Hashmap
	 */
	operator fun get(key: K): V?

	/**
	 * Iterator of the [HashMap]
	 */
	operator fun iterator(): Iterator<MutableEntry<K, V>>
}
