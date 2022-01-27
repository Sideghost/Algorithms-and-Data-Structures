package exercices.binary_Search_Trees

import kotlin.math.abs
import kotlin.math.max

fun <E> isBalanced(root:Node<E>?):Boolean{
    return isBalancedAux(root)!=-1
}
fun <E> isBalancedAux(root:Node<E>?):Int{
    if(root==null) return 0
    val l= isBalancedAux(root.left)
    val r= isBalancedAux(root.right)
    if(l==-1 || r==-1) return -1
    return if(abs(l-r) <=1) max(l,r) +1 else -1
}