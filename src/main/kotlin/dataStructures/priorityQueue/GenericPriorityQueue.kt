package dataStructures.priorityQueue

import dataStructures.heap.left
import dataStructures.heap.parent
import dataStructures.heap.right
import otherAlgorithms.exchange

/**
 * Class of a Generic Priority Queue.
 *
 */
class GenericPriorityQueue<E, P>(maxSize: Int, val comparator: Comparator<P>) : PriorityQueue<E, P> {

	/**
	 * Defines an element of the Priority Queue.
	 *
	 * @param element element.
	 * @param priority element's priority.
	 * @param position element's position.
	 */
	data class Element<E, P>(val element: E, var priority: P, val position: Int)

	private val defaultSize = 11

	var size: Int = if (maxSize < 1) defaultSize else maxSize

	private var heap = Array<Element<E, P>?>(size) { null }

	private val positions: IntArray = intArrayOf((1..size).step)

	/**
	 * Gets the first element of the queue.
	 *
	 * @return the first element of the queue.
	 */
	override fun peek(): E? {
		return if (isEmpty()) null else heap.first()!!.element
	}

	/**
	 * Gets and removes the first element of the queue.
	 *
	 * @return the first element of the queue.
	 */
	override fun poll(): E? {
		val elem = peek()
		if (elem != null) {
			heap[0] = heap[--size]
			positions[heap.first()!!.position] = 0
			heap[size] = null
			minHeapify(0)
		}
		return elem
	}

	/**
	 * Adds an element to the queue.
	 *
	 * @param elem element to add.
	 * @param priority priority of the element.
	 */
	override fun offer(elem: E, priority: P) {
		heap[size] = Element(elem, priority, size)
		positions[size] = size
		decreaseKey(size)
		size++
	}

	/**
	 * Updates the priority of an element.
	 *
	 * @param elem element to update.
	 * @param newPriority new priority of the element.
	 */
	override fun update(elem: E, newPriority: P) {
		val position = heap.find { it!!.element == elem }?.position ?: return
		val oldPriority = heap[position]!!.priority
		heap[position]!!.priority = newPriority

		if (comparator.compare(oldPriority, newPriority) > 0)
			minHeapify(position)
		else
			decreaseKey(position)
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise.
	 */
	override fun isEmpty(): Boolean {
		return size == 0
	}

	/**
	 * Iterator of the queue.
	 *
	 * @return iterator of the queue.
	 */
	override fun iterator(): Iterator<E> {
		return object : Iterator<E> {
			private var index = 0
			override fun hasNext(): Boolean {
				return index < size
			}

			override fun next(): E {
				return heap[index++]!!.element
			}
		}
	}

	/**
	 * Decreases the key of an element.
	 *
	 * @param index index of the element.
	 */
	private fun decreaseKey(index: Int) {
		var i = index
		while (i > 0 && comparator.compare(heap[i]!!.priority, heap[parent(i)]!!.priority) < 0) {
			exchange(heap, parent(i), i)
			exchange(positions, heap[i]!!.position, heap[parent(i)]!!.position)
			i = parent(i)
		}
	}

	/**
	 * Min Heapify Algorithm.
	 *
	 * @param index index of the element.
	 */
	private fun minHeapify(index: Int) {
		val left = left(index)
		val right = right(index)
		var smallest = index

		if (left < size && comparator.compare(heap[left]!!.priority, heap[smallest]!!.priority) < 0) smallest = left
		if (right < size && comparator.compare(heap[right]!!.priority, heap[smallest]!!.priority) < 0) smallest = right

		if (smallest == index) return

		exchange(heap, index, smallest)
		exchange(positions, heap[index]!!.position, heap[smallest]!!.position)
		minHeapify(smallest)
	}
}