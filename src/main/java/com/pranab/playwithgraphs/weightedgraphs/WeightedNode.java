package com.pranab.playwithgraphs.weightedgraphs;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

/**
 * The object of this class is basic building unit i.e. Node/Vertex for Weighted Graphs.<br>
 * Configured to accommodate the weight for weighted edges.
 * It maintains the properties: <br>
 * value - The value that needs to be preserved.<br>
 * traversed - A boolean property depicting weather node has been traversed or not.<br>
 * outGoingEdges - Stores the edges from this node to other nodes
 * @author Pranab Bharadwaj
 *
 * @param <V> - The value of object to be maintained in the Graph's Node/Vertex.
 * @param <K> - Keys of target node to store the relationships associated with a node.
 * @param <W> -  An entity that implements Weight so as to simulate strength of relationship as integer values.  
 */
public class WeightedNode<V, K, W extends Weight> {

	private V value;
	private boolean traversed;
	private LinkedList<WeightedEdge<K, W>> outGoingEdges = new DynamicList<>();

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
	
	/**
	 * returns the list of edges moving out of the node
	 * @return the list of edges
	 */
	public LinkedList<WeightedEdge<K, W>> getOutGoingEdges() {
		return outGoingEdges;
	}


	public WeightedNode() {
		super();
	}

	public WeightedNode(V value) {
		super();
		this.value = value;
	}

	
}
