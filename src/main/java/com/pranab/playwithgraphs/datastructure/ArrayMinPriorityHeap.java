package com.pranab.playwithgraphs.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayMinPriorityHeap<K extends Comparable<K>, V> implements MinPriorityHeap<K, V> {

	private List<HeapNode<K, V>> dataStore = new ArrayList<>();

	private int getParentIndex(int index) {
		if (index <= 0) {
			return 0;
		}
		return index - 1 >> 1;
	}

	private int getLeftChildIndex(int index) {
		if (index < 0) {
			throw new UnsupportedOperationException("Only works for positive integrals");
		}
		return (index << 1) + 1;
	}

	private int getRightChildIndex(int index) {
		if (index < 0) {
			throw new UnsupportedOperationException("Only works for positive integrals");
		}
		return (index << 1) + 2;
	}

	private void heapyfy(int index) {
		int heapSize = dataStore.size() - 1;
		HeapNode<K, V> node=dataStore.get(index);
		int leftIndex = getLeftChildIndex(index);
		if (leftIndex > heapSize) {
			return;
		}
		boolean indicator = false;

		HeapNode<K, V> leftChild = dataStore.get(leftIndex);
		HeapNode<K, V> minNode = null;
		if (leftChild.getKey().compareTo(node.getKey()) < 0) {
			minNode = leftChild;
		} else {
			minNode = node;
		}

		int rightIndex = getRightChildIndex(index);
		if (rightIndex <= heapSize) {
			HeapNode<K, V> rightChild = dataStore.get(rightIndex);
			if (rightChild.getKey().compareTo(minNode.getKey()) < 0) {
				minNode = rightChild;
				indicator = true;
			}
		}
		if (minNode != node) {
			if (indicator) {
				dataStore.set(rightIndex, node);
				dataStore.set(index, minNode);
				heapyfy(rightIndex);
			} else {
				dataStore.set(leftIndex, node);
				dataStore.set(index, minNode);
				heapyfy(leftIndex);
			}			
		}
	}

	@Override
	public V extractMin() {
		if (dataStore.isEmpty()) {
			throw new UnsupportedOperationException("Heap is Empity");
		}
		HeapNode<K, V> minNode = dataStore.get(0);
		HeapNode<K, V> newMeanNode = dataStore.remove(dataStore.size() - 1);
		if (!dataStore.isEmpty()) {
			dataStore.set(0, newMeanNode);
			heapyfy(0);
		}
		return minNode.getValue();
	}

	@Override
	public void increasePriority(int index, K newKey) {
		HeapNode<K, V> node = dataStore.get(index);
		if (newKey.compareTo(node.getKey()) > 0) {
			throw new UnsupportedOperationException("Key is larger than existing, won't increase priority");
		}
		HeapNode<K, V> newNode = new HeapNode<>(newKey,node.getValue());
		node=newNode;
		dataStore.set(index, newNode);
		int parentIndex = getParentIndex(index);
		HeapNode<K, V> parentNode = dataStore.get(parentIndex);
		while (index > 0 && node.getKey().compareTo(parentNode.getKey()) < 0) {
			HeapNode<K, V> temp = node;
			dataStore.set(index, parentNode);
			dataStore.set(parentIndex, temp);
			index = parentIndex;
			parentIndex = getParentIndex(parentIndex);
			node = dataStore.get(index);
			parentNode = dataStore.get(parentIndex);
		}
	}

	@Override
	public void insert(K key, V value) {
		HeapNode<K, V> newNode = new HeapNode<>(key, value);
		dataStore.add(newNode);
		increasePriority((dataStore.size() - 1), key);
	}
	
	@Override
	public int size() {
		return dataStore.size();
	}
	
	@Override
	public int getIndex(K key) {
		HeapNode<K, V> node=new HeapNode<>(key);
		return dataStore.indexOf(node);
	}

	@Override
	public void functionalIterator(Consumer<HeapNode<K, V>> function) {
		dataStore.forEach(function);
	}

	@Override
	public V peek() {
		return dataStore.get(0).getValue();
	}
	
	
}
