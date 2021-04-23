package com.pranab.playwithgraphs;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

public class DirectedNode<V,K> extends Node<V,K>{

	private K prevPointer;
	private int level;
	private LinkedList<Edge<K>> inComingEdges=new DynamicList<>();
	
	public LinkedList<Edge<K>> getInComingEdges() {
		return inComingEdges;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}	

	public K getPrevPointer() {
		return prevPointer;
	}

	public void setPrevPointer(K prevPointer) {
		this.prevPointer = prevPointer;
	}

	public DirectedNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirectedNode(V value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	
}
