package com.pranab.playwithgraphs.datastructure.implementation;

/**
 * This object is building block unit for ArrayMinPriorityHeap data structure implemented.
 * 
 * @author Pranab Bharadwaj
 *
 * @param <K> - An comparable entity which is used to prioritize
 * @param <V> - The object that needs to be saved in collection identified by
 *            unique keys.
 */
public class HeapNode<K extends Comparable<K>,V> implements Cloneable {

	private K key;
	private V value;
	
	/**
	 * Retrieves the unique key
	 * @return the unique key
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * Retrieves the stored value
	 * @return the value stored
	 */
	public V getValue() {
		return value;
	}
	
	/**
	 * either to set or update the stored value
	 * 
	 * @param value - the value that needs to be associated with the key
	 */
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
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
