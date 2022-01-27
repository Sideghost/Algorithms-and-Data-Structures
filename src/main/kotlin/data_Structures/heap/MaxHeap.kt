package data_Structures.heap

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

fun <E> buildMaxHeap(heap: Array<Node<E>?>, cmp: Comparator<E>) {
    for (i in heap.size / 2 - 1 downTo 0) {
        maxHeapify(heap, i, heap.size, cmp)
    }
}
