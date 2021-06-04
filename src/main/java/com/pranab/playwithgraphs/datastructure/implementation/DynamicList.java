package com.pranab.playwithgraphs.datastructure.implementation;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.Stack;

/**
 * The Doubly Linked List implementation of List, Queue and Stack. 
 * The object of class behaves as a List or Queue or Stack entity as the reference is assigned during instantiation.<br>
 * 
 * <p>Doubly Linked List- is a sequence of double ended nodes, which are connected together via links.<br>

 * double ended node is the building unit of Double Linked List with references to previous and next nodes.
 * Each node also stores the value</p>
 * <p>Queue - is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO).</p>
 * <p>Stack is a linear data structure which follows a particular order in which the operations are performed. The order is FILO(First In Last Out).</p>
 * 
 * <p>Instantiation :<br>
 *          List&lt;String&gt; randomList=new DynamicList&lt;&gt;();<br>
 *          Queue&lt;String&gt; randomQueue= new DynamicList&lt;&gt;();<br>
 *          Stack&lt;String&gt; randomStack= new DynamicList&lt;&gt;();<br>
 *    Usage : <br>      
 *          randomList.addFirst("abc");<br>
 *          randomQueue.enqueue("def");<br>
 *          randomStack.push("ghi");<br>
 *  </p>
 * @author Pranab Bharadwaj
 *
 * @param <V> - The Value that needs to be saved in collection
 */
public class DynamicList<V> implements LinkedList<V>, Queue<V>, Stack<V> {

	private DoubleEndedNode<V> start;
	private DoubleEndedNode<V> end;
	private int size = 0;

	/**
	 * Adds elements at the beginning of the list.<br>
	 * Time complexity : O(1)
	 * @param value - The value that needs to be inserted
	 */
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

	/**
	 * Adds elements to the end of the list.<br>
	 * Time complexity : O(1)
	 * @param value - The value that needs to be inserted
	 */
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

	/**
	 * Removes and returns the first element of the list.<br>
	 * Time complexity : O(1) 
	 * @return the value that is removed
	 */
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

	/**
	 * Removes and returns the last element of the list.<br>
	 * Time complexity : O(1) 
	 * @return the value that is removed
	 */
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

	/**
	 * Removes the element at the provided index
	 * Time Complexity : O(n)
	 * @param index - position of element that is to be removed
	 * @return the value that is removed
	 */
	@Override
	public V removeIndex(int index) {
		if(index<0 || index>(size-1)) {
			throw new IndexOutOfBoundsException();
		}
		if(index==0) {
			return removeFirst();
		}
		if(index==(size-1)) {
			return removeLast();
		}
		DoubleEndedNode<V> temp=start;
		for(int i=0;i<(index-1);i++) {
			temp=temp.getNext();
		}
		DoubleEndedNode<V> next=temp.getNext().getNext();
		DoubleEndedNode<V> removedNode=temp.getNext();
		temp.setNext(next);
		next.setPrevious(temp);
		size--;
		return removedNode.getValue();
	}
	
	/**
	 * Removes the provided element from the list
	 * Time Complexity: O(n)
	 * @param value - the value that is to be returned
	 * @return the value that is removed
	 */
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
	
	/**
	 * an iterator to iterate through every element and execute the action passed on
	 * every element.<br>
	 * Time Complexity: O(n)
	 * @param function the action that needs to be performed
	 */
	@Override
	public void functionalIterate(Consumer<V> function) {
		DoubleEndedNode<V> traverser = start;
		while (traverser != null) {
			function.accept(traverser.getValue());
			traverser = traverser.getNext();
		}
	}

	/**
	 * Returns the size of elements in the collection.<br>
	 * Time Complexity: O(1)
	 * @return Integer value depicting the current capacity
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Insert an element into the the tail of the queue.<br>
	 * Time Complexity: O(1)
	 * @param value - The element that needs to maintained in the collection. 
	 */
	@Override
	public void enqueue(V value) {
		addFirst(value);
	}

	/**
	 * Removes an element from the head of the queue.<br>
	 * Time Complexity: O(1)
	 * @return the object removed from the head of the queue
	 */
	@Override
	public V dequeue() {
		return removeLast();
	}

	/**
	 * returns the first element without removing it from queue<br>
	 * Time Complexity: O(1)
	 * @return the element present at the head of queue.
	 */
	@Override
	public V peep() {
		if (end == null) {
			return null;
		}
		return end.getValue();
	}

	/**
	 * Insert an element into the the tail of the queue.<br>
	 * Time Complexity: O(1)
	 * @param value - The element that needs to maintained in the collection.
	 */
	@Override
	public void push(V value) {
		addFirst(value);
	}

	/**
	 * Removes an element from the tail of the queue.<br>
	 * Time Complexity: O(1)
	 * @return the object removed from the head of the queue
	 */
	@Override
	public V pop() {
		return removeFirst();
	}

	/**
	 * returns the first element without removing it from queue<br>
	 * Time Complexity: O(1)
	 * @return the element present at the head of queue.
	 */
	@Override
	public V peek() {
		if (start == null) {
			return null;
		}
		return start.getValue();
	}

	/**
	 * Updates weather collection is empty or not<br>
	 * Time Complexity: O(1)
	 * @return boolean value , true if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (size == 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Clears all elements of a collection<br>
	 * Time Complexity: O(1)
	 */
	@Override
	public void clear() {
		start=null;
		end=null;
		size=0;
	}

	/**
	 * Returns an Iterator object to iterate over entire each element.<br>
	 * Time Complexity: O(1)
	 * @return An Instance of Iterator
	 */
	@Override
	public Iterator<V> iterator() {
		return new Itr();
	}
	
	/**
	 * Searches element on the basis of object equality criteria i.e calls the
	 * equals method and compares the parameter.<br>
	 * Time complexity : O(n)
	 * @param searchObj the object whose stored state in collection needs to be
	 *                  found out.
	 * @return the matched object stored in collection
	 */
	@Override
	public V search(V searchObj) {
		DoubleEndedNode<V> temp=start;
		V result=null;
		while(temp!=null) {
			if(temp.getValue().equals(searchObj)) {
			 result=temp.getValue();
			 break;
			}
			temp=temp.getNext();
		}
		return result;
	}


	/**
	 * Returns first element of the list without removing.<br>
	 * Time Complexity : O(1)
	 * @return An optional, encapsulating the retrieved value
	 */
	@Override
	public Optional<V> getFirst() {
		if(start==null) {
			return Optional.empty();
		}
		return Optional.ofNullable(start.getValue());
	}

	/**
	 * Returns last element of the list without removing.
	 * Time Complexity : O(1)
	 * @return An optional, encapsulating the retrieved value
	 */
	@Override
	public Optional<V> getLast() {
		if(end==null) {
			return Optional.empty();
		}
		return Optional.ofNullable(end.getValue());
	}


	/**
	 * Returns the element at the provided index
	 * Time Complexity : O(n)
	 * @param index -- position of element that is to be retrieved
	 * @return the value present at the index
	 */
	@Override
	public V get(int index) {
		if(index<0 || index>(size-1)) {
			throw new IndexOutOfBoundsException();
		}
		DoubleEndedNode<V> temp=start;
		for(int i=0;i<index;i++) {
			temp=temp.getNext();
		}
		return temp.getValue();
	}
	
	/**
	 * An implementation of Iterator to support traversal through each and every element of Collection.
	 * @author Pranab Bharadwaj
	 *
	 */
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
