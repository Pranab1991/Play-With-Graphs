package com.pranab.playwithgraphs.datastructure.implementation;

public class HeapNode<K extends Comparable<K>,V> implements Cloneable {

	private K key;
	private V value;
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public HeapNode() {
		super();
	}
	public HeapNode(K key) {
		super();
		this.key = key;
	}
	public HeapNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "HeapNode [key=" + key + ", value=" + value + "]";
	}	
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeapNode other = (HeapNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	} 
	
	
}
