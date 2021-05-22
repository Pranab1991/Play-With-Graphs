package com.pranab.playwithgraphs.datastructure;

import java.util.Optional;

public interface LinkedList<V> extends List<V>{
	 
	void addFirst(V value);

	void addLast(V value);
	
	Optional<V> getFirst();
	
	Optional<V> getLast();
	
	V removeFirst();
	
	V removeLast();
	
	V removeElement(V value);
}
