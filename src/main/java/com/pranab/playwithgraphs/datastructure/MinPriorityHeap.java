package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.implementation.HeapNode;

public interface MinPriorityHeap<K extends Comparable<K>, V> {

	V extractMin();

	void increasePriority(int index, K newKey);

	void insert(K key, V value);

	int size();

	int getIndex(K key);

	void functionalIterator(Consumer<HeapNode<K, V>> function);
	
	V peek(); 

}