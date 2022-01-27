package exercices.binary_Search_Trees

fun <E> searchRecursive1(root:Node<E>?, element:E, comparator:(E,E)->Int):Boolean{
    if(root==null) return false
    return searchRecursive1(root.left,element,comparator)&&
            searchRecursive1(root.right,element,comparator)
}

fun <E> searchRecursive(root:Node<E>?, element:E, comparator:(E,E)->Int):Boolean{
    if(root==null) return false
    return if(comparator(root.item,element)>0)
        searchRecursive(root.left,element,comparator)
    else searchRecursive(root.right,element,comparator)
}

fun <E> search(root:Node<E>?, element:E, comparator:(E,E)->Int):Boolean{
    var current=root
    while(current!=null){
        if(comparator(current.item,element)==0) return true
        else
            if(comparator(current.item,element)>0)
                current=current.left
            else current=current.right
    }
    return false
}