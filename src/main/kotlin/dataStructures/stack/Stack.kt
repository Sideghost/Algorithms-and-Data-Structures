package dataStructures.stack

interface Stack<E> {
	fun push(new: E)
	fun pop(): E?
	fun peek(): E?
	fun isEmpty(): Boolean
}