package otherAlgorithms

/**
 * Function that cleans a line.
 * @param lineWords line to clean.
 * @return a list with only words.
 */
fun cleanLine(lineWords: String?): List<String> {
	return lineWords!!.split(" ").filter {
		it != "" ||
				it.first() in ('0'..'9') ||
				it.first() in ('A'..'Z') ||
				it.first() in ('a'..'z') || it.first() != '.'
	}
}