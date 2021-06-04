package com.pranab.playwithgraphs.datastructure.implementation;

/**
 * The object of this class is basic building unit for DynamicList data structure. 
 * This object is a double end node storing a reference to previous and next node. Also encapsulates the value
 * @author Pranab Bharadwaj
 *
 * @param <V> - The object that needs to be saved in collection
 */
public class DoubleEndedNode<V> {

	private DoubleEndedNode<V> previous;
	private V value;
	private DoubleEndedNode<V> next;

	/**
	 * returns a reference to previous node
	 * @return Reference to previous node. Null if current node is start . 
	 */
	public DoubleEndedNode<V> getPrevious() {
		return previous;
	}

	/**
	 * Sets the previous pointer of current node to the provided node.
	 * @param previous - the node that needs to referred from current node
	 */
	public void setPrevious(DoubleEndedNode<V> previous) {
		this.previous = previous;
	}

	/**
	 * Get the value of the encapsulated in the given node 
	 * @return the value encapsulated
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Sets the value to the current node
	 * @param value - the value that needs to be encapsulated
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * returns a reference to next node
	 * @return Reference to next node. Null if current node is end node. 
	 */
	public DoubleEndedNode<V> getNext() {
		return next;
	}

	/**
	 * Sets the next pointer of current node to the node provided.
	 * @param next - the node that needs to referred from current node
	 */
	public void setNext(DoubleEndedNode<V> next) {
		this.next = next;
	}

	DoubleEndedNode(DoubleEndedNode<V> previous, V value, DoubleEndedNode<V> next) {
		super();
		this.previous = previous;
		this.value = value;
		this.next = next;
	}

	DoubleEndedNode() {
		super();
	}

}
