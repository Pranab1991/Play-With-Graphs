package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

/**
 * An adjacency list implementation of the Unweighed Undirected graph.
 * An undirected graph is graph, i.e., a set of objects (called vertices or nodes) that are connected together, where all the edges are bidirectional.
 * This is realized by creating two edge between the source and target node,directed to each other.
 * Graphs realization can be achieved through matrix or adjacency list.
 * HashMap is used as an internal storage unit allowing unique key to identify each Vertex.
 * Vertex is an instance of UnDirectedNode which encapsulates the value provided.
 * @author Pranab Bharadwaj
 *
 * @param <V> - Value object that is encapsulated with UnDirectedNode to create a vertex
 * @param <K> - Uniquely identify the new Vertex created.
 */
public class AdjencyListUnDirectedGraph<V, K> implements UnDirectedGraph<V, K> {

	Map<K, UnDirectedNode<V, K>> storage = new HashMap<>();

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
		UnDirectedNode<V, K> node = new UnDirectedNode<>(value);
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
		UnDirectedNode<V, K> node = storage.remove(key);
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
		UnDirectedNode<V, K> node = storage.get(key);
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
		if(storage.containsKey(key)) {
			return storage.get(key).getValue();
		}else {
			return null;
		}
	}

	/**
	 * creates an unweighed edge between the specified Nodes.<br>
	 * The implementation updates the outgoing edges of source node and the outgoing
	 * edges of target node<br>
	 * Time complexity : O(1)
	 * 
	 * @param sourceNodeKey - The unique identifier(key) of source node
	 * @param targetNodeKey - The unique identifier(key) of target node
	 */
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

	/**
	 * creates edges between the provided node and multiple target nodes
	 * Time complexity : O(n) where n - is the size of List of target keys
	 * @param sourceNodeKey   - The unique identifier(key) of source node
	 * @param targetNodeKeys- The list of unique identifiers(keys) of target nodes
	 */
	@Override
	public void createEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			createEdge(sourceNodeKey,key);
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
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		LinkedList<Edge<K>> edgeList = sourceNode.getOutGoingEdges();
		edgeList.removeElement(new Edge<>(targetNodeKey));
		
		UnDirectedNode<V, K> reverseSourceNode = storage.get(targetNodeKey);
		LinkedList<Edge<K>> reverseEdgeList = reverseSourceNode.getOutGoingEdges();
		reverseEdgeList.removeElement(new Edge<>(sourceNodeKey));
	}


	/**
	 * Removes the edge between source and multiple target node identified by
	 * respective keys
	 * Time complexity : O(n) where n - is the size of List of target keys
	 * @param sourceNodeKey  - The key for source node
	 * @param targetNodeKeys - The keys for target node
	 */
	@Override
	public void removeEdges(K sourceNodeKey, List<K> targetNodeKeys) {
		for (K key : targetNodeKeys) {
			removeEdge(sourceNodeKey,key);
		}
	}

	/**
	 * Removes all the edges of a source node
	 * Time complexity : O(n) where n - is the number of nodes associated 
	 * @param sourceNodeKey - The key for source node
	 */
	@Override
	public void removeAllEdges(K sourceNodeKey) {
		UnDirectedNode<V, K> sourceNode = storage.get(sourceNodeKey);
		for(Edge<K> edge:sourceNode.getOutGoingEdges()) {
			removeEdge(sourceNodeKey,edge.getKeyPointingNode());
		}
	}

	/**
	 * Returns all the target keys of the edges whose source is from the node
	 * identified by the provided key <br>
	 * Time Complexity : O(1)
	 * 
	 * @param sourceNodeKey - The key for source node
	 * @return List of the target keys
	 */
	@Override
	public List<K> getAllEdgeKeys(K sourceNodeKey) {
		List<K> keyList= new ArrayList<>();
		LinkedList<Edge<K>> edgeList= storage.get(sourceNodeKey).getOutGoingEdges();
		for(Edge<K> edge:edgeList) {
			keyList.add(edge.getKeyPointingNode());
		}
		return keyList;
	}

	/**
	 * resets all the node's states in a graph<br>
	 * Time complexity : O(1)
	 */
	@Override
	public void resetAllNodes() {
		for (UnDirectedNode<V, K> node : storage.values()) {
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
	/**
	 * finds forests in graph if any
	 *  Time complexity : O(V+E) V- vertices E- edges
	 * @return list of forests found
	 */
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
