package dataStructures.graph

/**
 * Class that implements a non-oriented Graph.
 */
class GraphStructure<I, D> : Graph<I, D> {

	/**
	 * Data class that implements the Vertex on the graph.
	 * @property data Data of a given Vertex.
	 * @property id Identifier of a Graph.
	 * @property edges Set of edges (aka) reference of links between Vertexes.
	 */
	data class Vertex<I, D>(override val id: I, override var data: D) : Graph.Vertex<I, D> {

		private val edges = mutableSetOf<Graph.Edge<I>?>()

		/**
		 * Function that returns a set of every adjacent Edges of a certain Vertex.
		 * @return A set of edges, might be an empty set if there are no Edges attached to the Vertex.
		 */
		override fun getAdjacencies(): MutableSet<Graph.Edge<I>?> {
			return edges
		}

		/**
		 * Function that replaces the data of a given Vertex.
		 * @param newData New data to store in the Vertex.
		 * @return The new data.
		 */
		override fun setData(newData: D): D {
			data = newData
			return newData
		}

	}

	/**
	 * Class that implements an Edge of the Graph.
	 * @property id Identifier of the origin Vertex.
	 * @property adjacent Identifier of the destiny Vertex.
	 */
	data class Edge<I>(override val id: I, override val adjacent: I) : Graph.Edge<I>

	val map = HashMap<I, Graph.Vertex<I, D>>()

	override val size: Int
		get() {
			return map.size
		}

	/**
	 * Function that adds a vertex to the Graph.
	 * If the given Vertex is already in the graph, function returns null without adding it.
	 * @param id ID of the Vertex to add.
	 * @param d Data of the Vertex to add.
	 * @return The data of the new vertex or null if the vertex was already in the graph.
	 */
	override fun addVertex(id: I, d: D): D? {
		val vertex = getVertex(id)
		if (vertex != null) return null
		map[id] = Vertex(id, d)
		return d
	}

	/**
	 * Function that adds a new Edge to the Graph, identifying the origin and destiny vertices.
	 * If the origin Vertex does not exist returns null without adding it.
	 * @param id ID of the origin Vertex.
	 * @param idAdj ID of the destiny Vertex.
	 * @return The ID of the adjacent vertex or null if it doesn't exist.
	 */
	override fun addEdge(id: I, idAdj: I): I? {
		val address = getVertex(id) ?: return null
		address.getAdjacencies().add(Edge(id, idAdj))
		return idAdj
	}

	/**
	 * Function that gets a Vertex given its ID.
	 * @param id ID of the Vertex to search.
	 * @return A Vertex or null if it doesn't exist in the graph.
	 */
	override fun getVertex(id: I): Graph.Vertex<I, D>? {
		return map[id]
	}

	/**
	 * Function that gets an Edge given its origin and destiny Vertices.
	 * @param id ID of the origin Vertex.
	 * @param idAdj ID of the destiny Vertex.
	 * @return An Edge or null if it doesn't exist in the graph.
	 */
	override fun getEdge(id: I, idAdj: I): Graph.Edge<I>? {
		val address = getVertex(id) ?: return null
		address.getAdjacencies().forEach {
			if (it!!.adjacent == idAdj) return it
		}
		return null
	}

	/**
	 * Function that makes a HashMap of Vertex that can be iterated.
	 * @return Returns an Iterable object that allows to iterate over the existing Vertices.
	 */
	override fun iterator(): Iterator<Graph.Vertex<I, D>> {
		return object : Iterator<Graph.Vertex<I, D>> {
			val iterator = map.iterator()

			/**
			 * Function that verifies if the next vertex is different from null.
			 * @return True if there is more vertex and false if there aren't.
			 */
			override fun hasNext(): Boolean {
				return iterator.hasNext()
			}

			/**
			 * Function that iterate in the map if the next vertex is different from null.
			 * @return Next vertex or trows exception.
			 */
			override fun next(): Graph.Vertex<I, D> {
				if (!hasNext()) throw NoSuchElementException("No such Vertex")
				return iterator.next().value
			}
		}
	}

	/**
	 * Function that makes the Set of Edges iterable.
	 * @return Returns an Iterable object that allows to iterate over the Edges.
	 */
	override fun edgesIterator(): Iterator<Graph.Edge<I>> {
		return object : Iterator<Graph.Edge<I>> {
			val vertexIterator = map.iterator()
			var edgeIterator: MutableIterator<Graph.Edge<I>?>? = null
			var currentEdge: Graph.Edge<I>? = null

			/**
			 * Function that verifies if the next edge is different from null.
			 * @return True if there is more edges and false if there aren't.
			 */
			override fun hasNext(): Boolean {
				if (currentEdge != null)
					return true
				if (vertexIterator.hasNext()) {

					if (edgeIterator == null) {
						edgeIterator = vertexIterator.next().value.getAdjacencies().iterator()
						hasNext()
					} else {

						if (edgeIterator!!.hasNext()) {
							currentEdge = edgeIterator!!.next()
							return true
						} else {
							edgeIterator = null
							hasNext()
						}
					}
				}
				return false
			}

			/**
			 * Function that iterate in the map if the next edge is different from null.
			 * @return Next edge or trows exception.
			 */
			override fun next(): Graph.Edge<I> {
				if (!hasNext()) throw NoSuchElementException("No such edge")
				val aux = edgeIterator
				edgeIterator = null
				return aux!!.next()!!
			}
		}
	}
}