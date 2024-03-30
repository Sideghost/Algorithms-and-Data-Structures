package otherAlgorithms


/**
 * Generic exchange algorithm for an [Array].
 * @param array Array to change elements.
 * @param index1 Index of the first element to change.
 * @param index2 Index of the second element to change.
 */
fun <E> exchange(array: Array<E>, index1: Int, index2: Int) {
	val temp = array[index1]
	array[index1] = array[index2]
	array[index2] = temp
}

/**
 * Exchange algorithm for an [IntArray].
 * @param array Array to change elements.
 * @param index1 Index of the first element to change.
 * @param index2 Index of the second element to change.
 */
fun exchange(array: IntArray, index1: Int, index2: Int) {
	exchange(array.toTypedArray(), index1, index2)
}