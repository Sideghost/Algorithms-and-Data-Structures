package exercices.linkedLists

import dataStructures.heap.Node
import dataStructures.heap.buildMinHeap
import dataStructures.heap.exchange
import dataStructures.heap.minHeapify

/**
 * Function that given an array ([lists]) of Doubly-linked list without sentinel and non-circular
 * ordered by [cmp] comparator returns the element that most occurred in [lists], in case of draw
 * returns the smallest element.
 * @param lists Doubly-linked list without sentinel and non-circular ordered by [cmp] comparator.
 * @param cmp Comparator Criteria.
 * @return Returns the element that most occurred in [lists], in case of draw returns the smallest element.
 */
fun <E> mostOccurrent(lists: Array<Node<E>?>, cmp: Comparator<E>): E? {
	//if every first node as a value of null.
	if (lists.all { it?.value == null }) return null
	//variable to decrement if a node is null.
	var size = lists.size
	//orders the lists to be a heap.
	buildMinHeap(lists, size, cmp)
	//value of the most occurrence.
	var bestValue: E? = null
	//times that the most occurrence occurred.
	var bestCount = 0
	//value of the current occurrence.
	var currentValue: E?
	//times that the current occurrence occurred.
	var currentCount = 0
	//previous node that occurred.
	var previous: E? = null
	//loop to go through all elements in the heap.
	while (size > 0) {
		//stores the value of the index zero in the current occurrence.
		currentValue = lists[0]?.value
		//iterates the current node
		lists[0] = lists[0]?.next

		//changes the last element with the first if the first element is null.
		if (lists[0] == null)
			exchange(0, --size, lists)
		//reorders the heap to maintain its properties.
		minHeapify(lists, 0, size, cmp)
		//checks if the previous value is the same as the current value.
		if (previous != currentValue) {
			//rewrites the previous value with the current value.
			previous = currentValue
			//resets the count to the real count.
			currentCount = 1
		}
		//increments the current count.
		else currentCount++
		//checks if the current cont is bigger than the best count.
		if (currentCount > bestCount) {
			//rewrites the best count with teh current count.
			bestCount = currentCount
			//writes the most occurrence value with the current value.
			bestValue = currentValue
		}
	}
	//returns the best value.
	return bestValue
}