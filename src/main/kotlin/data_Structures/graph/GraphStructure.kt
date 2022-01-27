package data_Structures.graph

/**
 * Class that implements a non-oriented Graph.
 */
class GraphStructure<I, D>: Graph<I, D> {

    /**
     * Class that implements the Vertex of a graph.
     * @property data Data of a given Vertex.
     * @property id Identifier of a Graph.
     * @property edges Set od edges (aka) reference of ...
     */
    private class Vertex<I,D> :Graph.Vertex<I,D> {

        override var data: D

        override var id: I

        private val edges = mutableSetOf<Graph.Edge<I>?>()

        constructor(Id: I, Data: D){
            data = Data
            id = Id
        }

        /**
         * Function that returns a set of every adjacent Edges of a Vertex.
         * @return A set of edges, might be an empty set if there are no Edges.
         */
        override fun getAdjacencies(): MutableSet<Graph.Edge<I>?> {
            return edges
        }

        /**
         * Function that replaces the data of a given Vertex.
         * @param newData New data to store in the Vertex.
         * @return Returns (previous or new) ??????? data.
         */
        override fun setData(newData: D): D {
            val oldData = data
            data = newData
            return oldData
        }

    }

    /**
     * Class that implements an Edge of the Graph.
     * @property id Identifier of the origin Edge.
     * @property adjacent Identifier of the destiny Edge.
     */
    private class Edge<I> : Graph.Edge<I> {
        override var adjacent: I

        override var id: I

        constructor(Adjacent: I, Id: I) {
            adjacent = Adjacent
            id = Id
        }
    }

    //private val defaultSize = 11

    val map = HashMap<I, Graph.Vertex<I, D>>(/*defaultSize*/)

    override val size: Int
        get() {
            return map.size
        }

    /**
     * Function that adds a vertex to the Graph.
     * If the given Vertex is already present in the graph exits the function returns null without adding it.
     * @param id ID of the Vertex.
     * @param d Data of the Vertex.
     * @return Returns the data of the new vertex or null if the vertex was already present.
     */
    override fun addVertex(id: I, d: D): D? {
        val vertex = getVertex(id)
        if (vertex != null) return null

        map[id] = Vertex(id,d)
        return d
    }

    /**
     * Function that adds a new Edge to the Graph, identifying the origin and destiny vertices.
     * If the origin Vertex does not exist returns null without adding it.
     * @param id ID of the origin Vertex.
     * @param idAdj ID of the destiny Vertex.
     * @return Returns the iD of the adjacent vertex or null if it doesn't exist.
     */
    override fun addEdge(id: I, idAdj: I): I? {
        val idVertex = getVertex(id) ?: return null
        if (getEdge(id, idAdj) != null) return null

        idVertex.getAdjacencies().add(Edge(id,idAdj))
        return idAdj
    }

    /**
     * Function that gets the Vertex given its ID.
     * @param id ID of the Vertex to search.
     * @return Returns a Vertex or null if it doesn't exist.
     */
    override fun getVertex(id: I): Graph.Vertex<I, D>? {
        return map[id]
    }

    /**
     * Function that gets an Edge given its origin and destiny Vertices.
     * @param id ID of the origin Vertex.
     * @param idAdj ID of the destiny Vertex.
     * @return Returns an Edge or null if it doesn't exist.
     */
    override fun getEdge(id: I, idAdj: I): Graph.Edge<I>? {
        val address = getVertex(id) ?: return null
        address.getAdjacencies().forEach{
            if( it!!.adjacent == idAdj) return it
        }
        return null
    }

    /**
     * Function that makes the Hashmap of Vertex iterable.
     * @return Returns an Iterable object that allows to iterate over the Vertices.
     */
    override fun iterator(): Iterator<Graph.Vertex<I, D>> {
        return object :Iterator<Graph.Vertex<I, D>> {
            val iterator = map.iterator()

            override fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            override fun next(): Graph.Vertex<I, D> {
                return iterator.next().value
            }
        }

    }

    /**
     *
     */
    override fun edgesIterator(): Iterator<Graph.Edge<I>> {
        TODO("NOt yet implemented")
//        return object : Iterator<Graph.Edge<I>> {
//            val iterator = map.mSet.iterator()
//
//            override fun hasNext(): Boolean {
//                return iterator.hasNext()
//            }
//
//            override fun next(): Graph.Edge<I> {
//                return iterator.next().adjacent
//            }
//        }
    }
}