package com.pranab.playwithgraphs.unweightedgraphs.undirected;

import com.pranab.playwithgraphs.unweightedgraphs.Node;

public class UnDirectedNode<V,K> extends Node<V,K>{

	private K prevPointer;
	private int level;
	
	public UnDirectedNode() {
		super();
	}

	public UnDirectedNode(V value) {
		super(value);
	}

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
	
}
