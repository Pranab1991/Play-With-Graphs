package com.pranab.playwithgraphs.weightedgraphs.directed;

import java.util.List;
import java.util.Queue;

import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedGraph;

/**
 * The Interface abstracts out the methods for weighed graph.
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> The relational entity type, that will be used as vertex in
 *            vertex-edge mapping ,
 * @param <K> Unique key to identify a Vertex
 * @param <W> An entity that implements Weight so as to simulate strength of relationship as integer values.
 */
public interface DirectedWeightedGraph<V, K, W extends Weight> extends WeightedGraph<V, K, W> {


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
	 * Checks weather there is a cycle in the provided graph.<br>
	 * Example : A -&lt; B -&lt; C -&lt; A contains a cycle
	 * 
	 * @return boolean value when true,the graph contains a cycle
	 */
	boolean checkCycle();

	/**
	 * does a topologically sorting of given graph.<br>
	 * A topological sort or topological ordering of a directed
	 * graph is a linear ordering of its vertices such that for every directed edge
	 * uv from vertex u to vertex v, u comes before v in the ordering
	 * 
	 * @return list of Nodes/Vertex keys, topologically sorted
	 */
	List<K> getTopologicalOrdered();

	/**
	 * Identifies all the strongly connected components in a given graph.
	 * @return List of strongly connected component nodes list.
	 */
	List<List<K>> getStrongConnectedComponent();

}
