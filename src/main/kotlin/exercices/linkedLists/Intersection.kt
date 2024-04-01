package exercices.linkedLists

import dataStructures.heap.Node

/**
 * Function that given two doubly linked lists ([list1] and [list2]) without a sentinel and non-circular
 * ordered by [cmp] comparator returns a list with the elements that are present in both lists removing
 * them in the corresponding original list.
 * @param list1 Doubly linked list without sentinel and non-circular ordered by [cmp] comparator.
 * @param list2 Doubly linked list without sentinel and non-circular ordered by [cmp] comparator.
 * @param cmp Comparator criteria.
 * @return Doubly linked list without sentinel and non-circular that has the common occurrences of [list1] and [list2].
 */
fun <E> intersection(list1: Node<E>?, list2: Node<E>?, cmp: Comparator<E>): Node<E>? {
	//new list to build
	var newList: Node<E>? = null
	//first element of the new list.
	var firstNode: Node<E>? = null
	//current node of list1
	var currentNode1 = list1?.next
	//auxiliary variable for list1
	var aux1: Node<E>?
	//current node of list2
	var currentNode2 = list2?.next
	//auxiliary variable for list2
	var aux2: Node<E>?
	//loop to cycle through all elements in both lists
	while (currentNode1 != list1 && currentNode2 != list2) {
		//checks if current value of node 1 and current value of node 2 are the same.
		if (cmp.compare(currentNode1!!.value, currentNode2!!.value) == 0) {
			//copies the current node to its auxiliary
			aux1 = currentNode1
			aux2 = currentNode2
			//iterates the current nodes to the next node
			currentNode2 = currentNode2.next
			currentNode1 = currentNode1.next

			//disconnects both common nodes form the original list.
			aux1.previous?.next = currentNode1
			currentNode1?.previous = aux1.previous

			aux2.previous?.next = currentNode2
			currentNode2?.previous = aux2.previous

			//checks if the current node in the new list is the same as the new node to not add to the new list.
			if (newList?.value == aux1.value) continue

			//cleans the reference to the next node of the auxiliary
			aux1.next = null

			//checks if it's the first node to add to the new list.
			if (firstNode == null) {
				//cleans the reference to the previous node.
				aux1.previous = null
				//puts the new node in a new list.
				newList = aux1
				//puts the reference to the firsts' node of the new list.
				firstNode = newList
				//checks if both lists are singletons.
				if (currentNode1 == list1 || currentNode2 == list2) return firstNode

			}
			//the new list already has any element
			else {
				//rewrites the reference of the new node to be the previous last node in the new list.
				aux1.previous = newList
				//puts the reference to the previous last node in the new list to be the current new node.
				newList?.next = aux1
				//checks if the value of both current nodes of the lists isn't null to allow to the new list to iterate.
				if (currentNode1?.value != null || currentNode2?.value != null) newList = newList?.next
				//if it isn't any more values to check returns, the first node.
				else return firstNode
			}
		}
		//checks if the current value of node one is higher than the current value of node two to iterate current node two.
		if (cmp.compare(currentNode1?.value, currentNode2?.value) > 0) currentNode2 = currentNode2?.next
		//checks if the current value of node one is smaller than the current value of node two to iterate current node one.
		if (cmp.compare(currentNode1?.value, currentNode2?.value) < 0) currentNode1 = currentNode1?.next
	}

	return firstNode
}