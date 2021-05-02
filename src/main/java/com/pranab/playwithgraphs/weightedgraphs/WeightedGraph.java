package com.pranab.playwithgraphs.weightedgraphs;

import java.util.Map;

import com.pranab.playwithgraphs.Graph;

public interface WeightedGraph<V,K,W extends Weight> extends Graph<V,K>{
	
	void createEdge(K sourceNodeKey,K targetNodeKey, W edgeWeight);
	
	void createEdges(K sourceNodeKey,Map<K,W> targetNodeKeyWeightMap);
	
	void updateEdgeWeight(K sourceNodeKey,K targetNodeKey, W edgeWeight);
}
