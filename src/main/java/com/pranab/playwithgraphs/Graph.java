package com.pranab.playwithgraphs;

import java.util.List;

/**
 * An Object that helps in realization of data in Vertex Edge(Graph) format.
 * <p>
 * Vertex : The entity that is to be related with another entity.
 * </p>
 * <p>
 * Edge : Relationship between the entities.
 * </p>
 * <p>
 * Graph Definition: A set of items connected by edges. Each item is called a
 * vertex or node. Formally, a graph is a set of vertices and a binary relation
 * between vertices, adjacency.
 * </p>
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> The relational entity type, that will be used as vertex in
 *            vertex-edge mapping ,
 * @param <K> Unique key to identify a Vertex
 */
public interface Graph<V, K> {

	/**
	 * The procedure creates Node/Vertex identified by a Unique Key in the graph.
	 * 
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value needs to be encapsulated in Node/Vertex
	 */
	void createNode(K key, V value);

	/**
	 * The procedure removes Node/Vertex from the graph.
	 * 
	 * @param key - An unique identifier for a Vertex/Node
	 * @return The Entity whose value is encapsulated within that Node/Vertex.
	 */
	V removeNode(K key);

	/**
	 * The procedure updates Entity in the Node/Vertex identified by the key.
	 * 
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value will be updated in the Node/Vertex
	 *              identified by the key
	 */
	void updateNode(K key, V value);

	/**
	 * Get the Entity of the Node/Vertex identified by the Key
	 * 
	 * @param key - An unique identifier for a Vertex/Node
	 * @return The Entity whose value is encapsulated within that Node/Vertex.
	 */
	V getValue(K key);

	/**
	 * Removes the edge between source and target node identified by respective keys
	 * 
	 * @param sourceNodeKey - The key for source node
	 * @param targetNodeKey - The key for target node
	 */
	void removeEdge(K sourceNodeKey, K targetNodeKey);

	/**
	 * Removes the edge between source and multiple target node identified by
	 * respective keys
	 * 
	 * @param sourceNodeKey  - The key for source node
	 * @param targetNodeKeys - The keys for target node
	 */
	void removeEdges(K sourceNodeKey, List<K> targetNodeKeys);

	/**
	 * Removes all the edges of a source node
	 * 
	 * @param sourceNodeKey - The key for source node
	 */
	void removeAllEdges(K sourceNodeKey);

	/**
	 * Returns all the target keys of the edges whose source is from the node
	 * identified by the provided key
	 * 
	 * @param sourceNodeKey - The key for source node
	 * @return List of the target keys
	 */
	List<K> getAllEdgeKeys(K sourceNodeKey);

	/**
	 * resets all the node's states in a graph
	 */
	void resetAllNodes();

	/**
	 * Returns the number of nodes in the graph
	 * 
	 * @return integer value depicting the number of nodes currently present in
	 *         graph
	 */
	int size();

}
