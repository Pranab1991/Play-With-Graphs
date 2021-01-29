package com.pranab.playwithgraphs.datastructure;

public interface Stack<V> extends List<V> {

	void push(V value);
	
	V pop();
	
	V peek();
}
