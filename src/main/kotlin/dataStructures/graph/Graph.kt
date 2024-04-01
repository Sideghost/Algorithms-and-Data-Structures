package dataStructures.graph

/**
 * Interface for a non-oriented Graph
 */
interface Graph<I, D> {

	/**
	 * Vertex of a Graph
	 */
	interface Vertex<I, D> {
		val id: I
		val data: D

		/**
		 * Replaces the data of a given Vertex
		 *
		 * @param newData New data to store in the Vertex
		 * @return The new data
		 */
		fun setData(newData: D): D

		/**
		 * Function that returns a set of every adjacent Edges of
		 * a certain Vertex
		 *
		 * @return A set of edges might be an empty set if there
		 * are no Edges attached to the Vertex
		 */
		fun getAdjacencies(): MutableSet<Edge<I>?>
	}

	/**
	 * Edge of a Graph
	 */
	interface Edge<I> {
		val id: I
		val adjacent: I
	}

	val size: Int

	/**
	 * Adds a vertex to the Graph if the given Vertex is
	 * already in the graph, returns null without adding it
	 *
	 * @param id ID of the Vertex to add
	 * @param d Data of the Vertex to add
	 * @return The data of the new vertex or null if
	 * the vertex was already in the graph
	 */
	fun addVertex(id: I, d: D): D?

	/**
	 * Adds a new Edge to the Graph, identifying the origin
	 * and destiny vertices.
	 * If the origin Vertex does not exist, returns null without
	 * adding it
	 *
	 * @param id ID of the origin Vertex
	 * @param idAdj ID of the destiny Vertex
	 * @return The ID of the adjacent vertex or null if it doesn't exist
	 */
	fun addEdge(id: I, idAdj: I): I?

	/**
	 * Gets a Vertex given its ID
	 *
	 * @param id ID of the Vertex to search
	 * @return A Vertex or null if it doesn't exist in the graph
	 */
	fun getVertex(id: I): Vertex<I, D>?

	/**
	 * Gets an Edge given its origin and destiny Vertices
	 *
	 * @param id ID of the origin Vertex
	 * @param idAdj ID of the destiny Vertex
	 * @return An Edge or null if it doesn't exist in the graph
	 */
	fun getEdge(id: I, idAdj: I): Edge<I>?

	/**
	 * Iterates over the existing Vertices
	 *
	 * @return Returns an Iterable object that allows to iterate over
	 * the existing Vertices
	 */
	operator fun iterator(): Iterator<Vertex<I, D>>

	/**
	 * Makes the Set of Edges iterable
	 *
	 * @return Returns an Iterable object that allows to iterate over
	 * the Edges
	 */
	fun edgesIterator(): Iterator<Edge<I>>
}
