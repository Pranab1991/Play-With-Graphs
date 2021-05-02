package com.pranab.playwithgraphs.unweightedgraphs.directed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.Stack;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

public class AdjencyListDirectedGraph<V, K> implements DirectedGraph<V, K> {

	Map<K, DirectedNode<V, K>> storage = new HashMap<>();	

	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public void createNode(K key, V value) {
		DirectedNode<V, K> node = new DirectedNode<>(value);
		storage.put(key, node);
	}

	@Override
	public V removeNode(K key) {
		DirectedNode<V, K> node = storage.remove(key);
		return node.getValue();
	}

	@Override
	public void updateNode(K key, V value) {
		DirectedNode<V, K> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	@Override
	public V getValue(K key) {
		return storage.get(key).getValue();
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
	public void createEdge(K sourceNodeKey, K targetNodeKey) {
		if((!storage.containsKey(targetNodeKey))||(!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		Edge<K> edge = new Edge<>(targetNodeKey);
		edgeList.addLast(edge);
		
		DirectedNode<V, K> inSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> inEdgeList = inSourceNode.getInComingEdges();
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
		DirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new Edge<>(targetNodeKey));
	}

	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			removeEdge(sourceNodeKey,key);
		}
	}

	@Override
	public void removeAllEdges(K sourceNodeKey) {
		DirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		sourceNode.getOutGoingEdges().clear();
	}

	@Override
	public void resetAllNodes() {
		for (DirectedNode<V, K> node : storage.values()) {
			node.setTraversed(false);
			node.setLevel(0);
			node.setPrevPointer(null);
		}
	}

	@Override
	public List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel) {
		int level = 0;
		List<V> outputList = new ArrayList<>();
		DirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		sourceNode.setLevel(0);
		Queue<DirectedNode<V, K>> queue = new DynamicList<>();
		queue.enqueue(sourceNode);
		while ((!queue.isEmpty()) && level <= searchLevel) {
			DirectedNode<V, K> baseNode = queue.dequeue();
			level = (baseNode.getLevel() + 1);
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				DirectedNode<V, K> extractedNode = storage.get(edge.getKeyPointingNode());
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
		DirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		Queue<DirectedNode<V, K>> queue = new DynamicList<>();
		Queue<K> keyQueue = new DynamicList<>();
		queue.enqueue(sourceNode);
		keyQueue.enqueue(startingKeyPoint);
		outerPoint: while ((!queue.isEmpty())) {
			DirectedNode<V, K> baseNode = queue.dequeue();
			K baseKey = keyQueue.dequeue();
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				K extractedKey = edge.getKeyPointingNode();
				DirectedNode<V, K> extractedNode = storage.get(extractedKey);
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
		DirectedNode<V, K> temp = storage.get(targetKeyPoint);
		while (temp.getPrevPointer() != null) {
			outputList.offer(temp.getPrevPointer());
			temp = storage.get(temp.getPrevPointer());
		}
		resetAllNodes();
		return outputList;
	}
	
	@Override
	public boolean checkCycle() {
		Stack<DirectedNode<V, K>> stack=new DynamicList<>();
		boolean result=false;
		for(K key:storage.keySet()) { 
			result=checkCycle(key,stack);
			if(result) {
				break;
			}
		}
		resetAllNodes();
		return result;
	}
	
	private boolean checkCycle(K startingKeyPoint,Stack<DirectedNode<V, K>> stack) {
		DirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		if(sourceNode.isTraversed()) {
			return true;
		}
		sourceNode.setTraversed(true);
		stack.push(sourceNode);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		boolean result=false;
		for (Edge<K> edge : edgeList) {
			result=checkCycle(edge.getKeyPointingNode(),stack);
			if(result) {
				return result;
			}
		}
		stack.pop().setTraversed(false);
		return result;
	}

	@Override
	public List<K> getTopologicalOrdered() {
		if(checkCycle()) {
			throw new UnsupportedOperationException("The graph contains a cycle");
		}
		List<K> list=new ArrayList<>();
		for(K key:storage.keySet()) {
			doDepthFirstSearch(key,list);
		}
		resetAllNodes();
		Collections.reverse(list);
		return list;
	}
	
	
	private void doDepthFirstSearch(K lookUpKey,List<K> list) {
		DirectedNode<V, K> sourceNode=storage.get(lookUpKey);
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
	
	@Override
	public List<List<K>> getStrongConnectedComponent(){
		List<List<K>> connectedComponentLists=new ArrayList<>();
		Stack<K> stack=new DynamicList<>();
		for(K key:storage.keySet()) {
			doDepthFirstSearchOnTransposeeGraph(key,stack);
		}
		resetAllNodes();
		while(!stack.isEmpty()) {
			List<K> connectedComponentList=new ArrayList<>();
			doDepthFirstSearch(stack.pop(),connectedComponentList);
			if(!connectedComponentList.isEmpty()) {
				connectedComponentLists.add(connectedComponentList);
			}
		}
		resetAllNodes();
		return connectedComponentLists;
	}
	
	
	private void doDepthFirstSearchOnTransposeeGraph(K lookUpKey,Stack<K> stack) {
		DirectedNode<V, K> sourceNode=storage.get(lookUpKey);
		if(sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<Edge<K>> edgeList = sourceNode.getInComingEdges();
		for(Edge<K> edge:edgeList) {
			doDepthFirstSearchOnTransposeeGraph(edge.getKeyPointingNode(),stack);
		}
		stack.push(lookUpKey);
	}
}