package dataStructures.priorityQueue

import dataStructures.heap.left
import dataStructures.heap.parent
import dataStructures.heap.right
import otherAlgorithms.exchange

data class Patient(val name: String, val patientId: Int, val priority: Int)

data class PatientPriorityQueue(
	val heap: Array<Patient?>,
	val positions: IntArray,
	var size: Int,
	val compare: (a: Patient, b: Patient) -> Int
)

/**
 * Add and position a new element
 * Time Complexity: O(log₂n)
 */
fun PatientPriorityQueue.offer(elem: Patient) {
	heap[size] = elem
	positions[elem.patientId] = size
	decreaseKey(size)
	size++
}


/**
 * Time Complexity: O(log₂n)
 */
private fun PatientPriorityQueue.decreaseKey(index: Int) {
	var i = index
	while (i > 0 && compare(heap[i]!!, heap[parent(i)]!!) < 0) {
		exchange(heap, i, parent(i))
		exchange(positions, heap[i]!!.patientId, heap[parent(i)]!!.patientId)
		i = parent(i)
	}
}


/**
 * Return the element with more priority, or null if the heap is empty
 */
fun PatientPriorityQueue.peek(): Patient? =
	heap[0]


/**
 * Returns and removes the element with more priority
 */
fun PatientPriorityQueue.poll(): Patient? {
	val elem = peek()
	if (elem != null) {
		heap[0] = heap[--size]
		positions[heap[0]!!.patientId] = 0
		heap[size] = null
		minHeapify(0)
	}
	return elem
}

/**
 * Time Complexity: O(log₂n)
 */
private fun PatientPriorityQueue.minHeapify(i: Int) {
	val left = left(i)
	val right = right(i)
	var smallest = i

	if (left < size && compare(heap[left]!!, heap[smallest]!!) < 0) smallest = left
	if (right < size && compare(heap[right]!!, heap[smallest]!!) < 0) smallest = right

	if (smallest == i) return

	exchange(heap, i, smallest)
	exchange(positions, heap[i]!!.patientId, heap[smallest]!!.patientId)
	minHeapify(smallest)
}


/**
 * Updates the status of a User
 */
fun PatientPriorityQueue.update(newStatus: Patient) {
	val oldStatus = heap[positions[newStatus.patientId]]!!
	heap[positions[newStatus.patientId]] = newStatus

	if (compare(oldStatus, newStatus) > 0) {
		decreaseKey(positions[newStatus.patientId])
	} else
		minHeapify(positions[newStatus.patientId])
}