package com.pranab.playwithgraphs.weightedgraphs;

import com.pranab.playwithgraphs.Edge;

public class WeightedEdge<K,W extends Weight> extends Edge<K> {

	private W weights;

	public W getWeights() {
		return weights;
	}

	public void setWeights(W weights) {
		this.weights = weights;
	}

	public WeightedEdge() {
		super();
	}	
	
	public WeightedEdge(K keyPointingNode) {
		super(keyPointingNode);
	}

	public WeightedEdge(K keyPointingNode,W weights) {
		super(keyPointingNode);
		this.weights = weights;
	}
	
	
}
