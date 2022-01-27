package other_Algorithms


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

fun exchange(array: IntArray, index1: Int, index2: Int) {
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}