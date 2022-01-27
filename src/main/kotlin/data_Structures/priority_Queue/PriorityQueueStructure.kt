//package data_Structures.priority_Queue
//
//import data_Structures.heap.left
//import data_Structures.heap.parent
//import data_Structures.heap.right
//import other_Algorithms.exchange
//import java.util.Objects.compare
//
///**
// * Class of an Abstract Priority Queue.
// *
// */
//class PriorityQueueStructure<E, P> : Priority_Queue<E, P> {
//
//    override val comparator: Comparator<P>?
//        get() = TODO("Not yet implemented")
//    override val maxsize: Int
//        get() = TODO("Not yet implemented")
//
//    private class User<E, P> : Priority_Queue.Element<E, P> {
//
//        override var element: E
//        override var priority: P
//        var elementId: Int
//
//        constructor(elem: E, ElementId: Int, Priority: P) {
//            element = elem
//            elementId = ElementId
//            priority = Priority
//        }
//
//        override fun setElement(newElement: E): E {
//            this.element = newElement
//            return newElement
//        }
//
//        override fun setPriority(newPriority: P): P {
//            this.priority = newPriority
//            return newPriority
//        }
//    }
//
//    private val defaultSize = 11
//
//    var size: Int = if (maxsize<1) defaultSize else maxsize
//
//    private var heap = Array<User<E, P>?>(size) { null }
//
//    private val positions: IntArray = intArrayOf((1..size).step)
//
//    constructor(comparator:(P,P)-> Int) {
//        heap = arrayOfNulls(size)
//
//    }
//
//    //private val defaultComparator = Comparator.comparing{ User.priority -Priority_Queue.Element.priority }
//
//    //val cmp = comparator ?: Comparator<P>{a:P,b:P -> a - b}
//
//    private fun decreaseKey(index: Int) {
//        var i = index
//        while (i > 0 && cmp.compare(heap[i]!!.priority, heap[parent(i)]!!.priority) < 0) {
//            exchange(heap, parent(i), i)
//            exchange(positions, heap[i]!!.elementId, heap[parent(i)]!!.elementId)
//            i = parent(i)
//        }
//    }
//
//    override fun offer(elem: Priority_Queue.Element<E, P>) {
//        heap[maxsize] = elem as User
//        positions[elem.elementId] = maxsize
//        decreaseKey(maxsize)
//        size++
//    }
//
//    override fun isEmpty(): Boolean {
//        return maxsize == 0
//    }
//
//    private fun minHeapify(index: Int) {
//        val left = left(index)
//        val right = right(index)
//        var smallest = index
//
//        if (left < maxsize && cmp.compare(heap[left]!!.priority, heap[smallest]!!.priority) < 0) smallest = left
//        if (right < maxsize && cmp.compare(heap[right]!!.priority, heap[smallest]!!.priority) < 0) smallest = right
//
//        if (smallest == index) return
//
//        exchange(heap, index, smallest)
//        exchange(positions, heap[index]!!.elementId, heap[smallest]!!.elementId)
//        minHeapify(smallest)
//    }
//
//    override fun peek(): Priority_Queue.Element<E, P>? {
//        return heap.first()
//    }
//
//    override fun poll(): Priority_Queue.Element<E, P>? {
//        val elem = peek()
//        if (elem != null) {
//            heap[0] = heap[--size]
//            positions[heap.first()!!.elementId] = 0
//            heap[maxsize] = null
//            minHeapify(0)
//        }
//        return elem
//    }
//
//    override fun update(elem: Priority_Queue.Element<E, P>, newPriority: P) {
//        val position = positions[elem.elementId]
//        val oldPriority = heap[position]!!.priority
//        heap[position]!!.priority = newPriority
//
//        if (cmp.compare(oldPriority, newPriority) > 0)
//            minHeapify(position)
//        else
//            decreaseKey(position)
//    }
//
//}