package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import com.pranab.playwithgraphs.unweightedgraphs.Node;

/**
 * The object of this class is basic building unit i.e. Node/Vertex for
 * Unweighed Undirected Graph.<br>
 * Undirected Graph - a set of vertices or nodes that are connected together,
 * where all the edges are bidirectional. An undirected graph is sometimes
 * called an undirected network.
 * 
 * It maintains the properties apart from the properties inherited from Node:
 * <br>
 * prevPointer- Reference to the node from which one arrives to the current
 * node.<br>
 * level- the distance of current from source node considering the path length
 * to be unity.<br>
 * 
 * @author Pranab Bharadwaj
 *
 * @param <V> - The value of object to be maintained in the Graph's Node/Vertex.
 * @param <K> - Keys of target node to store the relationships associated with a
 *            node.
 */
public class UnDirectedNode<V, K> extends Node<V, K> {

	private K prevPointer;
	private int level;

	public UnDirectedNode() {
		super();
	}

	public UnDirectedNode(V value) {
		super(value);
	}

	/**
	 * The Node/Vertex from which the current node is arrived to
	 * 
	 * @return the key of the Node/Vertex from which we arrived to the current node.
	 */
	public K getPrevPointer() {
		return prevPointer;
	}

	/**
	 * set the previous Vertex to the current Vertex
	 * 
	 * @param prevPointer- the Key of the Vertex from which current Vertex is
	 *                     arrived to.
	 */
	public void setPrevPointer(K prevPointer) {
		this.prevPointer = prevPointer;
	}

	/**
	 * the level assigned to the node
	 * 
	 * @return an integer, distance from source node
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * sets the level of the node
	 * 
	 * @param level - the distance to be assigned to the node
	 */
	public void setLevel(int level) {
		this.level = level;
	}

}
