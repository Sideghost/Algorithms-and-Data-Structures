package data_Structures.linked_Lists.single


class SingleLinkedListStructure<E> :SingleLinkedList<E> {

    private class Node<E> :SingleLinkedList.SingleLinkedNode<E> {

        override var item: E?

        var next: Node<E>?

        constructor(e: E?) {
            item = e
            next = null
        }

    }

    private var head: Node<E>? = Node(null)

    override var size: Int = 0

    override fun add(elem: E): E? {
        val nodeToAd = Node(elem)
        var nodeIterated = head
        var previousNode :Node<E>? = null

        while (nodeIterated != null) {
            previousNode = nodeIterated
            nodeIterated = nodeIterated.next
        }

        if (previousNode == null) head = nodeToAd
        else previousNode.next = nodeToAd
        size++
        return nodeToAd.item
    }

    override fun isEmpty(): Boolean {
        return head!!.next == null
    }

    private fun search(elem : E): Node<E>? {
        var node = head
        while (node != null) {
            if (node.item == elem)
                return node

            node = node.next

        }
        return null
    }

    private fun searchForPrevious(elem: E) :Node<E>? {
        var node = head
        while (node != null) {
            if (node.next!!.item == elem)
                return node

            node = node.next
        }
        return null
    }

    override fun contains(elem: E): Boolean {
        return search(elem) != null
    }

    override fun remove(elem: E): E? {
        val nodeToRemove = search(elem) ?: return null
        val previous = searchForPrevious(elem) ?: return null
        previous.next = nodeToRemove.next
        size--
        return elem
    }


}