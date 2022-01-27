package data_Structures.priority_Queue

interface Priority_Queue <E,P> {

    interface Element<E,P> {
        val element: E
        //val elementId: Int
        var priority: P
        fun setElement(newElement: E): E
        fun setPriority(newPriority: P): P
    }

    //val heap: Array<Element<E,P>?>
    //val positions: IntArray
    val maxsize: Int
    val comparator: Comparator<P>?//(a: Element<E,P>, b: Element<E,P>) -> Int
    fun peek(): Element<E,P>?
    fun poll(): Element<E,P>?
    fun offer(elem: Element<E,P>)
    //fun decreaseKey(index: Int)
    //fun minHeapify(index: Int)
    fun update(elem: Element<E,P>, newPriority: P)
    fun isEmpty(): Boolean
    //operator fun iterator(): Iterator<Element<E,P>>
}