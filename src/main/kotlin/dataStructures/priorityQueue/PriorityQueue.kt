package dataStructures.priorityQueue

/**
 * Priority Queue.
 *
 * @param E element.
 * @param P priority.
 */
interface PriorityQueue<E, P> {

	/**
	 * Gets the first element of the queue.
	 *
	 * @return the first element of the queue.
	 */
	fun peek(): E?

	/**
	 * Gets and removes the first element of the queue.
	 *
	 * @return the first element of the queue.
	 */
	fun poll(): E?

	/**
	 * Adds an element to the queue.
	 *
	 * @param elem element to add.
	 * @param priority priority of the element.
	 */
	fun offer(elem: E, priority: P)

	/**
	 * Updates the priority of an element.
	 *
	 * @param elem element to update.
	 * @param newPriority new priority of the element.
	 */
	fun update(elem: E, newPriority: P)

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise.
	 */
	fun isEmpty(): Boolean

	/**
	 * Iterator of the queue.
	 *
	 * @return iterator of the queue.
	 */
	operator fun iterator(): Iterator<E>
}