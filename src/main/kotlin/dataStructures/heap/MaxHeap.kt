package dataStructures.heap

/**
 * Guarantees that the [heap] maintains as a max heap
 *
 * @param heap heap to maintain in max heap
 * @param rootIdx index of the largest value
 * @param n last index of the [heap]
 * @param cmp comparator criteria
 */
fun <E> maxHeapify(heap: Array<Node<E>?>, rootIdx: Int, n: Int, cmp: Comparator<E>) {
	val l = left(rootIdx)
	val r = right(rootIdx)
	var largest = rootIdx

	if (l < n && cmp.compare(heap[l]!!.value, heap[largest]!!.value) > 0) largest = l
	if (r < n && cmp.compare(heap[r]!!.value, heap[largest]!!.value) > 0) largest = r

	if (largest == rootIdx) return
	exchange(rootIdx, largest, heap)
	maxHeapify(heap, largest, n, cmp)
}

/**
 * Builds a max heap from an [heap]
 *
 * @param heap Array to build a max heap
 * @param cmp comparator criteria to build the max heap
 */
fun <E> buildMaxHeap(heap: Array<Node<E>?>, cmp: Comparator<E>) {
	for (i in heap.size / 2 - 1 downTo 0) {
		maxHeapify(heap, i, heap.size, cmp)
	}
}
