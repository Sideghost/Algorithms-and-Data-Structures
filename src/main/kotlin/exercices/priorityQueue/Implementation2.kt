package exercices.priorityQueue

import dataStructures.priorityQueue.GenericPriorityQueue
import kotlin.system.exitProcess
import otherAlgorithms.readFiles


/**
 * Implementation using ADT PriorityQueue from AEDPriorityQueue.
 */
fun main() {
	println("For get use the following structure (get [number of words] [outputFile] [inputFiles])")
	println("For sort use the following structure (sort)")
	println("For exit just type (exit)")

	var get = GetImplementation(arrayOf(Occurrences("", -1)), "outputFile.txt")

	while (true) {
		val input = readln()
		val command = input.split(" ")

		when (command[0]) {

			"get" -> get = get(command[1].toInt(), command[2], Array(command.size - 3) { command[3 + it] })
			"sort" -> sortPQ(get.occurrences, get.outputFile)
			"exit" -> exitProcess(-1)
		}
	}
}


/**
 * Function that given an array of files returns the k words more frequent inside those arrays.
 * @param k k words
 * @param outputFile name of the output file.
 * @param sourceFiles array of files to read.
 * @return a pair with an array of words and number of occurrences as well the name of the output file.
 */
fun get(k: Int, outputFile: String, sourceFiles: Array<String>): GetImplementation {

	//initializing priority queue as well as it's comparator
	val pq = GenericPriorityQueue<Line, Line>(sourceFiles.size) { a: Line, b: Line -> a.content.compareTo(b.content) }

	//reads from the buffers of files
	val file = readFiles(sourceFiles)

	//offers the lines to the priority queue
	//assuming that the first line of any file isn't null
	file.forEachIndexed { idx, line ->
		pq.offer(Line(line.readLine(), idx), Line(line.readLine(), idx))
	}

	//previous occurrence in the priority queue to check if current is the same.
	var previous = Occurrences("", -1)

	//array of greater occurrences.
	val stringOccurrences = Array(k + 1) { Occurrences("", -1) }

	//index to match k
	var i = 0

	while (pq.size > 0) {

		//removes the most priority element from the priority queue
		val current = pq.poll()
		//pq.update(current)

		//reads the next line from the [current] buffer
		val nextLine = file[current?.file!!].readLine()

		//case for the end of any file
		if (nextLine != null) {
			pq.offer(Line(nextLine, current.file), Line(nextLine, current.file))
		}

		//case for comparing if the last string is the same as the current
		if (previous.content != current.content) {
			//if the array isn't full adds the occurrence to it
			if (i < k) {
				stringOccurrences[i] = previous
				i++
			}

			//rewrites in the last index to the end of the array and sorts it so that the last element is the less occurred
			else {
				stringOccurrences[i] = previous
				stringOccurrences.insertionSort { a, b -> b - a }
			}
			//rewrites the previous with the current
			previous = Occurrences(current.content, 1)
		}
		//case of repeated Strings (adds 1 to the number of occurrences)
		else previous = previous.copy(n = previous.n + 1)

	}

	createOutputFile(outputFile, stringOccurrences)

	return GetImplementation(stringOccurrences, outputFile)
}
