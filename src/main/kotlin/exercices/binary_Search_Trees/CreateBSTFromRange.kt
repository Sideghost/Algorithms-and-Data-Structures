package exercices.binary_Search_Trees

data class Node<E>(var item: E, var left: Node<E>?, var right: Node<E>?)

fun createBSTFromRange(start: Int, end: Int): Node<Int>? {
    //non-existing interval
    if (end - start <= 0) return null

    //variable initialization
    val mid = end - (end - start) / 2
    val interval = (start..end)
    var leftElem = mid - 1
    var rightElem = mid + 1
    val root = Node(mid, null, null)
    var parent = root

    //loop to go through every element in interval
    while (parent.item in interval) {
        if (parent.left == null) {
            parent.left = Node(leftElem, null, null)
            leftElem--
        } else {
            parent.right = Node(rightElem, null, null)
            rightElem++
        }

        parent = if (isComplete(parent)) parent.left!!
        else parent.right!!
    }
    return root
}