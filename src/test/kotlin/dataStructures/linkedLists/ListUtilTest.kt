package dataStructures.linkedLists

import dataStructures.heap.Node

fun IntProgression.toArray() =
	IntArray(this.count()).also { forEachIndexed { index, i -> it[index] = i } }

object ListUtilTest {
	// For circular lists without sentinel
	/**
	 * Creates an empty list without a sentinel
	 *
	 * @return the empty list
	 */
	fun <E> isEmptyListWithoutSentinel(list: Node<E>?): Boolean {
		return list == null
	}

	/**
	 * Creates an empty list without a sentinel
	 *
	 * @param array the array with the values\
	 * @return the empty list
	 */
	fun createDoublyListWithOutSentinel(array: ArrayList<Int?>): Node<Int>? {
		if (array.size == 0) return null
		val list = Node<Int>()
		var cur: Node<Int>? = list
		cur!!.value = array[0]
		for (i in 1 until array.size) {
			val next = Node<Int>()
			cur!!.next = next
			next.previous = cur
			next.value = array[i]
			cur = cur.next
		}
		return list
	}

	// For circular lists with sentinel
	/**
	 * Creates an empty list with sentinel
	 *
	 * @return the empty list
	 */
	fun <E> emptyListWithSentinel(): Node<E> {
		val empty = Node<E>()
		empty.previous = empty
		empty.next = empty.previous
		return empty
	}

	/**
	 * Checks if the empty list has a sentinel
	 *
	 * @param list the list to be checked
	 * @return true if the list has a sentinel, false otherwise
	 */
	fun <E> isEmptyListWithSentinel(list: Node<E>?): Boolean {
		return list!!.next == list && list.previous == list
	}

	/**
	 * Creates a list with sentinel
	 *
	 * @param start the start of the list
	 * @param length the length of the list
	 * @param step the step of the list
	 * @param array the array with the values
	 * @return the list
	 */
	fun getList(start: Int, length: Int, step: Int, array: ArrayList<Int?>?): Node<Int> {
		val list = emptyListWithSentinel<Int>()
		var i = length - 1
		while (i >= 0) {
			list.next = newNode(i + start, list, list.next)
			list.next!!.next!!.previous = list.next
			i -= step
		}
		if (array != null) {
			var current = list.next
			while (current != list) {
				array.add(current!!.value)
				current = current.next
			}
		}
		return list
	}

	/**
	 * Creates a list with sentinel with duplicates
	 *
	 * @param start the start of the list
	 * @param length the length of the list
	 * @param step the step of the list
	 * @param array the array with the values
	 * @return the list
	 */
	fun getListDups(start: Int, length: Int, step: Int, array: ArrayList<Int?>?): Node<Int> {
		val list = emptyListWithSentinel<Int>()
		var count = 1
		var i = length - 1
		while (i >= 0) {
			for (k in 0 until count) {
				list.next = newNode(i + start, list, list.next)
				list.next!!.next!!.previous = list.next
			}
			count++
			i -= step
		}
		if (array != null) {
			var current = list.next
			while (current != list) {
				array.add(current!!.value)
				current = current.next
			}
		}
		return list
	}

	/**
	 * Creates a node with the value
	 *
	 * @param v the value of the node
	 * @return the node
	 */
	private fun <E> newNode(v: E): Node<E> {
		val result = Node<E>()
		result.value = v
		return result
	}

	/**
	 * Creates a node with the value, previous and next nodes
	 *
	 * @param v the value of the node
	 * @param p the previous node
	 * @param n the next node
	 * @return the node
	 */
	private fun <E> newNode(v: E, p: Node<E>?, n: Node<E>?): Node<E> {
		val result = newNode(v)
		result.previous = p
		result.next = n
		return result
	}
}
