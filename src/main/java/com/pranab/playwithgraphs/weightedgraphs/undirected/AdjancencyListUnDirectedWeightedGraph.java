package com.pranab.playwithgraphs.weightedgraphs.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.MinPriorityHeap;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.implementation.ArrayMinPriorityHeap;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedEdge;

public class AdjancencyListUnDirectedWeightedGraph<V, K, W extends Weight> implements UnDirectedWeightedGraph<V, K, W> {

	Map<K, UnDirectedWeightedNode<V, K, W>> storage = new HashMap<>();
	
	@Override
	public void createNode(K key, V value) {
		UnDirectedWeightedNode<V, K, W> node = new UnDirectedWeightedNode<>(value);
		storage.put(key, node);
	}
	
	
	@Override
	public V removeNode(K key) {
		UnDirectedWeightedNode<V, K, W> node = storage.remove(key);
		return node.getValue();
	}

	@Override
	public void updateNode(K key, V value) {
		UnDirectedWeightedNode<V, K, W> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	@Override
	public V getValue(K key) {
		if (storage.containsKey(key)) {
			return storage.get(key).getValue();
		} else {
			return null;
		}
	}
	
	@Override
	public void createEdge(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if (edgeWeight == null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		UnDirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		WeightedEdge<K, W> edge = new WeightedEdge<>(targetNodeKey, edgeWeight);
		edgeList.addLast(edge);
		
		UnDirectedWeightedNode<V, K, W> revSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> revEdgeList = revSourceNode.getOutGoingEdges();
		WeightedEdge<K, W> revEdge = new WeightedEdge<>(sourceNodeKey, edgeWeight);
		revEdgeList.addLast(revEdge);

	}

	@Override
	public void createEdges(K sourceNodeKey, Map<K, W> targetNodeKeyWeightMap) {
		for (Map.Entry<K, W> entry : targetNodeKeyWeightMap.entrySet()) {
			createEdge(sourceNodeKey, entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void updateEdgeWeight(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if (edgeWeight == null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		UnDirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.functionalIterate(v -> {
			if (v.equals(targetNodeKey)) {
				v.setWeights(edgeWeight);
			}
		});

		UnDirectedWeightedNode<V, K, W> revSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> revEdgeList = revSourceNode.getOutGoingEdges();
		revEdgeList.functionalIterate(v -> {
			if (v.equals(sourceNodeKey)) {
				v.setWeights(edgeWeight);
			}
		});
	}

	
	@Override
	public int size() {
		return storage.size();
	}

	
	@Override
	public void removeEdge(K sourceNodeKey, K targetNodeKey) {
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		UnDirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new WeightedEdge<>(targetNodeKey));
		
		UnDirectedWeightedNode<V, K, W> revSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> revEdgeList = revSourceNode.getOutGoingEdges();
		revEdgeList.removeElement(new WeightedEdge<>(sourceNodeKey));
	}

	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			removeEdge(sourceNodeKey, key);
		}
	}

	@Override
	public void removeAllEdges(K sourceNodeKey) {
		UnDirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		for(Edge<K> edge:sourceNode.getOutGoingEdges()) {
			removeEdge(sourceNodeKey,edge.getKeyPointingNode());
		}
	}
	
	@Override
	public void resetAllNodes() {
		for (UnDirectedWeightedNode<V, K, W> node : storage.values()) {
			node.setTraversed(false);
			node.setLevel(0);
			node.setPrevPointer(null);
			node.setScore(-1);
		}
	}


	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		List<K> keyList = new ArrayList<>();
		LinkedList<WeightedEdge<K, W>> edgeList = storage.get(sourceNodeKey).getOutGoingEdges();
		for (WeightedEdge<K, W> edge : edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;
	}

	
	@Override
	public List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel) {
		int level = 0;
		List<V> outputList = new ArrayList<>();
		UnDirectedWeightedNode<V, K, W> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		sourceNode.setLevel(0);
		Queue<UnDirectedWeightedNode<V, K, W>> queue = new DynamicList<>();
		queue.enqueue(sourceNode);
		while ((!queue.isEmpty()) && level <= searchLevel) {
			UnDirectedWeightedNode<V, K, W> baseNode = queue.dequeue();
			level = (baseNode.getLevel() + 1);
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				UnDirectedWeightedNode<V, K, W> extractedNode = storage.get(edge.getKeyPointingNode());
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
		MinPriorityHeap<Integer, K> minHeap = new ArrayMinPriorityHeap<>();
		UnDirectedWeightedNode<V, K, W> node = storage.get(startingKeyPoint);
		node.setScore(0);
		minHeap.insert(0, startingKeyPoint);
		while (minHeap.size() != 0) {
			K key = minHeap.extractMin();
			UnDirectedWeightedNode<V, K, W> minNode = storage.get(key);
			minNode.setTraversed(true);
			int nodeWeight = minNode.getScore();
			for (WeightedEdge<K, W> edge : minNode.getOutGoingEdges()) {
				UnDirectedWeightedNode<V, K, W> toBeProcessed = storage.get(edge.getKeyPointingNode());
				if (!toBeProcessed.isTraversed()) {
					int score = nodeWeight + edge.getWeights().getWeight();
					if (toBeProcessed.getScore() == -1) {
						toBeProcessed.setPrevPointer(key);
						toBeProcessed.setScore(score);
						minHeap.insert(score, edge.getKeyPointingNode());
					} else if (score < toBeProcessed.getScore()) {
						int indexKey = toBeProcessed.getScore();
						toBeProcessed.setPrevPointer(key);
						toBeProcessed.setScore(score);
						minHeap.increasePriority(minHeap.getIndex(indexKey), score);
					}
				}
			}
		}
		java.util.Queue<K> output=new java.util.LinkedList<>();
		UnDirectedWeightedNode<V, K, W> targetNode =storage.get(targetKeyPoint);
		output.add(targetKeyPoint);
		while(targetNode.getPrevPointer()!=null) {
			output.add(targetNode.getPrevPointer());
			targetNode=storage.get(targetNode.getPrevPointer());
		}
		resetAllNodes();
		return output;
	}


	@Override
	public List<List<K>> findClusters() {
		List<List<K>> clusterList=new ArrayList<>();
		for(K key:storage.keySet()) {
			UnDirectedWeightedNode<V, K, W> node=storage.get(key);
			if(!node.isTraversed()) {
				List<K> connectedComponentList=new ArrayList<>();
				doDepthFirstSearch(key,connectedComponentList);
				clusterList.add(connectedComponentList);
			}
		}
		resetAllNodes();
		return clusterList;
	}
	
	@Override
	public List<K> findClusters(Predicate<W> predicate) {
		List<K> connectedComponentList=null;
		for(K key:storage.keySet()) {
			UnDirectedWeightedNode<V, K, W> node=storage.get(key);
			if(!node.isTraversed()) {
				connectedComponentList=new ArrayList<>();
				doDepthFirstSearch(key,connectedComponentList);
				if(storage.get((connectedComponentList.get(0))).getOutGoingEdges().getFirst().isPresent()) {
					WeightedEdge<K, W> weight=storage.get((connectedComponentList.get(0))).getOutGoingEdges().getFirst().get();
					if(weight.qureyIfPresent(predicate)) {
						break;
					}else {
						connectedComponentList=null;
					}
				}
			}
		}
		resetAllNodes();
		return connectedComponentList;
	}

	private void doDepthFirstSearch(K lookUpKey,List<K> list) {
		UnDirectedWeightedNode<V, K, W> sourceNode=storage.get(lookUpKey);
		if(sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		for(Edge<K> edge:edgeList) {
			doDepthFirstSearch(edge.getKeyPointingNode(),list);
		}
		list.add(lookUpKey);
	}


	@Override
	public java.util.List<SpanningEdge<K>> minimumSpaningTree() {
		K startingKeyPoint=(K)storage.keySet().toArray()[0];
		MinPriorityHeap<Integer, K> minHeap = new ArrayMinPriorityHeap<>();
		minHeap.insert(0, startingKeyPoint);
		java.util.List<SpanningEdge<K>> output=new java.util.ArrayList<>();
		while (minHeap.size() != 0) {
			K key = minHeap.extractMin();
			UnDirectedWeightedNode<V, K, W> minNode = storage.get(key);
			output.add(new SpanningEdge<>(minNode.getPrevPointer(), key, minNode.getMstScoreHolder()));
			minNode.setTraversed(true);
			for (WeightedEdge<K,W> edge : minNode.getOutGoingEdges()) {
				UnDirectedWeightedNode<V, K, W> toBeProcessed = storage.get(edge.getKeyPointingNode());
				if (!toBeProcessed.isTraversed()) {
					int score = edge.getWeights().getWeight();
					if (toBeProcessed.getMstScoreHolder() == Integer.MAX_VALUE) {
						toBeProcessed.setMstScoreHolder(score);
						toBeProcessed.setPrevPointer(key);
						minHeap.insert(score, edge.getKeyPointingNode());
					} else if (score < toBeProcessed.getMstScoreHolder()) {
						int indexKey = toBeProcessed.getMstScoreHolder();
						toBeProcessed.setMstScoreHolder(score);
						toBeProcessed.setPrevPointer(key);
						minHeap.increasePriority(minHeap.getIndex(indexKey), score);
					}
				}
			}
		}
		resetAllNodes();
		output.get(0).setScore(0);
		return output;
	}

}
