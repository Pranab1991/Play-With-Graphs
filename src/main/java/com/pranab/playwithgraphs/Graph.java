package com.pranab.playwithgraphs;

import java.util.List;

public interface Graph<V,K> {

	void createNode(K key,V value);
	
	V removeNode(K key);
	
	void updateNode(K key,V value);
	
	V getValue(K key);
	
	void createEdge(K sourceNodeKey,K targetNodeKey);
	
	void createEdges(K sourceNodeKey,List<K> targetNodeKeys);
	
	void removeEdge(K sourceNodeKey,K targetNodeKey);
	
	void removeEdges(K sourceNodeKey,List<K> targetNodeKeys);
	
	void removeAllEdges(K sourceNodeKey);
	
	List<K> getAllEdgeKeys(K sourceNodeKey);
	
	void resetAllNodes();
	
	int size();

}
