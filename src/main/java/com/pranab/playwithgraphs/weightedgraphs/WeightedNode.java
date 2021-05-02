package com.pranab.playwithgraphs.weightedgraphs;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

public class WeightedNode<V, K, W extends Weight> {

	private V value;
	private boolean traversed;
	private LinkedList<WeightedEdge<K, W>> outGoingEdges = new DynamicList<>();

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public boolean isTraversed() {
		return traversed;
	}

	public void setTraversed(boolean traversed) {
		this.traversed = traversed;
	}
	
	public LinkedList<WeightedEdge<K, W>> getOutGoingEdges() {
		return outGoingEdges;
	}

	public void setOutGoingEdges(LinkedList<WeightedEdge<K, W>> outGoingEdges) {
		this.outGoingEdges = outGoingEdges;
	}

	public WeightedNode() {
		super();
	}

	public WeightedNode(V value) {
		super();
		this.value = value;
	}

	
}
