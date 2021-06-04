package com.pranab.playwithgraphs.weightedgraphs;

/**
 * This interface needs to be implemented by any object that needs to behave as an Edge Weight in the graph.
 * @author Pranab Bharadwaj
 *
 */
@FunctionalInterface
public interface Weight {
	
	/**
	 * The final weight that is computed.
	 * @return integer value as the weight of edge.
	 */
	int getWeight();

}
