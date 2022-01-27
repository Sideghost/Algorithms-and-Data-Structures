package data_Structures.hash_Map


/**
 * Function that changes all the entries based on an [transform] function.
 * @receiver Hashmap<K,V> to [transform].
 * @param transform transforms function to apply to all entry's.
 * @return Returns a list resulting form the [transform] function.
 */
fun <K, V, R> HashMap<K, V>.map(transform:(MutableMap.MutableEntry <K,V>)->R): List<R> {
    //iterator of the hashmap.
    val idx = iterator()
    //list to return with the same maxsize of the Hashmap.
    val list = ArrayList<R>(size)
    //loop to go through all entry's in the Hashmap.
    while (idx.hasNext())
    //adds the current element after its transformation.
        list.add(transform(iterator().next()))
    //returns the list
    return list
}

/**
 * Function that filters the Hashmap based on [predicate].
 * @receiver Hashmap to filter.
 * @param predicate Function to validate every pair key value in the hashmap.
 * @return a list resulted form the filter.
 */
fun <K, V> HashMap<K, V>.filter(predicate:(MutableMap.MutableEntry<K,V>)->Boolean): List<MutableMap.MutableEntry<K,V>> {
    //iterator of the hashmap.
    val idx = iterator()
    //creates an array list with maxsize zero its possible that any entry is validated by the predicate.
    val list = ArrayList<MutableMap.MutableEntry<K,V>>(0)
    //loop to go through all entry's in the Hashmap.
    while (idx.hasNext()) {
        //current entry in the Hashmap.
        val current = idx.next()
        //checks if the entry is validated by the predicate function.
        if (predicate(current))
        //adds the element if it does pass
            list.add(current)
    }
    //returns the list.
    return list
}
