package com.pranab.playwithgraphs.unweightedgraphs.directed;

import java.util.List;
import java.util.Queue;

import com.pranab.playwithgraphs.unweightedgraphs.UnWeightedGraph;

public interface DirectedGraph<V,K> extends UnWeightedGraph<V, K>{

	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);
	
	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	
	boolean checkCycle();
	
	List<K> getTopologicalOrdered();
	
	List<List<K>> getStrongConnectedComponent();
	
}
