package com.pranab.playwithgraphs.weightedgraphs.directed;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedEdge;
import com.pranab.playwithgraphs.weightedgraphs.WeightedNode;

/**
 * The object of this class is basic building unit i.e. Node/Vertex for Weighed Directed Graph.<br>
 * Weighted Directed Graph-  a set of vertices or nodes that are connected together, where all the edges are directed from one vertex to another having varying weight. A directed graph is sometimes called a digraph or a directed network.<br> 
 * It maintains the properties apart from the properties inherited from Node: <br>
 * prevPointer- Reference to the node from which one arrives to the current node.<br>
 * level- the distance of current from source node considering the path length to be unity.<br>
 * inComingEdges - the list of incoming edges to the current node. 
 * @author Pranab Bharadwaj
 *
 * @param <V> - The value of object to be maintained in the Graph's Node/Vertex.
 * @param <K> - Keys of target node to store the relationships associated with a node.
 * @param <W>  An entity that implements Weight so as to simulate strength of relationship as integer values.  
 */
public class DirectedWeightedNode<V, K, W extends Weight> extends WeightedNode<V, K, W> {

	private K prevPointer;
	private int score=-1;
	private int level;
	private LinkedList<WeightedEdge<K, W>> inComingEdges=new DynamicList<>();
	

	/**
	 * The Node/Vertex from which the current node is arrived to
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
	 * @return an integer, distance from source node
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * sets the level of the node
	 * @param level - the distance to be assigned to the node
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * returns the list of edges coming in to the node
	 * @return the list of edges
	 */
	public LinkedList<WeightedEdge<K, W>> getInComingEdges() {
		return inComingEdges;
	}

	public DirectedWeightedNode() {
		super();
	}
	
	public DirectedWeightedNode(V value) {
		super(value);
	}
	
	/**
	 * the score assigned to the node till now
	 * @return the score assigned to the node
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the distance till the node i.e. the path length till that node
	 * @param score - an integer value that depicts the path length till that node
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
