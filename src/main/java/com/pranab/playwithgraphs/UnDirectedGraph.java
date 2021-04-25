package com.pranab.playwithgraphs;

import java.util.List;
import java.util.Queue;

public interface UnDirectedGraph<V, K> extends Graph<V, K> {

	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);

	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	
	List<List<K>> findClusters();
}
