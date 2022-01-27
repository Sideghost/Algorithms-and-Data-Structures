package other_Algorithms

import java.io.BufferedReader
import java.io.FileReader
import java.io.PrintWriter

fun createReader(fileName: String): BufferedReader {
    return BufferedReader(FileReader(fileName))
}

fun createWriter(fileName: String?): PrintWriter {
    return PrintWriter(fileName)
}

/**
 * Function that reads the files from rot of directory.
 * @param arrayOfFiles array with the name of the files to read.
 * @return array of buffers from files.
 */
fun readFiles(arrayOfFiles: Array<String>) = arrayOfFiles.map { createReader(it) }


/** Usage Example
 *  File on the project Directory:
 *  Copy Input File to OutputFile.
 * **/
fun main( ){
    val br=createReader("input.txt")
    val pw=createWriter("output.txt")
    var line:String?
    line=br.readLine()
    while(line!=null){
        pw.println(line)
        line=br.readLine()
    }
    pw.close()
}