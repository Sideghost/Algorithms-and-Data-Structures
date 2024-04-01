package dataStructures.hashMap


/**
 * Function that changes all the entries based on an [transform] function.
 * @receiver Hashmap<K,V> to [transform].
 * @param transform transforms function to apply to all entry's.
 * @return Returns a list resulting form the [transform] function.
 */
fun <K, V, R> HashMap<K, V>.map(transform: (MutableMap.MutableEntry<K, V>) -> R): List<R> {
	val idx = iterator()
	val list = ArrayList<R>(size)
	while (idx.hasNext())
		list.add(transform(iterator().next()))
	return list
}

/**
 * Function that filters the Hashmap based on [predicate].
 * @receiver Hashmap to filter.
 * @param predicate Function to validate every pair key value in the hashmap.
 * @return a list resulted forms the filter.
 */
fun <K, V> HashMap<K, V>.filter(predicate: (MutableMap.MutableEntry<K, V>) -> Boolean): List<MutableMap.MutableEntry<K, V>> {
	val idx = iterator()
	val list = ArrayList<MutableMap.MutableEntry<K, V>>(0)
	while (idx.hasNext()) {
		val current = idx.next()
		if (predicate(current))
			list.add(current)
	}
	return list
}
