package com.pranab.playwithgraphs.weightedgraphs.undirected;

import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedNode;

/**
 * The object of this class is basic building unit i.e. Node/Vertex for
 * Weighed Undirected Graph.<br>
 * Weighed Undirected Graph - a set of vertices or nodes that are connected together,
 * where all the edges are bidirectional having varying weight. An undirected graph is sometimes
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
 * @param <W> - An entity that implements Weight so as to simulate strength of relationship as integer values. 
 */
public class UnDirectedWeightedNode<V, K, W extends Weight> extends WeightedNode<V, K, W> {

	private K prevPointer;
	private int level;
	private int score=-1;
	private int mstScoreHolder=Integer.MAX_VALUE;
	
	/**
	 * the method retrieves the minimum spanning tree score for current node
	 * 
	 * @return  minimum spanning tree score for current node.
	 */
	public int getMstScoreHolder() {
		return mstScoreHolder;
	}

	/**
	 * the method sets the minimum spanning tree score for current node
	 * 
	 * @param mstScoreHolder- minimum spanning tree score for current node.
	 */
	public void setMstScoreHolder(int mstScoreHolder) {
		this.mstScoreHolder = mstScoreHolder;
	}

	public UnDirectedWeightedNode() {
		super();
	}

	public UnDirectedWeightedNode(V value) {
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
