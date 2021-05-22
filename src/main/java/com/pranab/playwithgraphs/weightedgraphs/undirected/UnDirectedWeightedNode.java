package com.pranab.playwithgraphs.weightedgraphs.undirected;

import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.WeightedNode;

public class UnDirectedWeightedNode<V, K, W extends Weight> extends WeightedNode<V, K, W> {

	private K prevPointer;
	private int level;
	private int score=-1;
	private int mstScoreHolder=Integer.MAX_VALUE;
	
	public int getMstScoreHolder() {
		return mstScoreHolder;
	}

	public void setMstScoreHolder(int mstScoreHolder) {
		this.mstScoreHolder = mstScoreHolder;
	}

	public UnDirectedWeightedNode() {
		super();
	}

	public UnDirectedWeightedNode(V value) {
		super(value);
	}

	public K getPrevPointer() {
		return prevPointer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
}
