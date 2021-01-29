package com.pranab.playwithgraphs.datastructure;

import java.util.function.Consumer;

public interface List<V> {
	void iterate(Consumer<V> function);

	int size();
}
