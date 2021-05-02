package com.pranab.playwithgraphs.weightedgraphs.directed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedEdge;

public class AdjacencyListDirectedWeightedGraph<V, K, W extends Weight> implements DirectedWeightedGraph<V, K, W> {

	Map<K, DirectedWeightedNode<V, K, W>> storage = new HashMap<>();

	@Override
	public void createNode(K key, V value) {
		DirectedWeightedNode<V, K, W> node = new DirectedWeightedNode<>(value);
		storage.put(key, node);
	}

	@Override
	public V removeNode(K key) {
		DirectedWeightedNode<V, K, W> node = storage.remove(key);
		return node.getValue();
	}

	@Override
	public void updateNode(K key, V value) {
		DirectedWeightedNode<V, K, W> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	@Override
	public V getValue(K key) {
		return storage.get(key).getValue();
	}

	@Override
	public void createEdge(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if(edgeWeight==null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if((!storage.containsKey(targetNodeKey))||(!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K,W>> edgeList = sourceNode.getOutGoingEdges();
		WeightedEdge<K,W> edge = new WeightedEdge<>(targetNodeKey,edgeWeight);
		edgeList.addLast(edge);
		
		DirectedWeightedNode<V, K, W> inSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K,W>> inEdgeList = inSourceNode.getInComingEdges();
		WeightedEdge<K,W> inEdge = new WeightedEdge<>(targetNodeKey,edgeWeight);
		inEdgeList.addLast(inEdge);
	}

	@Override
	public void createEdges(K sourceNodeKey, Map<K, W> targetNodeKeyWeightMap) {
		for(Map.Entry<K, W> entry:targetNodeKeyWeightMap.entrySet()) {
			createEdge(sourceNodeKey,entry.getKey(),entry.getValue());
		}
	}

	@Override
	public void updateEdgeWeight(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if(edgeWeight==null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if((!storage.containsKey(targetNodeKey))||(!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K,W>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.functionalIterate((v)->{if(v.equals(targetNodeKey)) {v.setWeights(edgeWeight);}});
		
		
		DirectedWeightedNode<V, K, W> inSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K,W>> inEdgeList = inSourceNode.getInComingEdges();
		inEdgeList.functionalIterate((v)->{if(v.equals(sourceNodeKey)) {v.setWeights(edgeWeight);}});
	}
	
	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		/*List<K> keyList= new ArrayList<>();
		LinkedList<WeightedEdge<K,W>> edgeList= storage.get(sourceNodeKey).getOutGoingEdges();
		for(Edge<K> edge:edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;*/
		return null;
	}
	
	@Override
	public void removeEdge(K sourceNodeKey, K targetNodeKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllEdges(K sourceNodeKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetAllNodes() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCycle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<K> getTopologicalOrdered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<K>> getStrongConnectedComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
