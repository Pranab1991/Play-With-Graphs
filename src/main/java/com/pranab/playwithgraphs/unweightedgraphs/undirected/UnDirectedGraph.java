package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import java.util.List;
import java.util.Queue;

import com.pranab.playwithgraphs.unweightedgraphs.UnWeightedGraph;

public interface UnDirectedGraph<V, K> extends UnWeightedGraph<V, K> {

	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);

	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	
	List<List<K>> findClusters();
}
