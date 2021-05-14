package com.pranab.playwithgraphs.weightedgraphs.directed;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedEdge;
import com.pranab.playwithgraphs.weightedgraphs.WeightedNode;

public class DirectedWeightedNode<V, K, W extends Weight> extends WeightedNode<V, K, W> {

	private K prevPointer;
	private int score=-1;
	private int level;
	private LinkedList<WeightedEdge<K, W>> inComingEdges=new DynamicList<>();
	
	public K getPrevPointer() {
		return prevPointer;
	}
	
	public void setPrevPointer(K prevPointer) {
		this.prevPointer = prevPointer;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public LinkedList<WeightedEdge<K, W>> getInComingEdges() {
		return inComingEdges;
	}
	
	public void setInComingEdges(LinkedList<WeightedEdge<K, W>> inComingEdges) {
		this.inComingEdges = inComingEdges;
	}

	public DirectedWeightedNode() {
		super();
	}
	
	public DirectedWeightedNode(V value) {
		super(value);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
