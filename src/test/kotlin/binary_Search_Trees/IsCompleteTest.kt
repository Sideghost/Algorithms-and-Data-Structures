package binary_Search_Trees

import exercices.binary_Search_Trees.isComplete
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsCompleteTest {

val CMP_REVERSE_ORDER = { i1: Int, i2: Int -> i2.compareTo(i1) }
val CMP_NATURAL_ORDER = { i1: Int, i2: Int -> i1.compareTo(i2) }

    @Test
    fun isComplete_empty_trees() {
        val tree = emptyBST()
        assertEquals(-1,height(tree))
        assertTrue(isComplete(tree))
    }

    @Test
    fun isComplete_singleNodeBST() {
        var tree = singleNodeBST(10)
        assertTrue(isComplete(tree))
        tree = add(tree, 0, CMP_NATURAL_ORDER)
        assertEquals(1, height(tree))
        assertFalse(isComplete(tree))
        tree = add(tree, 20, CMP_NATURAL_ORDER)
        assertEquals(1, height(tree))
        assertTrue(isComplete(tree))
    }
    @Test
    fun isComplete_completeBST() {
        val tree = populatedBST(intArrayOf(10,5,12,4,6,16,11))
        assertEquals(2, height(tree))
        assertTrue(isComplete(tree))
    }

    @Test
    fun isComplete_noncompleteBST() {
        val tree = populatedBST(intArrayOf(30,10,5,12,4,3,0,11,40,50))
        assertEquals(5, height(tree))
        assertFalse(isComplete(tree))
    }

}