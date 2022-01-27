package exercices.binary_Search_Trees

fun <E> contains(root: Node<E>?, min: E, max: E, cmp: (e1: E, e2: E) -> Int): Boolean {
    if (root?.item == null) return false
    if (cmp(min, root.item) <= 0 && cmp(max, root.item) >= 0) return true
    if (cmp(root.item, min) < 0) return contains(root.right, min, max, cmp)
    if (cmp(max, root.item) < 0) return contains(root.left, min, max, cmp)
    return false
}