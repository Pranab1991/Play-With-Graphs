package com.pranab.playwithgraphs.unweightedgraphs.directed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.Stack;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

/**
 * An adjacency list implementation of the Unweighed Directed graph.
 * A directed graph is graph, i.e., a set of objects (called vertices or nodes) that are connected together, where all the edges are directed from one vertex to another
 * Graphs realization can be achieved through matrix or adjacency list.
 * HashMap is used as an internal storage unit allowing unique key to identify each Vertex.
 * Vertex is an instance of DirectedNode which encapsulates the value provided.
 * @author Pranab Bharadwaj
 *
 * @param <V> - Value object that is encapsulated with DirectedNode to create a vertex
 * @param <K> - Uniquely identify the new Vertex created.
 */
public class AdjencyListDirectedGraph<V, K> implements DirectedGraph<V, K> {

	Map<K, DirectedNode<V, K>> storage = new HashMap<>();

	/**
	 * Returns the number of nodes in the graph<br>
	 * Time Complexity : O(1)
	 * 
	 * @return integer value depicting the number of nodes currently present in
	 *         graph
	 */
	@Override
	public int size() {
		return storage.size();
	}

	/**
	 * The procedure creates Node/Vertex identified by a Unique Key in the
	 * graph.<br>
	 * Time Complexity : O(1)
	 * 
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value needs to be encapsulated in Node/Vertex
	 */
	@Override
	public void createNode(K key, V value) {
		DirectedNode<V, K> node = new DirectedNode<>(value);
		storage.put(key, node);
	}

	/**
	 * The procedure removes Node/Vertex from the graph.<br>
	 * Time Complexity : O(1)
	 * 
	 * @param key - An unique identifier for a Vertex/Node
	 * @return The Entity whose value is encapsulated within that Node/Vertex.
	 */
	@Override
	public V removeNode(K key) {
		DirectedNode<V, K> node = storage.remove(key);
		return node.getValue();
	}

	/**
	 * The procedure updates Entity in the Node/Vertex identified by the key.<br>
	 * Time Complexity : O(1)
	 * 
	 * @param key   - An unique identifier for a Vertex/Node
	 * @param value - The Entity whose value will be updated in the Node/Vertex
	 *              identified by the key
	 */
	@Override
	public void updateNode(K key, V value) {
		DirectedNode<V, K> node = storage.get(key);
		node.setValue(value);
		storage.put(key, node);
	}

	/**
	 * Get the Entity of the Node/Vertex identified by the Key Time Complexity :
	 * O(1)
	 * 
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
	 * Returns all the target keys of the edges whose source is from the node
	 * identified by the provided key <br>
	 * Time Complexity : O(n) where n - is the number of edges from source node.
	 * 
	 * @param sourceNodeKey - The key for source node
	 * @return List of the target keys
	 */
	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		List<K> keyList = new ArrayList<>();
		LinkedList<Edge<K>> edgeList = storage.get(sourceNodeKey).getOutGoingEdges();
		for (Edge<K> edge : edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;
	}

	/**
	 * creates an unweighed edge between the specified Nodes.<br>
	 * The implementation updates the outgoing edges of source node and the incoming
	 * edges of target node<br>
	 * Time complexity : O(1)
	 * 
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 */
	@Override
	public void createEdge(K sourceNodeKey, K targetNodeKey) {
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
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

	/**
	 * creates edges between the provided node and multiple target nodes<br>
	 * Time complexity : O(n) where n - is the size of List of target keys
	 * @param sourceNodeKey   - The unique identifier(key) of source node
	 * @param targetNodeKeys- The list of unique identifiers(keys) of target nodes
	 */
	@Override
	public void createEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			createEdge(sourceNodeKey, key);
		}
	}

	/**
	 * Removes the edge between source and target node identified by respective keys
	 * The implementation removes from both the outgoing edges of source node and
	 * the incoming edges of target node<br>
	 * Time complexity : O(1)
	 * @param sourceNodeKey - The key for source node
	 * @param targetNodeKey - The key for target node
	 */
	@Override
	public void removeEdge(K sourceNodeKey, K targetNodeKey) {
		if ((!storage.containsKey(targetNodeKey)) || (!storage.containsKey(sourceNodeKey))) {
			throw new UnsupportedOperationException("Key not found");
		}
		DirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new Edge<>(targetNodeKey));

		DirectedNode<V, K> inSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> inEdgeList = inSourceNode.getInComingEdges();
		inEdgeList.removeElement(new Edge<>(sourceNodeKey));
	}

	/**
	 * Removes the edge between source and multiple target node identified by
	 * respective keys <br>
	 * Time complexity : O(n) where n - is the size of List of target keys
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
	 * Removes all the edges of a source node <br>
	 * Time complexity : O(n) where n - is the number of nodes associated
	 * @param sourceNodeKey - The key for source node
	 */
	@Override
	public void removeAllEdges(K sourceNodeKey) {
		DirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		for (Edge<K> edge : sourceNode.getOutGoingEdges()) {
			removeEdge(sourceNodeKey, edge.getKeyPointingNode());
		}
	}

	/**
	 * resets all the node's states in a graph<br>
	 * Time complexity : O(n) - n equals size of storage
	 */
	@Override
	public void resetAllNodes() {
		for (DirectedNode<V, K> node : storage.values()) {
			node.setTraversed(false);
			node.setLevel(0);
			node.setPrevPointer(null);
		}
	}

	/**
	 * provides a level wise search from the source node provided.<br>
	 * Level 1 - returns all the nodes directly linked with source node.<br>
	 * Level 2 - returns all the nodes directly linked to the nodes returned in
	 * Level 1.<br>
	 * The implementation basically does a Breadth First Search.<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * 
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

	/**
	 * Finds the shortest path between two given Nodes/Vertex.<br>
	 * Does a Breadth First Search while remembering the pointers from which the
	 * node was arrived to<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * 
	 * @param startingKeyPoint - the node which acts as the source node or the
	 *                         starting point
	 * @param targetKeyPoint   - the target node to which the path needs to be
	 *                         identified
	 * @return list of all the nodes that make up the path to the targeted node.
	 */
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
		Stack<DirectedNode<V, K>> stack = new DynamicList<>();
		Set<K> set=new HashSet<>();
		boolean result = false;
		for (K key : storage.keySet()) {
			result = checkCycle(key, stack,set);
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
	private boolean checkCycle(K startingKeyPoint, Stack<DirectedNode<V, K>> stack, Set<K> recStack) {
		DirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		if(recStack.contains(startingKeyPoint)) {
			return true;
		}
		if (sourceNode.isTraversed()) {
			return false;
		}
		sourceNode.setTraversed(true);
		recStack.add(startingKeyPoint);
		stack.push(sourceNode);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
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
	/*private boolean checkCycle(K startingKeyPoint, Stack<DirectedNode<V, K>> stack) {
		DirectedNode<V, K> sourceNode = storage.get(startingKeyPoint);
		if (sourceNode.isTraversed()) {
			return true;
		}
		sourceNode.setTraversed(true);
		stack.push(sourceNode);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
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
	 * A topological sort or topological ordering of a directed graph is a linear
	 * ordering of its vertices such that for every directed edge uv from vertex u
	 * to vertex v, u comes before v in the ordering<br>
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
		DirectedNode<V, K> sourceNode = storage.get(lookUpKey);
		if (sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		for (Edge<K> edge : edgeList) {
			doDepthFirstSearch(edge.getKeyPointingNode(), list);
		}
		list.add(lookUpKey);
	}

	/**
	 * Identifies all the strongly connected components in a given graph.<br>
	 * The algorithm implemented is Kosaraju’s algorithm which is basically running
	 * DFS twice<br>
	 * once on the given graph followed by running the same on reversed graph<br>
	 * Time complexity : O(V+E) V- vertices E- edges
	 * 
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
		DirectedNode<V, K> sourceNode = storage.get(lookUpKey);
		if (sourceNode.isTraversed()) {
			return;
		}
		sourceNode.setTraversed(true);
		LinkedList<Edge<K>> edgeList = sourceNode.getInComingEdges();
		for (Edge<K> edge : edgeList) {
			doDepthFirstSearchOnTransposeeGraph(edge.getKeyPointingNode(), stack);
		}
		stack.push(lookUpKey);
	}
}