package data_Structures.linked_Lists.single

interface SingleLinkedList<E> {
    interface SingleLinkedNode<E> {
        val item: E?
        //var next: SingleLinkedNode<E>?
    }
    //val sentinel: DoublyLinkedNode<E>
    val size: Int
    fun add(elem: E) :E?
    fun remove(elem: E) :E?
    fun isEmpty() :Boolean
    fun contains(elem: E): Boolean
}