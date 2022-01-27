package exercices.arrays

import sorting_Algorithms.quickSort
import kotlin.math.roundToInt

/**
 *  Function that returns the median element if it is odd or the average of the two middle elements if it is even. Complexity O()
 *  @param v IntArray.
 *  @param l first index to iterate.
 *  @param r last index to iterate.
 *  @return median of the IntArray.
 */
fun median(v: Array<Int>, l: Int, r: Int): Int {
    quickSort(v,l,r) {a, b -> a-b}
    return if (v.size % 2 == 0) ((v[v.size / 2] + v[(v.size / 2) - 1]) / 2) else v[v.size / 2]
}

fun main() {
    println("Median:")
    val randomArrayEven = Array(50) { (Math.random() * 50).roundToInt() * if(Math.random() > 0.5) 1 else -1 }
    val randomArrayEvenTest = randomArrayEven
    randomArrayEvenTest.sort()
    val medianEvenTest =
        (randomArrayEvenTest[randomArrayEven.size / 2] + randomArrayEvenTest[(randomArrayEven.size / 2) - 1]) / 2
    println("Test Even real -> $medianEvenTest")
    println("Test Even: Expected $medianEvenTest -> ${median(randomArrayEven, 0, randomArrayEven.size - 1)}")

    val randomArrayOd = Array(51) { (Math.random() * 50).roundToInt() * if(Math.random() > 0.5) 1 else -1 }
    val randomArrayOdTest = randomArrayOd
    randomArrayOdTest.sort()
    val medianOdTest = randomArrayOdTest[randomArrayOdTest.size / 2]
    println("Test Od real -> $medianOdTest")
    println("Test Od: Expected $medianOdTest -> ${median(randomArrayOd, 0, randomArrayOd.size - 1)}")
}