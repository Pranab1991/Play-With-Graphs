package com.pranab.playwithgraphs.unweightedgraphs;

import java.util.List;

import com.pranab.playwithgraphs.Graph;

public interface UnWeightedGraph<V,K> extends Graph<V,K>{

	void createEdge(K sourceNodeKey,K targetNodeKey);
	
	void createEdges(K sourceNodeKey,List<K> targetNodeKeys);
}
