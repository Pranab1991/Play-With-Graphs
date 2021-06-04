package com.pranab.playwithgraphs.weightedgraphs.undirected;

import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedGraph;

public interface UnDirectedWeightedGraph<V,K,W extends Weight> extends WeightedGraph<V,K,W> {

	/**
	 * provides a level wise search from the source node provided.<br>
	 * Level 1 - returns all the nodes directly linked with source node.<br>
	 * Level 2 - returns all the nodes directly linked to the nodes returned in
	 * Level 1.<br>
	 * 
	 * @param startingKeyPoint   - the node which acts as the source node or the
	 *                           starting point of search
	 * @param searchLevel        - integer value emphasizing the level from the
	 *                           source node which needs to be searched.
	 * @param includeBeforeLevel - boolean value when true includes the previous
	 *                           level nodes in the result
	 * @return a list of keys of the Vertices present in that level Or the list of
	 *         keys till that level depending on includeBeforeLevel variable value
	 */
	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);

	/**
	 * finds the shortest path between two given Nodes/Vertex
	 * 
	 * @param startingKeyPoint - the node which acts as the source node or the
	 *                         starting point
	 * @param targetKeyPoint   - the target node to which the path needs to be
	 *                         identified
	 * @return list of all the nodes that make up the path to the targeted node.
	 */
	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	

	/**
	 * finds forests in graph if any
	 * @return list of forests found
	 */
	List<List<K>> findClusters();
	
	/**
	 * the function finds the tree with minimum edge cost sum in a given graph.<br>
	 * A minimum spanning tree is a special kind of tree that minimizes the lengths (or weights) of the edges of the tree.
	 * @return the list of edges contributing to the formation of minimum spanning tree
	 */
	java.util.List<SpanningEdge<K>> minimumSpaningTree();

	/**
	 * finds forests in graph if any and return the forest satisfying the query criteria.<br>
	 * @param predicate - This is a functional interface whose functional method is test(Object) returning a boolean.
	 * @return list of forests found
	 */
	List<K> findClusters(Predicate<W> predicate);
}
