package data_Structures.linked_Lists.doubly

class DoublyLinkedListStructure<E> :DoublyLinkedList<E>{

    private class Node<E> :DoublyLinkedList.DoublyLinkedNode<E> {
        override var item: E?

        var next: Node<E>?

        var previous: Node<E>?

        constructor(e: E?) {
            item = e
            next = null
            previous = null
        }

    }

    private var head: Node<E>? = Node(null)

    override var size: Int = 0

    private fun search(elem: E) :Node<E>?{
        var node = head
        while (node!!.next != head){
            if (node.item == elem)
                return node
            node = node.next
        }
        return null
    }

    override fun contains(elem: E): Boolean {
        return search(elem) != null
    }

    override fun isEmpty(): Boolean {
        return head == head!!.next
    }

    override fun add(elem: E): E? {
        val nodeToAd = search(elem)
        if (nodeToAd == null){
            val node = Node(elem)
            head!!.next = node
            head!!.previous!!.next = node
            node.previous = head!!.previous
            node.next = head
            size++
            return node.item
        }
        return null
    }

    override fun remove(elem: E): E? {
        val nodeToRemove = search(elem) ?: return null
        nodeToRemove.previous!!.next = nodeToRemove.next
        nodeToRemove.next!!.previous = nodeToRemove.previous
        return nodeToRemove.item
    }


}