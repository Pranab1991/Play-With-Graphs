package com.pranab.playwithgraphs.datastructure;

public interface LinkedList<V> extends List<V>{
	 
	void addFirst(V value);

	void addLast(V value);
	
	V removeFirst();
	
	V removeLast();
}
