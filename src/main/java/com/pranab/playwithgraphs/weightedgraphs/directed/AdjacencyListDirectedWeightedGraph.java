package com.pranab.playwithgraphs.weightedgraphs.directed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.MinPriorityHeap;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.Stack;
import com.pranab.playwithgraphs.datastructure.implementation.ArrayMinPriorityHeap;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;
import com.pranab.playwithgraphs.unweightedgraphs.directed.DirectedNode;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedEdge;

/**
 * An adjacency list implementation of the weighed Directed graph.
 * A directed weighed graph is graph, i.e., a set of objects (called vertices or nodes) that are connected together, where all the edges are directed from one vertex to another with varying edge lengths.
 * Graphs realization can be achieved through matrix or adjacency list.
 * HashMap is used as an internal storage unit allowing unique key to identify each Vertex.
 * Vertex is an instance of DirectedWeightedNode which encapsulates the value provided.
 * @author Pranab Bharadwaj
 *
 * @param <V> - Value object that is encapsulated with DirectedWeightedNode to create a vertex
 * @param <K> - Uniquely identify the new Vertex created.
 * @param <W> -  An entity that implements Weight so as to simulate strength of relationship as integer values.  
 */
public class AdjacencyListDirectedWeightedGraph<V, K, W extends Weight> implements DirectedWeightedGraph<V, K, W> {

	Map<K, DirectedWeightedNode<V, K, W>> storage = new HashMap<>();

	/**
	 * The procedure creates Node/Vertex identified by a Unique Key in the graph.<br>
	 * Time Complexity : O(1)
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value needs to be encapsulated in Node/Vertex
	 */
	@Override
	public void createNode(K key, V value) {
		DirectedWeightedNode<V, K, W> node = new DirectedWeightedNode<>(value);
		storage.put(key, node);
	}

	/**
	 * The procedure removes Node/Vertex from the graph.<br>
	 * Time Complexity : O(1)
	 * @param key - An unique identifier for a Vertex/Node
	 * @return The Entity whose value is encapsulated within that Node/Vertex.
	 */
	@Override
	public V removeNode(K key) {
		DirectedWeightedNode<V, K, W> node = storage.remove(key);
		return node.getValue();
	}

	/**
	 * The procedure updates Entity in the Node/Vertex identified by the key.<br>
	 * Time Complexity : O(1)
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value will be updated in the Node/Vertex
	 *              identified by the key
	 */
	@Override
	public void updateNode(K key, V value) {
		DirectedWeightedNode<V, K, W> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	/**
	 * Get the Entity of the Node/Vertex identified by the Key<br>
	 * Time Complexity : O(1)
	 * @param key - An unique identifier for a Vertex/Node
	 * @return The Entity whose value is encapsulated within that Node/Vertex.
	 */
	@Override
	public V getValue(K key) {
		if (storage.containsKey(key)) {
			return storage.get(key).getValue();
		} else {
			return null;
		}
	}

	/**
	 * creates an weighed edge between the specified Nodes.<br>
	 * Time Complexity : O(1)
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 * @param edgeWeight    - The weight that simulates the strength of
	 *                      relationship.
	 */
	@Override
	public void createEdge(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if (edgeWeight == null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		WeightedEdge<K, W> edge = new WeightedEdge<>(targetNodeKey, edgeWeight);
		edgeList.addLast(edge);

		DirectedWeightedNode<V, K, W> inSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> inEdgeList = inSourceNode.getInComingEdges();
		WeightedEdge<K, W> inEdge = new WeightedEdge<>(sourceNodeKey, edgeWeight);
		inEdgeList.addLast(inEdge);
	}

	/**
	 * creates edges between the provided node and multiple target nodes<br>
	 * Time Complexity : O(n) where n - is the size of List of target keys
	 * @param sourceNodeKey          - The unique identifier(key) of source node
	 * @param targetNodeKeyWeightMap - a map of target key as key and weight as
	 *                               value.
	 */
	@Override
	public void createEdges(K sourceNodeKey, Map<K, W> targetNodeKeyWeightMap) {
		for (Map.Entry<K, W> entry : targetNodeKeyWeightMap.entrySet()) {
			createEdge(sourceNodeKey, entry.getKey(), entry.getValue());
		}
	}

	/**
	 * updates the weight between two nodes<br>
	 * Time Complexity : O(n) where n - is the number of edges from source node.
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 * @param edgeWeight    - The new weight that simulates the strength of
	 *                      relationship.
	 */
	@Override
	public void updateEdgeWeight(K sourceNodeKey, K targetNodeKey, W edgeWeight) {
		if (edgeWeight == null) {
			throw new UnsupportedOperationException("Weight can't be null");
		}
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.functionalIterate(v -> {
			if (v.equals(targetNodeKey)) {
				v.setWeight(edgeWeight);
			}
		});

		DirectedWeightedNode<V, K, W> inSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> inEdgeList = inSourceNode.getInComingEdges();
		inEdgeList.functionalIterate(v -> {
			if (v.equals(sourceNodeKey)) {
				v.setWeight(edgeWeight);
			}
		});
	}

	/**
	 * Returns all the target keys of the edges whose source is from the node
	 * identified by the provided key<br>
	 * Time Complexity : O(n) where n - is the number of edges from source node.
	 * @param sourceNodeKey - The key for source node
	 * @return List of the target keys
	 */
	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		List<K> keyList = new ArrayList<>();
		LinkedList<WeightedEdge<K, W>> edgeList = storage.get(sourceNodeKey).getOutGoingEdges();
		for (WeightedEdge<K, W> edge : edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;
	}

	/**
	 * Removes the edge between source and target node identified by respective keys<br>
	 * Time Complexity : O(n) where n - is the number of edges from source node.
	 * @param sourceNodeKey - The key for source node
	 * @param targetNodeKey - The key for target node
	 */
	@Override
	public void removeEdge(K sourceNodeKey, K targetNodeKey) {
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new WeightedEdge<>(targetNodeKey));

		DirectedWeightedNode<V, K, W> inSourceNode = storage.get(targetNodeKey);
		LinkedList<WeightedEdge<K, W>> inEdgeList = inSourceNode.getOutGoingEdges();
		inEdgeList.removeElement(new WeightedEdge<>(sourceNodeKey));
	}

	/**
	 * Removes the edge between source and multiple target node identified by
	 * respective keys<br>
	 * Time Complexity : O(mn) where m is number of targetNodeKeys and n is the length of edges associated with source.
	 * @param sourceNodeKey  - The key for source node
	 * @param targetNodeKeys - The keys for target node
	 */
	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			removeEdge(sourceNodeKey, key);
		}
	}

	/**
	 * Removes all the edges of a source node
	 *  Time Complexity : O(n power 2)
	 * @param sourceNodeKey - The key for source node
	 */
	@Override
	public void removeAllEdges(K sourceNodeKey) {
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(sourceNodeKey);
		for (WeightedEdge<K, W> edge : sourceNode.getOutGoingEdges()) {
			removeEdge(sourceNodeKey, edge.getKeyPointingNode());
		}
	}

	/**
	 * resets all the node's states in a graph
	 * Time complexity : O(n) - n equals size of storage
	 */
	@Override
	public void resetAllNodes() {
		for (DirectedWeightedNode<V, K, W> node : storage.values()) {
			node.setTraversed(false);
			node.setLevel(0);
			node.setPrevPointer(null);
			node.setScore(-1);
		}
	}

	/**
	 * Returns the number of nodes in the graph
	 * Time Complexity : O(1)
	 * @return integer value depicting the number of nodes currently present in
	 *         graph
	 */
	@Override
	public int size() {
		return storage.size();
	}

	/**
	 * provides a level wise search from the source node provided.<br>
	 * Level 1 - returns all the nodes directly linked with source node.<br>
	 * Level 2 - returns all the nodes directly linked to the nodes returned in
	 * Level 1.<br>
	 * The implementation basically does a Breadth First Search.<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * @param startingKeyPoint   - the node which acts as the source node or the
	 *                           starting point of search
	 * @param searchLevel        - integer value emphasizing the level from the
	 *                           source node which needs to be searched.
	 * @param includeBeforeLevel - boolean value when true includes the previous
	 *                           level nodes in the result
	 * @return a list of keys of the Vertices present in that level Or the list of
	 *         keys till that level depending on includeBeforeLevel variable value
	 */
	@Override
	public List<V> searchLevel(K startingKeyPoint, int searchLevel, boolean includeBeforeLevel) {
		int level = 0;
		List<V> outputList = new ArrayList<>();
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(startingKeyPoint);
		sourceNode.setTraversed(true);
		sourceNode.setLevel(0);
		Queue<DirectedWeightedNode<V, K, W>> queue = new DynamicList<>();
		queue.enqueue(sourceNode);
		while ((!queue.isEmpty()) && level <= searchLevel) {
			DirectedWeightedNode<V, K, W> baseNode = queue.dequeue();
			level = (baseNode.getLevel() + 1);
			for (Edge<K> edge : baseNode.getOutGoingEdges()) {
				DirectedWeightedNode<V, K, W> extractedNode = storage.get(edge.getKeyPointingNode());
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

	/**
	 * finds the shortest path between two given Nodes/Vertex<br>
	 * Dijkstra's algorithm implementation using min priority queue.
	 * Time Complexity : O(ElogV) V- vertices E- edges.
	 * However the implementation as of now isn't providing an tight upper bound as there is a call to minheap's getindex which runs with time complexity of O(n).<br>
	 * Tuning in progress
	 * @param startingKeyPoint - the node which acts as the source node or the
	 *                         starting point
	 * @param targetKeyPoint   - the target node to which the path needs to be
	 *                         identified
	 * @return list of all the nodes that make up the path to the targeted node.
	 */
	@Override
	public java.util.Queue<K> searchSortestPath(K startingKeyPoint, K targetKeyPoint) {
		MinPriorityHeap<Integer, K> minHeap = new ArrayMinPriorityHeap<>();
		DirectedWeightedNode<V, K, W> node = storage.get(startingKeyPoint);
		node.setScore(0);
		minHeap.insert(0, startingKeyPoint);
		while (minHeap.size() != 0) {
			K key = minHeap.extractMin();			
			DirectedWeightedNode<V, K, W> minNode = storage.get(key);
			minNode.setTraversed(true);
			if(key.equals(targetKeyPoint)) {
				break;
			}
			int nodeWeight = minNode.getScore();
			for (WeightedEdge<K, W> edge : minNode.getOutGoingEdges()) {
				DirectedWeightedNode<V, K, W> toBeProcessed = storage.get(edge.getKeyPointingNode());
				if (!toBeProcessed.isTraversed()) {
					int score = nodeWeight + edge.getWeight().getWeight();
					if (toBeProcessed.getScore() == -1) {
						toBeProcessed.setPrevPointer(key);
						toBeProcessed.setScore(score);
						minHeap.insert(score, edge.getKeyPointingNode());
					} else if (score < toBeProcessed.getScore()) {
						int indexKey = toBeProcessed.getScore();
						toBeProcessed.setPrevPointer(key);
						toBeProcessed.setScore(score);
						minHeap.increasePriority(minHeap.getIndex(indexKey,edge.getKeyPointingNode()), score);
					}
				}
			}
		}
		java.util.Queue<K> output = new java.util.LinkedList<>();
		DirectedWeightedNode<V, K, W> targetNode = storage.get(targetKeyPoint);
		output.add(targetKeyPoint);
		while (targetNode.getPrevPointer() != null) {
			output.add(targetNode.getPrevPointer());
			targetNode = storage.get(targetNode.getPrevPointer());
		}
		resetAllNodes();
		return output;
	}

	@Override
	public boolean checkCycle() {
		Stack<DirectedWeightedNode<V, K, W>> stack = new DynamicList<>();
		Set<K> set=new HashSet<>();
		boolean result = false;
		for (K key : storage.keySet()) {
			result = checkCycle(key, stack, set);
			if (result) {
				break;
			}
		}
		resetAllNodes();
		return result;
	}

	/**
	 * Checks weather there is a cycle in the provided graph.<br>
	 * Example : A -&lt; B -&lt; C -&lt; A contains a cycle <br>
	 * Time Complexity - : O(V+E) V- vertices E- edges
	 * 
	 * @return boolean value when true,the graph contains a cycle
	 */
	private boolean checkCycle(K startingKeyPoint, Stack<DirectedWeightedNode<V, K, W>> stack, Set<K> recStack) {
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(startingKeyPoint);
		if(recStack.contains(startingKeyPoint)) {
			return true;
		}
		if (sourceNode.isTraversed()) {
			return false;
		}
		sourceNode.setTraversed(true);
		recStack.add(startingKeyPoint);
		stack.push(sourceNode);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		boolean result = false;
		for (Edge<K> edge : edgeList) {
			result = checkCycle(edge.getKeyPointingNode(), stack,recStack);
			if (result) {
				return result;
			}
		}
		recStack.remove(startingKeyPoint);
		stack.pop();
		return result;
	}
	
	//has a higher running time
	/*private boolean checkCycle(K startingKeyPoint, Stack<DirectedWeightedNode<V, K, W>> stack) {
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(startingKeyPoint);
		if (sourceNode.isTraversed()) {
			return true;
		}
		sourceNode.setTraversed(true);
		stack.push(sourceNode);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		boolean result = false;
		for (Edge<K> edge : edgeList) {
			result = checkCycle(edge.getKeyPointingNode(), stack);
			if (result) {
				return result;
			}
		}
		stack.pop().setTraversed(false);
		return result;
	}*/


	/**
	 * does a topologically sorting of given graph.<br>
	 * A topological sort or topological ordering of a directed
	 * graph is a linear ordering of its vertices such that for every directed edge
	 * uv from vertex u to vertex v, u comes before v in the ordering<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * 
	 * @return list of Nodes/Vertex keys, topologically sorted
	 */
	@Override
	public List<K> getTopologicalOrdered() {
		if (checkCycle()) {
			throw new UnsupportedOperationException("The graph contains a cycle");
		}
		List<K> list = new ArrayList<>();
		for (K key : storage.keySet()) {
			doDepthFirstSearch(key, list);
		}
		resetAllNodes();
		Collections.reverse(list);
		return list;
	}

	private void doDepthFirstSearch(K lookUpKey, List<K> list) {
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(lookUpKey);
		if (sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getOutGoingEdges();
		for (Edge<K> edge : edgeList) {
			doDepthFirstSearch(edge.getKeyPointingNode(), list);
		}
		list.add(lookUpKey);
	}

	/**
	 Identifies all the strongly connected components in a given graph.<br>
	 * The algorithm implemented is Kosaraju’s algorithm which is basically running
	 * DFS twice<br>
	 * once on the given graph followed by running the same on reversed graph<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * @return List of strongly connected component nodes list.
	 */
	@Override
	public List<List<K>> getStrongConnectedComponent() {
		List<List<K>> connectedComponentLists = new ArrayList<>();
		Stack<K> stack = new DynamicList<>();
		for (K key : storage.keySet()) {
			doDepthFirstSearchOnTransposeeGraph(key, stack);
		}
		resetAllNodes();
		while (!stack.isEmpty()) {
			List<K> connectedComponentList = new ArrayList<>();
			doDepthFirstSearch(stack.pop(), connectedComponentList);
			if (!connectedComponentList.isEmpty()) {
				connectedComponentLists.add(connectedComponentList);
			}
		}
		resetAllNodes();
		return connectedComponentLists;
	}

	private void doDepthFirstSearchOnTransposeeGraph(K lookUpKey, Stack<K> stack) {
		DirectedWeightedNode<V, K, W> sourceNode = storage.get(lookUpKey);
		if (sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<WeightedEdge<K, W>> edgeList = sourceNode.getInComingEdges();
		for (Edge<K> edge : edgeList) {
			doDepthFirstSearchOnTransposeeGraph(edge.getKeyPointingNode(), stack);
		}
		stack.push(lookUpKey);
	}

}
