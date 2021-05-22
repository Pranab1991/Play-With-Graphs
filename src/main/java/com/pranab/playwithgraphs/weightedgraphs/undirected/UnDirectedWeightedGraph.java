package com.pranab.playwithgraphs.weightedgraphs.undirected;

import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedGraph;

public interface UnDirectedWeightedGraph<V,K,W extends Weight> extends WeightedGraph<V,K,W> {

	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);

	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	
	List<List<K>> findClusters();
	
	java.util.List<SpanningEdge<K>> minimumSpaningTree();

	List<K> findClusters(Predicate<W> predicate);
}
