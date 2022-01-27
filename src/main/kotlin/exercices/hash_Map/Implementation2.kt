package exercices.hash_Map

// WITHOUT USING kotlin.collections EXCEPT ArrayList

//imports needed for the implementation.
import data_Structures.hash_Map.HashMap
import data_Structures.hash_Map.filter
import other_Algorithms.cleanLine
import other_Algorithms.createReader
import kotlin.system.exitProcess


/**
 * Class that serves as a multiplexer for [mapOfAFile] Function in [Implementation2].
 */
private enum class Implementation2{SameOccurrence,Similarity,AllWords}

/**
 * Class that represents the number of occurrence depending on a file.
 * @property first Number that represents the number of occurrences in the first file.
 * @property second Number that represents the number of occurrences in the second file.
 */
private data class Pair<T,U>(var first:Int, var second:Int)


/**
 * Main Function of the program, uses Data Structures specially created for this program.
 * (Structure present in [data_Structures.hash_Map])
 * Program that lists all words in two files,
 * checks for words with the same occurrence in two files,
 * checks for similarities of two files or
 * terminates the program.
 */
fun main(args: Array<String>) {
    println("For [allWords] use the following structure (allWords)")
    println("For [SameOccurrence] use the following structure (wordsWithTheSameOccurrence[space][nr of words])")
    println("For [similarity] just type (similarity)")
    println("For [exit] just type (exit)")

    while (true) {
        //reads the Standard Out Put Stream
        val input = readLine()!!
        val command = input.split(" ")
        //Files are passed as program arguments.
        //val inputFiles = Array(args.maxsize) { args[it] }
        //chooses the program option.
        when (command[0]) {
            //all words option.
            "allWords" -> {
                //maps both files.
                val file1 = allWords(args)
                //prints all words and its occurrences.
                print(file1.size)
                printOccurrences(file1)
            }
            //words with the same occurrence option.
            "wordsWithTheSameOccurrence" -> {
                wordsWithTheSameOccurrence(args, command[1].toInt())
            }
            //similarity option.
            "similarity" -> {
                val similarity = similarity(args)
                println("Similarity = $similarity [0..n] (n being the number of words without the same Occurrence in both Files)")
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
private fun allWords(fileNames: Array<String>) :HashMap<String, Pair<Int,Int>> {
    //maps the first file.
    val mapOfFile1 = mapOfAFile(fileNames[0], option = Implementation2.AllWords)
    //maps the second file using the fist file.
    return mapOfAFile(fileNames[1],mapOfFile1,Implementation2.AllWords)
}


/**
 *  Function that prints a Hashmap.
 *  @param hashMap Hashmap to print.
 */
private fun printOccurrences(hashMap: HashMap<String, Pair<Int,Int>>) {
    //iterates through the Hashmap
    val mapIt = hashMap.iterator()
    //checks if the hashmap has something to print.
    while(mapIt.hasNext()){
        //current Entry.
        val currentNode = mapIt.next()
        //checks if the occurrence occurred in the first file or the second.
        val currentNodeCount = if(currentNode.value.first>0) currentNode.value.first else currentNode.value.second
        //prints the word and the times that the word occurred.
        println("${currentNode.key}(${currentNodeCount})")
    }
}


/**
 *  Function that creates a Hashmap of a given file
 *  @param fileName to create a buffer to read a file.
 *  @param map Map of first file if it was created.
 *  @param option Option that serves as multiplexer for make changes to the [map].
 *  @return Hashmap of [fileName] or more than one.
 */
private fun mapOfAFile(fileName: String, map: HashMap<String, Pair<Int,Int>>? = null, option: Implementation2): HashMap<String, Pair<Int,Int>> {
    //reader of a file.
    val reader = createReader(fileName)
    //current line of [reader].
    var currentLine :String?
    //creates a Hashmap if it wasn't passed as a parameter.
    var hashMap = map
    if (hashMap == null)
        hashMap = HashMap()
    //Loop to read a file and make changes to the Hashmap.
    while (reader.readLine().also { currentLine = it } != null) {
        //line cleaned
        val cleanLine = cleanLine(currentLine)
        //checks if the line as any word.
        if (cleanLine.isNotEmpty())
        //loop to go through all words in a line.
            for (i in cleanLine.indices){
                //current line that is being read.
                val current = hashMap[cleanLine[i]]
                //depending on the option it makes changes to the Hashmap.
                when (option) {
                    //in all words option it adds a word if it isn't already there.
                    Implementation2.AllWords -> {
                        //if a map isn't passed as a function param, it means that is reading the first file.
                        if(map == null) {
                            //if a word isn't present in the Hashmap if adds the word and an integer that
                            //represents the fist occurrence of that word.
                            if (current == null)
                                hashMap.put(cleanLine[i], Pair(1, 0))
                            //if the word is already the Hashmap it increments its occurrence.
                            else
                                current.first++
                            // hashMap.put(cleanLine[i], Pair(current.first + 1,0))
                        }
                        //for the second file
                        else {
                            //checks if a word isn't already present in the Hashmap.
                            if (current == null)
                                hashMap.put(cleanLine[i],Pair(0,1))
                            //if it is already there increments in the second value of the pair.
                            else
                                current.second++
                            //hashMap.put(cleanLine[i], Pair(current.first, current.second+1))
                        }
                    }
                    // in same occurrence it checks if a word as the same Occurrence in both files.
                    Implementation2.SameOccurrence -> {
                        //if a word isn't in the Hashmap it skips the word.
                        if(current == null )
                            continue
                        // if the word is present in the Hashmap it decrements the number of its occurrence.
                        else
                            current.second++
                        //hashMap.put(cleanLine[i],Pair(current.first,current.second + 1))

                    }
                    // in similarity, it checks the degree of similarity of both files.
                    Implementation2.Similarity -> {
                        //if a word isn't present already in the Hashmap it adds the word.
                        if(current == null)
                            hashMap.put(cleanLine[i], Pair(0,1))
                        // if a word is already in the Hashmap it increments the occurrence of file two.
                        else
                            current.second++
                        // hashMap.put(cleanLine[i], Pair(current.first,current.second +1))
                    }
                }
            }
    }
    //return the altered Hashmap.
    return hashMap
}


/**
 * Function that implements the [wordsWithTheSameOccurrence] option to the program.
 * @param files Names of the [files] to create a Hashmap.
 * @param nrOfWords Number of Occurrences to search in the Hashmap.
 */
private fun wordsWithTheSameOccurrence(files: Array<String>, nrOfWords: Int) {
    //maps the first file.
    val file1 = mapOfAFile(files[0], option = Implementation2.SameOccurrence)
    //maps the second file using the first file filtered by number of occurrences.
    val bothFiles = mapOfAFile(files[1], file1, Implementation2.SameOccurrence)
    //prints the words with the same occurrence in both files.
    bothFiles.filter { (it.value.first-it.value.second == 0) && (it.value.first == nrOfWords) }.forEach { println(it.key) }
}


/**
 * Function that implements the [similarity] option to the program.
 * @param files Array of two files to check for [similarity].
 * @return Number of words that don't have the same occurrence in both [files].
 */
private fun similarity(files: Array<String>): Int {
    //maps the first file.
    val file1 = mapOfAFile(files[0], option = Implementation2.AllWords)
    //maps the second file using the first file.
    val both = mapOfAFile(files[1],file1,Implementation2.Similarity)
    //returns the number of words that don't have the same occurrence in both files.
    return both.filter { it.value.first-it.value.second != 0 }.size
}
