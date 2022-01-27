package linked_Lists

import data_Structures.heap.Node
import exercices.linked_Lists.intersection
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import linked_Lists.ListUtilTest.getList
import linked_Lists.ListUtilTest.isEmptyListWithSentinel
import linked_Lists.ListUtilTest.isEmptyListWithoutSentinel


class IntersectionTest {
    companion object {
        val CMP_REVERSE_ORDER = Comparator { i1: Int?, i2: Int ->
            i2.compareTo(i1!!)
        }
        val CMP_NATURAL_ORDER = Comparator { i1: Int, i2: Int? ->
            i1.compareTo(i2!!)
        }
    }

    @Test
    fun intersection_empty_lists() {
        var list1: Node<Int>? = ListUtilTest.emptyListWithSentinel()
        var list2: Node<Int>? = ListUtilTest.emptyListWithSentinel()
        assertTrue(isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)))
        list1 = getList(0, 1, 1, null)
        list2 = ListUtilTest.emptyListWithSentinel()!!
        assertTrue(isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)))
        list1 = ListUtilTest.emptyListWithSentinel()!!
        list2 = getList(0, 1, 1, null)
        assertTrue(isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)))
    }

    @Test
    fun intersection_singleton_lists() {
        var list1: Node<Int>? = getList(0, 1, 1, null)
        var list2: Node<Int>? = getList(1, 1, 1, null)
        assertTrue(isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)))
        assertFalse(isEmptyListWithSentinel(list1))
        assertFalse(isEmptyListWithSentinel(list2))
        list1 = getList(1, 1, 1, null)
        list2 = getList(1, 1, 1, null)
        val res: Node<Int>? = intersection(list1, list2, CMP_NATURAL_ORDER)
        assertEquals(1, res!!.value)
        assertTrue(isEmptyListWithSentinel(list1))
        assertTrue(isEmptyListWithSentinel(list2))
    }

    @Test
    fun intersection_different_lists() {
        val list1 = getList(0, 10, 2, null)
        val list2 = getList(1, 10, 2, null)
        assertTrue(isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)))
        assertFalse(isEmptyListWithSentinel(list1))
        assertFalse(isEmptyListWithSentinel(list2))
    }

    @Test
    fun intersection_equal_lists() {
        val elements = ArrayList<Int?>()
        val list1 = getList(0, 10, 1, elements)
        val list2 = getList(0, 10, 1, null)
        val res = intersection(list1, list2, CMP_NATURAL_ORDER)
        var curr = res
        for (i in elements.indices) {
            assertTrue(elements[i] == curr!!.value)
            curr = curr.next
        }
        assertTrue(isEmptyListWithSentinel(list1))
        assertTrue(isEmptyListWithSentinel(list2))
    }

    @Test
    fun intersection_mix_lists() {
        val elements = ArrayList<Int?>()
        val list1 = getList(1, 10, 2, null)
        val list2 = getList(1, 10, 4, elements)
        val res = intersection(list1, list2, CMP_NATURAL_ORDER)
        var curr = res
        for (i in elements.indices) {
            assertTrue(elements[i] == curr!!.value)
            curr = curr.next
        }
        assertFalse(isEmptyListWithSentinel(list1))
        assertTrue(isEmptyListWithSentinel(list2))
    }

    @Test
    fun intersection_with_duplicates_lists() {
        val elements = ArrayList<Int>()
        val elementsDups = ArrayList<Int?>()
        val list1: Node<Int>? = ListUtilTest.getListDups(1, 10, 2, null)
        val list2: Node<Int>? = ListUtilTest.getListDups(1, 10, 4, elementsDups)
        val res = intersection(list1, list2, CMP_NATURAL_ORDER)
        var curr = res
        var prevValue: Int? = null
        for (i in elementsDups.indices) {
            if (elementsDups[i] !== prevValue) {
                elements.add(elementsDups[i]!!)
                prevValue = elementsDups[i]
            }
        }
        for (i in elements.indices) {
            assertTrue(elements[i] == curr!!.value)
            curr = curr.next
        }
        assertFalse(isEmptyListWithSentinel(list1))
        assertTrue(isEmptyListWithSentinel(list2))
    }
}



