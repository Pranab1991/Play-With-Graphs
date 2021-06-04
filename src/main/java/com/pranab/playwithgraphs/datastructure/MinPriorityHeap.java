package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.implementation.HeapNode;

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
 * </p>
 * 
 * @author Pranab Bharadwaj
 *
 * @param <K> - An comparable entity which is used to prioritize
 * @param <V> - The Value that needs to be saved in collection identified by
 *            unique keys.
 */
public interface MinPriorityHeap<K extends Comparable<K>, V> {

	/**
	 * Extracts the objects identified by the minimum key among all the keys stored
	 * in the collection.
	 * 
	 * @return the object stored against the minimum key.
	 */
	V extractMin();

	/**
	 * Increases the priority of a specific object for early processing. Note : In
	 * min-heap increasing priority leads to decrease in value of key
	 * 
	 * @param index  - current index of the key
	 * @param newKey - new value of the key with increased priority
	 */
	void increasePriority(int index, K newKey);

	/**
	 * Inserts an object into the collection.
	 * 
	 * @param key   - A key to uniquely identify the Object
	 * @param value - The object which needs to be maintained in the collection
	 */
	void insert(K key, V value);

	/**
	 * The size of collection
	 * 
	 * @return Integer value depicting the current capacity
	 */
	int size();

	/**
	 * get the index of the value stored in the collection.
	 * 
	 * @param key - the key of the node.
	 * @param value - the value of the node.
	 * @return the index of the key
	 */
	int getIndex(K key,V value);

	/**
	 * an iterator to iterate through every element and execute the action passed on
	 * every element.
	 * 
	 * @param function the action that needs to be performed
	 */
	void functionalIterator(Consumer<HeapNode<K, V>> function);

	/**
	 * provides the element with lowest key value without removing it from the heap.
	 * 
	 * @return the object with minimum key value.
	 */
	V peek();

}