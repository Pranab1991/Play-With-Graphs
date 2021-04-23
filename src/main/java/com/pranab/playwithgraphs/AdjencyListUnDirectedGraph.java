package com.pranab.playwithgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pranab.playwithgraphs.datastructure.LinkedList;

public class AdjencyListUnDirectedGraph<V, K> implements UnDirectedGraph<V, K> {

	Map<K, UnDirectedNode<V, K>> storage = new HashMap<>();
	
	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public void createNode(K key, V value) {
		UnDirectedNode<V, K> node = new UnDirectedNode<>(value);
		storage.put(key, node);
	}

	@Override
	public V removeNode(K key) {
		UnDirectedNode<V, K> node = storage.remove(key);
		return node.getValue();
	}

	@Override
	public void updateNode(K key, V value) {
		UnDirectedNode<V, K> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	@Override
	public V getValue(K key) {
		return storage.get(key).getValue();
	}

	@Override
	public void createEdge(K sourceNodeKey, K targetNodeKey) {
		if((!storage.containsKey(targetNodeKey))||(!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		Edge<K> edge = new Edge<>(targetNodeKey);
		edgeList.addLast(edge);
		
		UnDirectedNode<V, K> inSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> inEdgeList = inSourceNode.getOutGoingEdges();
		Edge<K> inEdge = new Edge<>(sourceNodeKey);
		inEdgeList.addLast(inEdge);
	}

	@Override
	public void createEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			createEdge(sourceNodeKey,key);
		}
	}

	@Override
	public void removeEdge(K sourceNodeKey, K targetNodeKey) {
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new Edge<>(targetNodeKey));
		
		UnDirectedNode<V, K> reverseSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> reverseEdgeList = reverseSourceNode.getOutGoingEdges();
		reverseEdgeList.removeElement(new Edge<>(targetNodeKey));
	}

	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			removeEdge(sourceNodeKey,key);
		}
	}

	@Override
	public void removeAllEdges(K sourceNodeKey) {
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		for(Edge<K> edge:sourceNode.getOutGoingEdges()) {
			removeEdge(sourceNodeKey,edge.getKeyPointingNode());
		}
	}

	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		List<K> keyList= new ArrayList<>();
		LinkedList<Edge<K>> edgeList= storage.get(sourceNodeKey).getOutGoingEdges();
		for(Edge<K> edge:edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;
	}

	@Override
	public void resetAllNodes() {
		// TODO Auto-generated method stub
		
	}

}
