//package exercices.priority_Queue
//
//import data_Structures.priority_Queue.PriorityQueueStructure
//import other_Algorithms.createWriter
//import other_Algorithms.readFiles
//
//
///**
// * Implementation using ADT PriorityQueue from AEDPriorityQueue.
// */
//fun main(){
//    println("For get use the following structure (get[space][number of words][space][outputFile][space][inputFiles])")
//    println("For sort use the following structure (sort)")
//    println("For exit just type (exit)")
//
//    var get = GetImplementation(arrayOf(Occurrences("",-1)),"outputFile.txt")
//
//    while (true) {
//        //reads the Standard Out Put Stream
//        val input = readLine()!!
//        val command = input.split(" ")
//
//        when(command[0]) {
//
//            "get" -> get = get(command[1].toInt(), command[2], Array(command.size-3){command[3+it]})
//            "sort" -> sort(get.occurrences,get.outputFile)
//            "exit" -> System.exit(-1)
//        }
//    }
//}
//
//
///**
// * Function that given an array of files returns the k words more frequent inside those arrays.
// * @param k k words
// * @param outputFile name of the output file.
// * @param sourceFiles array of files to read.
// * @return a pair with an array of words and number of occurrences as well the name of the output file.
// */
//fun get(k: Int, outputFile: String, sourceFiles: Array<String>) :GetImplementation {
//
//    //initializing priority queue as well as it's comparator
//    //val pq = AbstractPriorityQueue(Array(3){ Line ("",-1) }, 0) { a, b -> a.compareTo(b) }
//    val pq = PriorityQueueStructure<Line>{ a, b -> a.content.compareTo(b.content)}
//
//    //reads from the buffers of files
//    val file = readFiles(sourceFiles)
//
//    //offers the lines to the priority queue
//    //assuming that the first line of any file isn't null
//    file.forEachIndexed { idx, line ->
//        pq.offer(Line(line.readLine(), idx),0)
//    }
//
//    //creates the output file
//    val out = createWriter(outputFile)
//
//    //previous occurrence in priority queue to check if current is the same.
//    var previous = Occurrences("", -1)
//
//    //array of greater occurrences.
//    val stringOccurrences = Array(k + 1) { Occurrences("", -1) }
//
//    //index to match k
//    var i = 0
//
//    //cycle to say if the priority queue still has lines in it
//    //cycle ends if all lines in buffers were read
//    while (pq.size > 0) {
//
//        //removes the most priority element from the priority queue
//        val current = pq.poll()
//        //pq.update(current)
//
//        //reads the next line from the [current] buffer
//        val nextLine = file[current.file].readLine()
//
//        //case for the end of any file
//        if (nextLine != null) {
//            pq.offer(Line(nextLine, current.file))
//        }
//
//        //case for comparing if the last string is the same as the current
//        if (previous.content != current.content) {
//            //if the array isn't full adds the occurrence to it
//            if (i < k) {
//                stringOccurrences[i] = previous
//                i++
//            }
//
//            //rewrites in the last index to the end of the array and sorts it so that the last element is the less occurred
//            else {
//                stringOccurrences[i] = previous
//                stringOccurrences.insertionSort{ a, b -> b - a }
//            }
//            //rewrites the previous with the current
//            previous = Occurrences(current.content, 1)
//        }
//        //case of repeated Strings (adds 1 to the number of occurrences)
//        else previous = previous.copy(n = previous.n + 1)
//
//    }
//
//    //Prints for the output file
//    for (j in 0 until stringOccurrences.size - 1) {
//        out.println(stringOccurrences[j].content)
//
//    }
//
//    out.close()
//    return GetImplementation(stringOccurrences, outputFile)
//}
//
//
///**
// * Function that sorts the number of occurrences from [get] of Implementation 2.
// * @param greaterOccurrences array with the greater occurrences.
// * @param outputFile name of output file.
// * @return returns and prints the sorted occurrences.
// */
//fun sort(greaterOccurrences:Array<Occurrences>, outputFile: String){
//
//    greaterOccurrences.insertionSort { a, b -> b - a }
//    val out = createWriter(outputFile)
//    for (i in 0 until greaterOccurrences.size - 1) {
//        out.println(greaterOccurrences[i].content)
//
//    }
//    out.close()
//}
