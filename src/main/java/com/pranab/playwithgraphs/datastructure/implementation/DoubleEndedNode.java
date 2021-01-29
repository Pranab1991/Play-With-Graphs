package com.pranab.playwithgraphs.datastructure.implementation;

public class DoubleEndedNode<V> {

	private DoubleEndedNode<V> previous;
	private V value;
	private DoubleEndedNode<V> next;

	public DoubleEndedNode<V> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleEndedNode<V> previous) {
		this.previous = previous;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public DoubleEndedNode<V> getNext() {
		return next;
	}

	public void setNext(DoubleEndedNode<V> next) {
		this.next = next;
	}

	DoubleEndedNode(DoubleEndedNode<V> previous, V value, DoubleEndedNode<V> next) {
		super();
		this.previous = previous;
		this.value = value;
		this.next = next;
	}

	DoubleEndedNode() {
		super();
	}

}
