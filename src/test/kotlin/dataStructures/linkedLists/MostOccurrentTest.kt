package dataStructures.linkedLists

import dataStructures.heap.Node
import exercices.linkedLists.mostOccurrent
import java.util.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class MostOccurrentTest {

	val DIFFERENT_ELEMENTS = ArrayList(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
	val EQUAL_ELEMENTS = ArrayList(listOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2))
	val SETS_OF_ELEMENTS = ArrayList(
		listOf(
			ArrayList(listOf(1, 2, 2, 5, 6, 6)),
			ArrayList(listOf(0, 0, 2, 2, 6)),
			ArrayList(listOf(6, 6, 7, 7, 7, 7, 8))
		)
	)
	val TWO_SETS_OF_ELEMENTS = ArrayList(listOf(3, 3, 2, 3, 2, 2, 2, 3, 2, 2))

	@Test
	fun mostOccurrent_empty_array() {
		val array = arrayOfNulls<Node<Int>?>(10)
		assertEquals(null, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun mostOccurrent_singleton_listsWithDifferentElements() {
		val array = arrayOfNulls<Node<Int>?>(10)
		var i = 0
		for (el in DIFFERENT_ELEMENTS) {
			array[i++] = Node(el)
		}
		assertEquals(0, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun mostOccurrent_singleton_listsWithEqualElements() {
		val array = arrayOfNulls<Node<Int>?>(10)
		var i = 0
		for (el in EQUAL_ELEMENTS) {
			array[i++] = Node(el)
		}
		assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun mostOccurrent_singleton_WithMoreThanOneOcurrenceInDifferentLists() {
		val array = arrayOfNulls<Node<Int>?>(TWO_SETS_OF_ELEMENTS.size)
		var i = 0
		for (`in` in TWO_SETS_OF_ELEMENTS) {
			array[i++] = Node(`in`)
		}
		assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun mostOccurrentInListsWithMoreThanOneOcurrence() {
		val array = arrayOfNulls<Node<Int>?>(3)
		initData(array, SETS_OF_ELEMENTS)
		assertEquals(6, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	private fun initData(array: Array<Node<Int>?>, arraylist: ArrayList<ArrayList<Int>>) {
		if (array.size != arraylist.size) return
		for (i in arraylist.indices) {
			for (j in arraylist[i].indices.reversed()) {
				val novo = Node(arraylist[i][j])
				novo.next = array[i]
				if (array[i] != null) array[i]!!.previous = novo
				array[i] = novo
			}
		}
	}

	companion object {
		val CMP_REVERSE_ORDER = Comparator { i1: Int?, i2: Int ->
			i2.compareTo(i1!!)
		}
		val CMP_NATURAL_ORDER = Comparator { i1: Int, i2: Int? ->
			i1.compareTo(i2!!)
		}
	}
}






