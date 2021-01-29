package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

public interface LinkedList<V> {
	 
	void addFirst(V value);

	void addLast(V value);
	
	V removeFirst();
	
	V removeLast();
	
	void iterate(Consumer<V> function);
	
	int size();
}
