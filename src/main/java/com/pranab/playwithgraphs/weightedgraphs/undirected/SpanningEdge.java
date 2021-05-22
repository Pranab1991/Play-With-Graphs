package com.pranab.playwithgraphs.weightedgraphs.undirected;

public class SpanningEdge<K> {

	private K sourceKey;
	private K targetKey;
	private int score;
	public K getSourceKey() {
		return sourceKey;
	}
	public void setSourceKey(K sourceKey) {
		this.sourceKey = sourceKey;
	}
	public K getTargetKey() {
		return targetKey;
	}
	public void setTargetKey(K targetKey) {
		this.targetKey = targetKey;
	}
	public int getScore() {
		return score;
	}
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
