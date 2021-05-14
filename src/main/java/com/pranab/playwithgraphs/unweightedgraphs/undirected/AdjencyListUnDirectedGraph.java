package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

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
		if(storage.containsKey(key)) {
			return storage.get(key).getValue();
		}else {
			return null;
		}
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
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new Edge<>(targetNodeKey));
		
		UnDirectedNode<V, K> reverseSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> reverseEdgeList = reverseSourceNode.getOutGoingEdges();
		reverseEdgeList.removeElement(new Edge<>(sourceNodeKey));
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
		for (UnDirectedNode<V, K> node : storage.values()) {
			node.setTraversed(false);
			node.setLevel(0);
			node.setPrevPointer(null);
		}
	}

	@Override
	public List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel) {
		int level = 0;
		List<V> outputList = new ArrayList<>();
		UnDirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		sourceNode.setLevel(0);
		Queue<UnDirectedNode<V, K>> queue = new DynamicList<>();
		queue.enqueue(sourceNode);
		while ((!queue.isEmpty()) && level <= searchLevel) {
			UnDirectedNode<V, K> baseNode = queue.dequeue();
			level = (baseNode.getLevel() + 1);
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				UnDirectedNode<V, K> extractedNode = storage.get(edge.getKeyPointingNode());
				if (!extractedNode.isTraversed()) {
					extractedNode.setTraversed(true);
					extractedNode.setLevel(level);
					queue.enqueue(extractedNode);
					if (includeBeforeLevel && level <= searchLevel) {
						outputList.add(extractedNode.getValue());
					} else {
						if (level == searchLevel) {
							outputList.add(extractedNode.getValue());
						}
					}
				}
			}
		}
		resetAllNodes();
		return outputList;
	}

	@Override
	public java.util.Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint) {
		java.util.Queue<K> outputList = new java.util.LinkedList<>();
		UnDirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		Queue<UnDirectedNode<V, K>> queue = new DynamicList<>();
		Queue<K> keyQueue = new DynamicList<>();
		queue.enqueue(sourceNode);
		keyQueue.enqueue(startingKeyPoint);
		outerPoint: while ((!queue.isEmpty())) {
			UnDirectedNode<V, K> baseNode = queue.dequeue();
			K baseKey = keyQueue.dequeue();
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				K extractedKey = edge.getKeyPointingNode();
				UnDirectedNode<V, K> extractedNode = storage.get(extractedKey);
				if (!extractedNode.isTraversed()) {
					extractedNode.setTraversed(true);
					extractedNode.setPrevPointer(baseKey);
					queue.enqueue(extractedNode);
					keyQueue.enqueue(extractedKey);
					if (extractedKey.equals(targetKeyPoint)) {
						outputList.add(targetKeyPoint);
						break outerPoint;
					}
				}
			}
		}
		UnDirectedNode<V, K> temp = storage.get(targetKeyPoint);
		while (temp.getPrevPointer() != null) {
			outputList.offer(temp.getPrevPointer());
			temp = storage.get(temp.getPrevPointer());
		}
		resetAllNodes();
		return outputList;
	}

	@Override
	public List<List<K>> findClusters() {
		List<List<K>> clusterList=new ArrayList<>();
		for(K key:storage.keySet()) {
			UnDirectedNode<V, K> node=storage.get(key);
			if(!node.isTraversed()) {
				List<K> connectedComponentList=new ArrayList<>();
				doDepthFirstSearch(key,connectedComponentList);
				clusterList.add(connectedComponentList);
			}
		}
		resetAllNodes();
		return clusterList;
	}

	private void doDepthFirstSearch(K lookUpKey,List<K> list) {
		UnDirectedNode<V, K> sourceNode=storage.get(lookUpKey);
		if(sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		for(Edge<K> edge:edgeList) {
			doDepthFirstSearch(edge.getKeyPointingNode(),list);
		}
		list.add(lookUpKey);
	}
}
