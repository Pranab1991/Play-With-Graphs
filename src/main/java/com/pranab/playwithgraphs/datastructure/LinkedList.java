package com.pranab.playwithgraphs.datastructure;

import java.util.Optional;

/**
 * An ordered collection. The collection preserves the order of insertion and is
 * optimized for quick insertion and deletion.
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> - The generic type, whose objects will be maintained in collection
 */
public interface LinkedList<V> extends List<V> {

	/**
	 * Adds elements from the beginning of the list.
	 * 
	 * @param value - The value that needs to be inserted
	 */
	void addFirst(V value);

	/**
	 * Adds elements to the end of the list.
	 * 
	 * @param value - The value that needs to be inserted
	 */
	void addLast(V value);

	/**
	 * Returns first element of the list without removing.
	 * 
	 * @return An optional, encapsulating the retrieved value
	 */
	Optional<V> getFirst();

	/**
	 * Returns last element of the list without removing.
	 * 
	 * @return An optional, encapsulating the retrieved value
	 */
	Optional<V> getLast();

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the value that is removed
	 */
	V removeFirst();

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the value that is removed
	 */
	V removeLast();

	/**
	 * Removes the provided element from the list
	 * 
	 * @param value - the value that is to be returned
	 * @return the value that is removed
	 */
	V removeElement(V value);

	/**
	 * Removes the element at the provided index
	 * 
	 * @param index - position of element that is to be removed
	 * @return the value that is removed
	 */
	V removeIndex(int index);

	/**
	 * Returns the element at the provided index
	 * 
	 * @param index -- position of element that is to be retrieved
	 * @return the value present at the index
	 */
	V get(int index);
}
