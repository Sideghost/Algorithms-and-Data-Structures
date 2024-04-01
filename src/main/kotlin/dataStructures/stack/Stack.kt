package dataStructures.stack

/**
 * Interface for the stack data structure
 *
 * @param E the type of the elements in the stack
 */
interface Stack<E> {

	/**
	 * Pushes a new element to the stack
	 *
	 * @param new the new element to be pushed
	 */
	fun push(new: E)

	/**
	 * Pops the top element from the stack
	 *
	 * @return the top element from the stack
	 */
	fun pop(): E?

	/**
	 * Peeks the top element from the stack
	 *
	 * @return the top element from the stack
	 */
	fun peek(): E?

	/**
	 * Checks if the stack is empty
	 *
	 * @return true if the stack is empty, false otherwise
	 */
	fun isEmpty(): Boolean
}