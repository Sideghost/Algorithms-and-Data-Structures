package dataStructures.heap


/**
 * Function that guaranties that the [heap] maintains as a min heap.
 * @param heap heap to maintain in min heap.
 * @param rootIdx index of the smallest value.
 * @param maxIdx last index of the [heap].
 * @param cmp comparator criteria.
 */
fun <E> minHeapify(heap: Array<Node<E>?>, rootIdx: Int, maxIdx: Int, cmp: Comparator<E>) {
	val l = left(rootIdx)
	val r = right(rootIdx)
	var smallest = rootIdx

	if (l < maxIdx && cmp.compare(heap[l]!!.value, heap[smallest]!!.value) < 0) smallest = l
	if (r < maxIdx && cmp.compare(heap[r]!!.value, heap[smallest]!!.value) < 0) smallest = r

	if (smallest == rootIdx) return
	exchange(rootIdx, smallest, heap)
	minHeapify(heap, smallest, maxIdx, cmp)
}

/**
 * Function that creates a Minheap from an [array].
 * @param array Array to build a Minheap.
 * @param maxIdx last index of the [array] to build the MinHeap
 * @param cmp comparator criteria to build the Min Heap.
 */
fun <E> buildMinHeap(array: Array<Node<E>?>, maxIdx: Int, cmp: Comparator<E>) {
	for (i in maxIdx / 2 - 1 downTo 0) {
		minHeapify(array, i, maxIdx, cmp)
	}
}
