package com.pranab.playwithgraphs;

public class Edge<K> {

	private K keyPointingNode;

	public K getKeyPointingNode() {
		return keyPointingNode;
	}

	public void setKeyPointingNode(K keyPointingNode) {
		this.keyPointingNode = keyPointingNode;
	}


	public Edge() {
		super();
	}

	public Edge(K keyPointingNode) {
		super();
		this.keyPointingNode = keyPointingNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyPointingNode == null) ? 0 : keyPointingNode.hashCode());
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
		Edge other = (Edge) obj;
		if (keyPointingNode == null) {
			if (other.keyPointingNode != null)
				return false;
		} else if (!keyPointingNode.equals(other.keyPointingNode))
			return false;
		return true;
	}
	
	
}
