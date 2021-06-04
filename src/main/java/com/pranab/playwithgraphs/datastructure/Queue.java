package com.pranab.playwithgraphs.datastructure;

/**
 * A collection to store data with first in first out strategy. 
 * @author Pranab Bharadwaj
 *
 * @param <V> The Entity type whose objects will be stored in the collection.
 */
public interface Queue<V> extends List<V>{

	/**
	 * Insert an element into the the tail of the queue.
	 * @param value - The element that needs to maintained in the collection. 
	 */
	void enqueue(V value);
	
	/**
	 * Removes an element from the head of the queue.
	 * @return the object removed from the head of the queue
	 */
	V dequeue();
	
	/**
	 * returns the first element without removing it from queue
	 * @return the element present at the head of queue.
	 */
	V peep(); 
}
