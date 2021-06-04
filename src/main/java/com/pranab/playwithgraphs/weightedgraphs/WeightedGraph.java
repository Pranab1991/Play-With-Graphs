package com.pranab.playwithgraphs.weightedgraphs;

import java.util.Map;

import com.pranab.playwithgraphs.Graph;

/**
 * An Object that helps in realization of data in Vertex Edge(Graph) format.
 * <p>
 * Vertex : The entity that is to be related with another entity.
 * </p>
 * <p>
 * Edge : Relationship between the entities.
 * </p>
 * <p>
 * Weighted Graph Definition: A set of items connected by edges. Each item is called a
 * vertex or node. Formally, a graph is a set of vertices and a binary relation
 * between vertices, adjacency. Graph is considered to be weighted when the relationship between nodes have varying strength or lenghts.
 * </p>
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> The relational entity type, that will be used as vertex in
 *            vertex-edge mapping ,
 * @param <K> Unique key to identify a Vertex
 * @param <W>  An entity that implements Weight so as to simulate strength of relationship as integer values.
 */
public interface WeightedGraph<V,K,W extends Weight> extends Graph<V,K>{
	
	/**
	 * creates an weighed edge between the specified Nodes.
	 * 
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 * @param edgeWeight - The weight that simulates the strength of relationship.
	 */
	void createEdge(K sourceNodeKey,K targetNodeKey, W edgeWeight);
	
	/**
	 *  creates edges between the provided node and multiple target nodes
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKeyWeightMap - a map of target key as key and weight as value.
	 */
	void createEdges(K sourceNodeKey,Map<K,W> targetNodeKeyWeightMap);
	
	/**
	 * updates the weight between two nodes
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 * @param edgeWeight - The new weight that simulates the strength of relationship.
	 */
	void updateEdgeWeight(K sourceNodeKey,K targetNodeKey, W edgeWeight);
}
