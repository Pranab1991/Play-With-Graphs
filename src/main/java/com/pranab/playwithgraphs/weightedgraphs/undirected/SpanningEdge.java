package com.pranab.playwithgraphs.weightedgraphs.undirected;

/**
 * The object of this class is used as an output representation after Minimum Spanning Tree calculation.
 * It provides below properties:
 * sourceKey - the starting point of edge.
 * targetKey - the end point of edge.
 * score - the minimum score identified among the multiple edges between source and target key.
 * @author Pranab Bharadwaj
 *
 * @param <K> The type of Key used in graph.
 */
public class SpanningEdge<K> {

	private K sourceKey;
	private K targetKey;
	private int score;
	
	
	/**
	 * @return the sourceKey
	 */
	public K getSourceKey() {
		return sourceKey;
	}
	/**
	 * @param sourceKey the sourceKey to set
	 */
	public void setSourceKey(K sourceKey) {
		this.sourceKey = sourceKey;
	}
	/**
	 * @return the targetKey
	 */
	public K getTargetKey() {
		return targetKey;
	}
	/**
	 * @param targetKey the targetKey to set
	 */
	public void setTargetKey(K targetKey) {
		this.targetKey = targetKey;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	public SpanningEdge(K sourceKey, K targetKey, int score) {
		super();
		this.sourceKey = sourceKey;
		this.targetKey = targetKey;
		this.score = score;
	}
	public SpanningEdge() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
