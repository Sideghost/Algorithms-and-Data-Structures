package dataStructures.linkedLists

import dataStructures.heap.Node
import exercices.linkedLists.mostOccurrent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostOccurrentTest {

	@Test
	fun `most occurrent on a empty array`() {
		val array = arrayOfNulls<Node<Int>?>(10)
		assertEquals(null, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun `most occurrent in a singleton list with different elements`() {
		val array = arrayOfNulls<Node<Int>?>(10)
		var i = 0
		for (el in differentElements) {
			array[i++] = Node(el)
		}
		assertEquals(0, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun `most occurrent singleton lists with equal elements`() {
		val array = arrayOfNulls<Node<Int>?>(10)
		var i = 0
		for (el in equalElements) {
			array[i++] = Node(el)
		}
		assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun `most occurrent singleton with more than one ocurrence in different lists`() {
		val array = arrayOfNulls<Node<Int>?>(setOfTwoDifferentElements.size)
		var i = 0
		for (`in` in setOfTwoDifferentElements) {
			array[i++] = Node(`in`)
		}
		assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
	}

	@Test
	fun `most occurrent in lists with more than one ocurrence`() {
		val array = arrayOfNulls<Node<Int>?>(3)
		initData(array, setsOfElements)
		assertEquals(6, mostOccurrent(array, CMP_NATURAL_ORDER))
	}


	/**
	 * Initializes the array with the data from the arraylist
	 *
	 * @param array the array to be initialized
	 * @param arrayList the list with the data
	 */
	private fun initData(array: Array<Node<Int>?>, arrayList: ArrayList<ArrayList<Int>>) {
		if (array.size != arrayList.size) return
		for (i in arrayList.indices) {
			for (j in arrayList[i].indices.reversed()) {
				val novo = Node(arrayList[i][j])
				novo.next = array[i]
				if (array[i] != null) array[i]!!.previous = novo
				array[i] = novo
			}
		}
	}

	companion object {
		val CMP_NATURAL_ORDER = Comparator { i1: Int, i2: Int? ->
			i1.compareTo(i2!!)
		}

		private val differentElements = ArrayList(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
		private val equalElements = ArrayList(listOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2))
		private val setsOfElements = ArrayList(
			listOf(
				ArrayList(listOf(1, 2, 2, 5, 6, 6)),
				ArrayList(listOf(0, 0, 2, 2, 6)),
				ArrayList(listOf(6, 6, 7, 7, 7, 7, 8))
			)
		)
		private val setOfTwoDifferentElements = ArrayList(listOf(3, 3, 2, 3, 2, 2, 2, 3, 2, 2))
	}
}
