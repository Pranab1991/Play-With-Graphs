package com.pranab.playwithgraphs.unweightedgraphs;

import java.util.List;

import com.pranab.playwithgraphs.Graph;

/**
 * The Interface abstracts out the methods for unweighed Graph.
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> The relational entity type, that will be used as vertex in
 *            vertex-edge mapping ,
 * @param <K> Unique key to identify a Vertex
 */
public interface UnWeightedGraph<V, K> extends Graph<V, K> {

	/**
	 * creates an unweighed edge between the specified Nodes.
	 * 
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 */
	void createEdge(K sourceNodeKey, K targetNodeKey);

	/**
	 * creates edges between the provided node and multiple target nodes
	 * 
	 * @param sourceNodeKey   - The unique identifier(key) of source node
	 * @param targetNodeKeys- The list of unique identifiers(keys) of target nodes
	 */
	void createEdges(K sourceNodeKey, List<K> targetNodeKeys);
}
