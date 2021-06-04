package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import java.util.List;
import java.util.Queue;

import com.pranab.playwithgraphs.unweightedgraphs.UnWeightedGraph;

public interface UnDirectedGraph<V, K> extends UnWeightedGraph<V, K> {

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
}
