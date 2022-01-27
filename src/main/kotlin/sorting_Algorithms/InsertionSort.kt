package sorting_Algorithms

fun <E> insertionSort(array: Array<E>, cmp :Comparator<E>){
    for (i in 1 until  array.size){
        val value = array[i]
        var curIdx = i

        while(curIdx > 0 && cmp.compare(array[curIdx-1], value) > 0) {
            array[curIdx] = array[--curIdx]
        }
        array[curIdx] = value
    }
}

fun <E> Array<E>.insertionSort2(comparator: Comparator<E>) {
    for (i in 1 until this.size) {
        val value = this[i]
        var curIdx = i

        while (curIdx > 0 && comparator.compare(this[curIdx - 1], value) > 0) {
            this[curIdx] = this[--curIdx]
        }
        this[curIdx] = value
    }
}