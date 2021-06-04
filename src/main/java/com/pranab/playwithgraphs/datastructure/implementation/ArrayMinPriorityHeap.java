package com.pranab.playwithgraphs.datastructure.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.MinPriorityHeap;

/**
 * The Object in the collection are prioritized on the basis of key provided
 * against the object being stored in the collection.
 * <p>
 * Heap : is a special Tree-based data structure in which the tree is a complete
 * binary tree
 * </p>
 * <p>
 * Min Heap : In a Min-Heap the key present at the root node must be minimum
 * among the keys present at all of it’s children. The same property must be
 * recursively true for all sub-trees in that Binary Tree.
 * <p>The implementation uses ArrayList as a storage block because of it's infinite capacity(basically bounded by environment memory).
 *  HeapNode is used as storage unit.HeapNode is not exposed to client, all operation are encapsulated through various methods.
 * </p>
 * <p>Instantiation :<br> MinPriorityHeap&lt;Integer,String&gt; minHeap=new ArrayMinPriorityHeap &lt;&gt;();<br>
 * 					  K= Integer, V=String that implies priorities are set by integer key used, and String values are stored.<br><br>
 *    Usage:<br> minHeap.insert(1,"One");<br>
 *    		 minHeap.insert(2,"Two");<br>
 *           String minval=minHeap.extractMin();
 *     </p>
 * @author Pranab Bharadwaj
 *
 * @param <K> - An comparable entity which is used to prioritize
 * @param <V> - The Value that needs to be saved in collection identified by
 *            unique keys.
 */
public class ArrayMinPriorityHeap<K extends Comparable<K>, V> implements MinPriorityHeap<K, V> {

	private List<HeapNode<K, V>> dataStore = new ArrayList<>();

	private int getParentIndex(int index) {
		if (index <= 0) {
			return 0;
		}
		return index - 1 >> 1;
	}

	private int getLeftChildIndex(int index) {
		if (index < 0) {
			throw new UnsupportedOperationException("Only works for positive integrals");
		}
		return (index << 1) + 1;
	}

	private int getRightChildIndex(int index) {
		if (index < 0) {
			throw new UnsupportedOperationException("Only works for positive integrals");
		}
		return (index << 1) + 2;
	}

	private void heapyfy(int index) {
		int heapSize = dataStore.size() - 1;
		HeapNode<K, V> node=dataStore.get(index);
		int leftIndex = getLeftChildIndex(index);
		if (leftIndex > heapSize) {
			return;
		}
		boolean indicator = false;

		HeapNode<K, V> leftChild = dataStore.get(leftIndex);
		HeapNode<K, V> minNode = null;
		if (leftChild.getKey().compareTo(node.getKey()) < 0) {
			minNode = leftChild;
		} else {
			minNode = node;
		}

		int rightIndex = getRightChildIndex(index);
		if (rightIndex <= heapSize) {
			HeapNode<K, V> rightChild = dataStore.get(rightIndex);
			if (rightChild.getKey().compareTo(minNode.getKey()) < 0) {
				minNode = rightChild;
				indicator = true;
			}
		}
		if (minNode != node) {
			if (indicator) {
				dataStore.set(rightIndex, node);
				dataStore.set(index, minNode);
				heapyfy(rightIndex);
			} else {
				dataStore.set(leftIndex, node);
				dataStore.set(index, minNode);
				heapyfy(leftIndex);
			}			
		}
	}

	/**
	 * Extracts the object identified by the key, having the least value.<br>
	 * Time complexity: O(logn)<br>
	 * Explanation: 
	 * removes the element from zeroth index with O(1)<br>
	 * last element is switched to zeroth index with O(1)<br>
	 * then heapyfy operation is triggered on zeroth index with O(logn)
	 * 
	 * @return the object associated with least key value. 
	 */
	@Override
	public V extractMin() {
		if (dataStore.isEmpty()) {
			throw new UnsupportedOperationException("Heap is Empity");
		}
		HeapNode<K, V> minNode = dataStore.get(0);
		HeapNode<K, V> newMeanNode = dataStore.remove(dataStore.size() - 1);
		if (!dataStore.isEmpty()) {
			dataStore.set(0, newMeanNode);
			heapyfy(0);
		}
		return minNode.getValue();
	}

	/**
	 * Increases the priority of an object by modifying it's key.The value of the provided key if larger than previous key value UnsupportedOperationException exception is thrown.
	 * Time Complexity: O(logn)<br>
	 * Explanation:
	 * Extracts item at the index, compares with existing key and inserts the new node with updated value at the index: O(1) <br>
	 * Compares with parent node and updates the parent until the new node's key is less than parent nodes key or new node is the root : O(logn) <br>
	 * 
	 * @param index  - current index of the key. Use getIndex(K key) to retrieve the same
	 * @param newKey - new value of the key with increased priority
	 */
	@Override
	public void increasePriority(int index, K newKey) {
		HeapNode<K, V> node = dataStore.get(index);
		if (newKey.compareTo(node.getKey()) > 0) {
			throw new UnsupportedOperationException("Key is larger than existing, won't increase priority");
		}
		HeapNode<K, V> newNode = new HeapNode<>(newKey,node.getValue());
		node=newNode;
		dataStore.set(index, newNode);
		int parentIndex = getParentIndex(index);
		HeapNode<K, V> parentNode = dataStore.get(parentIndex);
		while (index > 0 && node.getKey().compareTo(parentNode.getKey()) < 0) {
			HeapNode<K, V> temp = node;
			dataStore.set(index, parentNode);
			dataStore.set(parentIndex, temp);
			index = parentIndex;
			parentIndex = getParentIndex(parentIndex);
			node = dataStore.get(index);
			parentNode = dataStore.get(parentIndex);
		}
	}

	/**
	 * Inserts the object into the collection.<br>
	 * Time complexity : O(log n)<br>
	 * Explanation:<br>
	 * Inserts the new node at the end of the array. O(1)
	 * Call to increasePriority. O(log n)
	 * 
	 * @param key   - A key to uniquely identify the Object
	 * @param value - The object which needs to be maintained in the collection
	 */
	@Override
	public void insert(K key, V value) {
		HeapNode<K, V> newNode = new HeapNode<>(key, value);
		dataStore.add(newNode);
		increasePriority((dataStore.size() - 1), key);
	}
	
	/**
	 * Returns the current capacity of the collection<br>
	 * Time Complexity : O(1) <br>
	 * @return Integer value depicting the size of the collection.
	 */
	@Override
	public int size() {
		return dataStore.size();
	}
	
	/**
	 * retrieves the index of given key in the storage.<br>
	 * Time Complexity: O(n)
	 * @param key - A key to uniquely identify the Object
	 * @return an integer the index value of key 
	 */
	@Override
	public int getIndex(K key,V value) {
		HeapNode<K, V> node=new HeapNode<>(key,value);
		return dataStore.indexOf(node);
	}

	/**
	 * an iterator to iterate through every element and execute the action passed on
	 * every element.<br>
	 * Time Complexity: O(n)
	 * @param function the action that needs to be performed
	 */
	@Override
	public void functionalIterator(Consumer<HeapNode<K, V>> function) {
		dataStore.forEach(function);
	}

	/**
	 * provides the element with lowest key value without removing it from the heap.<br>
	 * Time Complexity: O(1)
	 * @return the object with minimum key value.
	 */
	@Override
	public V peek() {
		return dataStore.get(0).getValue();
	}
	
	
}
