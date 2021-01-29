package com.pranab.playwithgraphs.datastructure.implementation;

import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.LinkedList;

public class DynamicList<V> implements LinkedList<V> {

	private DoubleEndedNode<V> start;
	private DoubleEndedNode<V> end;
	private int size=0;
	
	@Override
	public void addFirst(V value) {
		DoubleEndedNode<V> newNode=new DoubleEndedNode<>(null,value,null);
		if(start==null) {
			start=newNode;
			end=start;
		}else {
			newNode.setNext(start);
			start.setPrevious(newNode);
			start=newNode;
		}
		size++;
	}

	@Override
	public void addLast(V value) {
		DoubleEndedNode<V> newNode=new DoubleEndedNode<>(null,value,null);
		if(end==null) {
			end=newNode;
			start=end;
		}else {
			newNode.setPrevious(end);
			end.setNext(newNode);
			end=newNode;
		}
		size++;
	}

	@Override
	public V removeFirst() {
		DoubleEndedNode<V> removedNode=null;
		if(start==null) {
			throw new UnsupportedOperationException("The storage is Empty");
		}
		if(start.getNext()==null) {
			removedNode= start;
			start=null;
			end=null;
		}else {
			removedNode= start;
			start=start.getNext();
			start.setPrevious(null);
		}
		size--;
		return removedNode.getValue();
	}

	@Override
	public V removeLast() {
		DoubleEndedNode<V> removedNode=null;
		if(end==null) {
			throw new UnsupportedOperationException("The storage is Empty");
		}
		if(end.getPrevious()==null) {
			removedNode= end;
			start=null;
			end=null;
		}else {
			removedNode= end;
			end=end.getPrevious();
			end.setNext(null);
		}
		size--;
		return removedNode.getValue();
	}

	@Override
	public void iterate(Consumer<V> function) {
		DoubleEndedNode<V> traverser=start;
		while(traverser!=null) {
			function.accept(traverser.getValue());
			traverser=traverser.getNext();
		}
	}

	@Override
	public int size() {
		return size;
	}

}
