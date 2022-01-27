package linked_Lists

import data_Structures.heap.Node
import exercices.linked_Lists.mostOccurrent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


class MostOccurrentTest {

    val CMP_NATURAL_ORDER = Comparator.naturalOrder<Int>()

    val DIFFERENT_ELEMENTS = ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
    val EQUAL_ELEMENTS = ArrayList(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2))
    val SETS_OF_ELEMENTS = ArrayList(
        Arrays.asList(ArrayList(Arrays.asList(1, 2, 2, 5, 6, 6)),
            ArrayList(Arrays.asList(0, 0, 2, 2, 6)),
            ArrayList(Arrays.asList(6, 6, 7, 7, 7, 7, 8))))
    val TWO_SETS_OF_ELEMENTS = ArrayList(Arrays.asList(3, 3, 2, 3, 2, 2, 2, 3, 2, 2))

    @Test
    fun mostOccurrent_empty_array() {
        val array = arrayOfNulls<Node<Int>?>(10) as Array<Node<Int>?>
        assertEquals(null, mostOccurrent(array, CMP_NATURAL_ORDER))
    }

    @Test
    fun mostOccurrent_singleton_listsWithDifferentElements() {
        val array = arrayOfNulls<Node<Int>?>(10) as Array<Node<Int>?>
        var i = 0
        for (el in DIFFERENT_ELEMENTS) {
            array[i++] = Node(el)
        }
        assertEquals(0, mostOccurrent(array, CMP_NATURAL_ORDER))
    }

    @Test
    fun mostOccurrent_singleton_listsWithEqualElements() {
        val array = arrayOfNulls<Node<Int>?>(10) as Array<Node<Int>?>
        var i = 0
        for (el in EQUAL_ELEMENTS) {
            array[i++] = Node(el)
        }
        assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
    }

    @Test
    fun mostOccurrent_singleton_WithMoreThanOneOcurrenceInDifferentLists() {
        val array = arrayOfNulls<Node<Int>?>(TWO_SETS_OF_ELEMENTS.size) as Array<Node<Int>?>
        var i = 0
        for (`in` in TWO_SETS_OF_ELEMENTS) {
            array[i++] = Node(`in`)
        }
        assertEquals(2, mostOccurrent(array, CMP_NATURAL_ORDER))
    }

    @Test
    fun mostOccurrent_listsWithMoreThanOneOcurrence() {
        val array = arrayOfNulls<Node<Int>?>(3) as Array<Node<Int>?>
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






