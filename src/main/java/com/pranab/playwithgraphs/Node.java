package com.pranab.playwithgraphs;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

public class Node<V,K> {
	private V value;
	private boolean traversed;
	private LinkedList<Edge<K>> outGoingEdges=new DynamicList<>();
	
	public LinkedList<Edge<K>> getOutGoingEdges() {
		return outGoingEdges;
	}

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

	public Node() {
		super();
	}
	
	public Node(V value) {
		super();
		this.value = value;
	}
}
