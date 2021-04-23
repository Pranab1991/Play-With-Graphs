package com.pranab.playwithgraphs;

import java.util.List;
import java.util.Queue;

public interface DirectedGraph<V,K> extends Graph<V, K>{

	List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel);
	
	Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint);
	
	boolean checkCycle();
	
	List<K> getTopologicalOrdered();
	
	List<List<K>> getStrongConnectedComponent();
	
}
