package dataStructures.linkedLists

import dataStructures.heap.Node


fun IntProgression.toArray() =
	IntArray(this.count()).also { forEachIndexed { index, i -> it[index] = i } }

object ListUtilTest {
	/*
	 * For non_circular lists with no sentinel
	 *
	 */

	fun <E> isEmptyListWithoutSentinel(list: Node<E>?): Boolean {
		return list == null
	}

	fun getListWithoutSentinel(array: ArrayList<Int?>): Node<Int>? {
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

	/*
	 * For circular lists with sentinel
	 *
	 */
	fun <E> emptyListWithSentinel(): Node<E> {
		val empty = Node<E>()
		empty.previous = empty
		empty.next = empty.previous
		return empty
	}

	fun <E> isEmptyListWithSentinel(list: Node<E>?): Boolean {
		return list!!.next == list && list.previous == list
	}

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

	/*
	 *
	 * Generic Methods
	 *
	 *
	 */
	fun <E> newNode(v: E): Node<E> {
		val result = Node<E>()
		result.value = v
		return result
	}

	fun <E> newNode(v: E, p: Node<E>?, n: Node<E>?): Node<E> {
		val result = newNode(v)
		result.previous = p
		result.next = n
		return result
	}
}
