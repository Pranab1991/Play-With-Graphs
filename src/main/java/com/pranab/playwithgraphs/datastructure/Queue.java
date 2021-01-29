package com.pranab.playwithgraphs.datastructure;

public interface Queue<V> extends List<V>{

	void enqueue(V value);
	
	V dequeue();
	
	V peep(); 
}
