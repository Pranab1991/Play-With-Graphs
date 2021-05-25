package com.pranab.playwithgraphs;

import java.util.List;

/**
 * An Object that helps in realization of data in Vertex Edge(Graph) format.
 * <p>Vertex : The entity that is to be related with another entity.</p>
 * <p>Edge : Relationship between the entities.</p>
 * <p>Graph Definition: A set of items connected by edges. Each item is called a vertex or node.
 * Formally, a graph is a set of vertices and a binary relation between vertices, adjacency. </p>
 * @author Pranab Bharadwaj
 *
 * @param <V> The relational entity type, that will be used as vertex in vertex-edge mapping ,  
 * @param <K> Unique key to identify a Vertex
 */
public interface Graph<V,K> {

	void createNode(K key,V value);
	
	V removeNode(K key);
	
	void updateNode(K key,V value);
	
	V getValue(K key);
	
	
	void removeEdge(K sourceNodeKey,K targetNodeKey);
	
	void removeEdges(K sourceNodeKey,List<K> targetNodeKeys);
	
	void removeAllEdges(K sourceNodeKey);
	
	List<K> getAllEdgeKeys(K sourceNodeKey);
	
	void resetAllNodes();
	
	int size();

}
