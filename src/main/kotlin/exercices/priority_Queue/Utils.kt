package exercices.priority_Queue

/**
 * Class that determines the proprieties of a line that was read.
 * @property content content of that line.
 * @property file index of the origin file.
 */
data class Line(val content: String, val file: Int)


/**
 * Class that has the number of times that a line is repeated in the input files.
 * @property content content of a line (String)
 * @property n number of times that that line as occurred.
 */
data class Occurrences(val content: String, var n:Int)


/**
 * Class that determines the proprieties of the Get Implementation.
 * @property occurrences greater occurrences inside the files to check.
 * @property outputFile name of the output file to write the greater occurrences.
 */
data class GetImplementation(val occurrences: Array<Occurrences>, val outputFile: String)


/**
 * Function that implements the insertion Sort algorithm in the Array of Occurrences. Complexity O(k^2)
 * @receiver Array of Occurrences.
 * @param comparator criteria for ordering the array.
 */
fun Array<Occurrences>.insertionSort(comparator: Comparator<Int>) {
    for (i in 1 until this.size) {
        val value = this[i]
        var curIdx = i

        while (curIdx > 0 && comparator.compare(this[curIdx - 1].n, value.n) > 0) {
            this[curIdx] = this[--curIdx]
        }
        this[curIdx] = value
    }
}