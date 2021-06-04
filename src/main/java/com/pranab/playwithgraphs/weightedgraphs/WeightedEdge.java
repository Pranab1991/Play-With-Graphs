package com.pranab.playwithgraphs.weightedgraphs;

import java.util.function.Predicate;

import com.pranab.playwithgraphs.Edge;

/**
 * Inherits from Edge having the same functionality i.e. representing the relationship between Two nodes. The WeightedEdge have the ability to simulate the strength of relationship. 
 * @author Pranab Bharadwaj
 *
 * @param <K> The type of entity identifier(Key) the Edge is going to encapsulate while establishing an relationship
 * @param <W> An entity that implements Weight so as to simulate strength of relationship as integer values.
 */
public class WeightedEdge<K,W extends Weight> extends Edge<K> {

	private W weight;

	/**
	 * Returns the object that emulates the ability to behave as an weight for this edge. 
	 * @return the object that plays the role of weight in the Edge.
	 */
	public W getWeight() {
		return weight;
	}

	/**
	 * Set weight for this edge
	 * @param weight - the object that will provide weight to the edge.
	 */
	public void setWeight(W weight) {
		this.weight = weight;
	}

	public WeightedEdge() {
		super();
	}	
	
	public WeightedEdge(K keyPointingNode) {
		super(keyPointingNode);
	}

	public WeightedEdge(K keyPointingNode,W weights) {
		super(keyPointingNode);
		this.weight = weights;
	}
	

	public boolean qureyIfPresent(Predicate<W> predicate) {
		return predicate.test(this.getWeight());
	}
}
