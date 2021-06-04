package com.pranab.playwithgraphs.unweightedgraphs;

import com.pranab.playwithgraphs.Edge;
import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

/**
 * The object of this class is basic building unit i.e. Node/Vertex for Graphs.<br>
 * It maintains the properties: <br>
 * value - The value that needs to be preserved.<br>
 * traversed - A boolean property depicting weather node has been traversed or not.<br>
 * outGoingEdges - Stores the edges from this node to other nodes
 * @author Pranab Bharadwaj
 *
 * @param <V> - The value of object to be maintained in the Graph's Node/Vertex.
 * @param <K> - Keys of target node to store the relationships associated with a node.  
 */
public class Node<V,K> {
	private V value;
	private boolean traversed;
	private LinkedList<Edge<K>> outGoingEdges=new DynamicList<>();
	
	/**
	 * returns the list of edges moving out of the node
	 * @return the list of edges
	 */
	public LinkedList<Edge<K>> getOutGoingEdges() {
		return outGoingEdges;
	}

	/**
	 * Returns the value stored in the node
	 * @return the value stored in the node
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Sets the value to be stored
	 * @param value - the object that needs to be saved
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * Checks weather the node is traversed or not.
	 * @return a boolean value depicting the traversed status.
	 */
	public boolean isTraversed() {
		return traversed;
	}

	/**
	 * Sets the traversed property to true or false
	 * @param traversed- boolean value to set traversed to true or false.
	 */
	public void setTraversed(boolean traversed) {
		this.traversed = traversed;
	}

	public Node() {
		super();
	}
	
	public Node(V value) {
		super();
		this.value = value;
	}
}
