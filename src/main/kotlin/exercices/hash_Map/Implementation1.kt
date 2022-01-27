package exercices.hash_Map


// USING kotlin.collections
import other_Algorithms.cleanLine
import other_Algorithms.createReader
import kotlin.collections.*
import kotlin.system.exitProcess


/**
 * Class that serves as a multiplexer for [mapOfAFile] Function in [Implementation1].
 */
private enum class Implementation1 {SameOccurrence,Similarity,AllWords}


/**
 * Main Function of the program, uses Data Structures present in [kotlin.collections] and [java.util] libraries.
 * Program that lists all words in two files,
 * checks for words with the same occurrence in two files,
 * checks for similarities of two files or
 * terminates the program.
 */
fun main(args: Array<String> ) {
    println("For [allWords] use the following structure (allWords)")
    println("For [SameOccurrence] use the following structure (SameOccurrence[space][nr of words])")
    println("For [similarity] use the following structure (similarity)")
    println("For [exit] just type (exit)")

    while (true) {
        //reads the Standard Out Put Stream
        val input = readLine()!!
        val command = input.split(" ")
        //Files are passed as program arguments.
        val inputFiles = Array(args.size) { args[it] }
        //chooses the program option.
        when (command[0]) {
            //all words option.
            "allWords" -> {
                //maps both files.
                val file1 = allWords(inputFiles)
                //prints all words and its occurrences.
                printOccurrences(file1)
            }
            //words with the same occurrence option.
            "sameOccurrence" -> {
                wordsWithTheSameOccurrence(inputFiles, command[1].toInt())
            }
            //similarity option.
            "similarity" -> {
                val similarity = similarity(inputFiles)
                println("Similarity = $similarity [0..n] (n being the number of words with the same Occurrence in both Files)")
            }
            //exit option
            "exit" -> {
                println("Please dont Break")
                exitProcess(-1)
            }
        }
    }

}


/**
 *  Function that implements the [allWords] option of the program.
 *  @param fileNames Files to create a Hashmap of words and Occurrences.
 *  @return Hashmap of both files.
 */
private fun allWords(fileNames: Array<String>): HashMap<String, Int> {
    //maps the first file.
    val map = mapOfAFile(fileNames[0], option = Implementation1.AllWords)
    //maps the second file using the fist file.
    return mapOfAFile(fileNames[1], map,Implementation1.AllWords)
}


/**
 *  Function that prints a Hashmap.
 *  @param hashMap Hashmap to print.
 */
private fun printOccurrences(hashMap: HashMap<String, Int>) {
    //loop to go through all the entries in the Hashmap
    for (i in hashMap.entries)
    //prints the word and the times that the word occurred.
        println("${i.key}(${i.value})")
}


/**
 *  Function that creates a Hashmap of a given file
 *  @param fileName to create a buffer to read a file.
 *  @param map Map of the first file if it was created.
 *  @param option Option that serves as multiplexer for make changes to the [map].
 *  @return Hashmap of [fileName] or more than one.
 */
private fun mapOfAFile(fileName: String, map: HashMap<String, Int>? = null, option: Implementation1): HashMap<String, Int> {
    //reader of a file.
    val fileReader = createReader(fileName)
    //current line of [reader].
    var currentLine: String?
    //creates a Hashmap if it wasn't passed as a parameter.
    var hashMap = map
    if (hashMap == null)
        hashMap = HashMap()
    //Loop to read a file and make changes to the Hashmap.
    while (fileReader.readLine().also { currentLine = it } != null) {
        //line cleaned
        val cleanLine = cleanLine(currentLine)
        //checks if the line as any word.
        if (cleanLine.isNotEmpty())
        //loop to go through all words in a line.
            for (word in cleanLine) {
                //depending on the option it makes changes to the Hashmap.
                when(option) {
                    //in all words option it adds a word if it isn't already there.
                    Implementation1.AllWords -> {
                        //if a word isn't present in the Hashmap if adds the word and an integer that
                        //represents the fist occurrence of that word.
                        if (!hashMap.containsKey(word))
                            hashMap[word] = 1
                        //if the word is already the Hashmap it increments its occurrence.
                        else
                            hashMap[word] = hashMap[word]!! + 1
                    }
                    // in same occurrence it checks if a word as the same Occurrence in both files.
                    Implementation1.SameOccurrence -> {
                        //if a word isn't in the Hashmap it skips the word.
                        if (!hashMap.containsKey(word))
                            continue
                        // if the word is present in the Hashmap it decrements the number of its occurrence.
                        else
                            hashMap[word] = hashMap[word]!! - 1

                    }
                    //in similarity, it checks the degree of similarity of both files.
                    Implementation1.Similarity -> {
                        //if a word isn't present already in the Hashmap it adds the word.
                        if (!hashMap.containsKey(word))
                            hashMap[word] = 1
                        // if a word is already in the Hashmap it decrements the occurrence of that same word.
                        else
                            hashMap[word] = hashMap[word]!! - 1
                    }
                }
            }
    }
    //return the altered Hashmap.
    return hashMap
}


/**
 *  Function that implements the [wordsWithTheSameOccurrence] option to the program.
 *  (Only works with 2 Files).
 *  @param files Names of the [files] to create a Hashmap.
 *  @param nrOfWords Number of Occurrences to search in the Hashmap.
 */
private fun wordsWithTheSameOccurrence(files: Array<String>, nrOfWords: Int) {
    //maps the first file.
    val file1 = mapOfAFile(files[0], option = Implementation1.AllWords)
    //maps the second file using the first file filtered by number of occurrences.
    val allFiles = mapOfAFile(files[1],file1.filterValues { it == nrOfWords } as HashMap<String, Int>, Implementation1.SameOccurrence)
    //prints the words with the same occurrence in both files.
    allFiles.filterValues { it == 0 }.forEach{ println(it.key) }
}


/**
 * Function that implements the [similarity] option to the program.
 * @param files Array of [files] to check for [similarity]
 * @return Number of words that don't have the same occurrence in both [files].
 */
private fun similarity(files: Array<String>): Int {
    //maps the first file.
    val file1 = mapOfAFile(files[0], option = Implementation1.AllWords)
    //maps the second file using the first file.
    val both = mapOfAFile(files[1], file1, Implementation1.Similarity)
    //returns the number of words that don't have the same occurrence in both files.
    return both.filterValues { it != 0 }.size
}
