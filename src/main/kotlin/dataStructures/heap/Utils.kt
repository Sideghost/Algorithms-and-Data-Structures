package dataStructures.heap

/**
 * Changes one element in the [heap] with another
 *
 * @param i index of the element to change with [j]
 * @param j index of the element to change with [i]
 * @param heap array to make the change
 */
fun <E> exchange(i: Int, j: Int, heap: Array<Node<E>?>) {
	if (i < 0 || j < 0) return
	val tmp = heap[i]
	heap[i] = heap[j]
	heap[j] = tmp
}

/**
 * Gets the left index of the [i] element
 *
 * @param i index of the element
 * @return left index of the [i] element
 */
fun left(i: Int) = 2 * i + 1

/**
 * Gets the right index of the [i] element
 *
 * @param i index of the element
 * @return right index of the [i] element
 */
fun right(i: Int) = 2 * i + 2

/**
 * Gets the parent index of the [i] element
 *
 * @param i index of the element
 * @return parent index of the [i] element
 */
fun parent(i: Int) = (i - 1) / 2
