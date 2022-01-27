package data_Structures.hash_Map

/**
 * Class that represents an [HashMap].
 */
class HashMap<K, V> : MutableMap<K, V> {

    /**
     * Class that represents a Node of the [HashMap]
     */
    private class HashNode<K, V> : MutableMap.MutableEntry<K, V> {
        override var key: K
        override var value: V
        var previous: HashNode<K, V>? = null
        var next: HashNode<K, V>? = null

        /**
         *
         */
        constructor(Key: K, Value: V) {
            key = Key
            value = Value
        }

        /**
         * Function that overrides a value in the [HashMap].
         * @param newValue value to override.
         * @return the [newValue] set.
         */
        override fun setValue(newValue: V): V {
            this.value = newValue
            return newValue
        }
    }

    //Dimension ot the linked list set in an index of the Hashmap.
    private var dim = 10
    private var array = Array<HashNode<K, V>?>(dim) { null }

    //private var arraySize = 0
    override var size: Int = 0

    /**
     * Function that searches through the [HashMap] ...
     * @param value
     * @param idx
     * @return
     */
    private fun search(value: V, idx: Int): HashNode<K, V>? {
        var current: HashNode<K, V>? = array[idx]
        while (current != null) {
            if (current.value!! == value) return current
            current = current.next
        }
        return current
    }

    /**
     * Function that adds an Entry to the Hashmap ([key] and [value]) associated with the given [key].
     * @param key Key to serve as an address.
     * @param value Value to put in the address of [key].
     * @return the value or null if
     */
    override fun put(key: K, value: V): V? {
        var address = index(key)
        val node = search(value, address)

        if (node != null) {
            val oldValue = node.value
            array[address]?.value = value
            return oldValue
        }

        // checks if the Hashmap is full by a factor of 75%.
        if (size / dim.toDouble() > 0.75)
            resize()

        address = index(key)
        val new = HashNode(key, value)
        new.next = array[address]
        if (array[address] == null) size++ //stora disse que era so maxsize++ mas nao sei porque nao passa nos testes
        if (array[address] != null)
            array[address]?.previous = new
        array[address] = new
        return null
    }

    /**
     * Function that resizes the Hashmap if it is full by a factor of 75%.
     */
    private fun resize() {
        dim *= 2
        val newTable = arrayOfNulls<HashNode<K, V>?>(dim)
        for (i in array.indices) {
            var current = array[i]
            while (current != null) {

                array[i] = array[i]?.next
                val newPos = index(current.key)
                current.next = newTable[newPos]

                if (newTable[newPos] != null) {
                    newTable[newPos]!!.previous = current
                }
                newTable[newPos] = current
                current = array[i]
            }
        }
        array = newTable
    }

    /**
     * Function that removes an Entry of the Hashmap given by a [key].
     * @param key to search in the Hashmap to remove an entry.
     * @return Returns the value associated with [key] or null if [key] is not present in [HashMap].
     */
    override fun remove(key: K): V? {
        val address = index(key)
        val value = array[address]?.value ?: return null
        val node = search(value, address)
        if (node != null) {
            if (node.previous != null)
                node.previous?.next = node.next
            else array[address] = array[address]?.next
            if (node.next != null)
                node.next?.previous = node.previous
            size--
            return value
        }
        return null
    }

    /**
     * Function that returns the value of a given [key] or null if it doesn't exist in the [HashMap].
     * @param key Key to find in the Hashmap.
     * @return Returns the first value associated with that given [key] or null if it isn't present in the Hashmap.
     */
    override fun get(key: K): V? {
        //
        val address = index(key)
        //
        var element: HashNode<K, V>? = array[address]
        //
        while (element != null) {
            //
            if (element.key!!.equals(key))
                return element.value
            element = element.next
        }
        //
        return null
    }

    /**
     * Function that allows the Hashmap to become iterable.
     */
    override fun iterator(): Iterator<MutableMap.MutableEntry<K, V>> {
        //
        var currentPos: Int = -1
        //
        var nodeIterator: HashNode<K, V>? = null
        //
        var currentNode: HashNode<K, V>? = null

        //
        return object : Iterator<MutableMap.MutableEntry<K, V>> {

            /**
             * Function that
             */
            override fun next(): MutableMap.MutableEntry<K, V> {
                //
                if (!hasNext()) throw NoSuchElementException()
                val aux = currentNode
                currentNode = null
                return aux!!
            }

            /**
             * Function that checks if the current node has a next node not null.
             * @return True or False if it has a next Node or not.
             */
            override fun hasNext(): Boolean {
                //
                if (currentNode != null)
                    return true
                //
                while (currentPos < array.size) {
                    //
                    if (nodeIterator == null) {
                        currentPos++
                        //
                        if (currentPos < array.size)
                            nodeIterator = array[currentPos]
                    }
                    //
                    else {
                        currentNode = nodeIterator
                        nodeIterator = nodeIterator?.next
                        return true
                    }
                }
                //
                return false
            }

        }
    }

    /**
     * Function that finds the index of a [key] in the [HashMap].
     * @param key Key to find its index.
     * @return The index or 0 if the key is null.
     */
    private fun index(key: K): Int {
        var pos = key.hashCode() % dim
        if (pos < 0) pos += dim
        return pos
    }
}