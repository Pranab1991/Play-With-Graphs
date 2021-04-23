package com.pranab.playwithgraphs.datastructure.implementation;

import java.util.Iterator;
import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.Stack;

public class DynamicList<V> implements LinkedList<V>, Queue<V>, Stack<V> {

	private DoubleEndedNode<V> start;
	private DoubleEndedNode<V> end;
	private int size = 0;

	@Override
	public void addFirst(V value) {
		DoubleEndedNode<V> newNode = new DoubleEndedNode<>(null, value, null);
		if (start == null) {
			start = newNode;
			end = start;
		} else {
			newNode.setNext(start);
			start.setPrevious(newNode);
			start = newNode;
		}
		size++;
	}

	@Override
	public void addLast(V value) {
		DoubleEndedNode<V> newNode = new DoubleEndedNode<>(null, value, null);
		if (end == null) {
			end = newNode;
			start = end;
		} else {
			newNode.setPrevious(end);
			end.setNext(newNode);
			end = newNode;
		}
		size++;
	}

	@Override
	public V removeFirst() {
		DoubleEndedNode<V> removedNode = null;
		if (start == null) {
			throw new UnsupportedOperationException("The storage is Empty");
		}
		if (start.getNext() == null) {
			removedNode = start;
			start = null;
			end = null;
		} else {
			removedNode = start;
			start = start.getNext();
			start.setPrevious(null);
		}
		size--;
		return removedNode.getValue();
	}

	@Override
	public V removeLast() {
		DoubleEndedNode<V> removedNode = null;
		if (end == null) {
			throw new UnsupportedOperationException("The storage is Empty");
		}
		if (end.getPrevious() == null) {
			removedNode = end;
			start = null;
			end = null;
		} else {
			removedNode = end;
			end = end.getPrevious();
			end.setNext(null);
		}
		size--;
		return removedNode.getValue();
	}

	@Override
	public void iterate(Consumer<V> function) {
		DoubleEndedNode<V> traverser = start;
		while (traverser != null) {
			function.accept(traverser.getValue());
			traverser = traverser.getNext();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(V value) {
		addFirst(value);
	}

	@Override
	public V dequeue() {
		return removeLast();
	}

	@Override
	public V peep() {
		if (end == null) {
			return null;
		}
		return end.getValue();
	}

	@Override
	public void push(V value) {
		addFirst(value);
	}

	@Override
	public V pop() {
		return removeFirst();
	}

	@Override
	public V peek() {
		if (start == null) {
			return null;
		}
		return start.getValue();
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (size == 0) {
			result = true;
		}
		return result;
	}

	@Override
	public V removeElement(V value) {
		V result = null;
		if (start == null) {
			throw new UnsupportedOperationException("The storage is Empty");
		} else if (value.equals(start.getValue())) {
			return removeFirst();
		} else if (value.equals(end.getValue())) {
			return removeLast();
		} else {
			DoubleEndedNode<V> temp = start.getNext();
			while (temp != null) {
				if (value.equals(temp.getValue())) {
					temp.getPrevious().setNext(temp.getNext());
					temp.getNext().setPrevious(temp.getPrevious());
					temp.setNext(null);
					temp.setPrevious(null);
					result =  temp.getValue();
					break;
				}
				temp = temp.getNext();
			}
		}
		if(result!=null) {
			size--;
		}
		return result;
	}

	@Override
	public void clear() {
		start=null;
		end=null;
		size=0;
	}

	@Override
	public Iterator<V> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<V>{
		DoubleEndedNode<V> cursor;
		
		public Itr() {
			cursor=start;
		}
		
		@Override
		public boolean hasNext() {
			boolean result=false;
			if(cursor!=null) {
				result=true;
			}
			return result;
		}

		@Override
		public V next() {
			V value= cursor.getValue();
			cursor=cursor.getNext();
			return value;
		}
		
	}

}
