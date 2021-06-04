package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

/**
 * A generic interface for all collection preserving sequential ordering of
 * elements.
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> - The generic type, whose objects will be maintained in collection
 */
public interface List<V> extends Iterable<V> {
	/**
	 * an iterator to iterate through every element and execute the action passed on
	 * every element.
	 * 
	 * @param function the action that needs to be performed
	 */
	void functionalIterate(Consumer<V> function);

	/**
	 * Returns the size of elements in the collection.
	 * 
	 * @return Integer value depicting the current capacity
	 */
	int size();

	/**
	 * Updates weather collection is empty or not
	 * 
	 * @return boolean value , true if the list is empty
	 */
	boolean isEmpty();

	/**
	 * Clears all elements of a collection
	 */
	void clear();

	/**
	 * Searches element on the basis of object equality criteria i.e calls the
	 * equals method and compares the parameter.
	 * 
	 * @param searchObj the object whose stored state in collection needs to be
	 *                  found out.
	 * @return the matched object stored in collection
	 */
	V search(V searchObj);
}
