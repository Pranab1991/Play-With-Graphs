package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

public interface List<V> extends Iterable<V>{
	void iterate(Consumer<V> function);

	int size();
	
	boolean isEmpty();
	
	void clear();
}
