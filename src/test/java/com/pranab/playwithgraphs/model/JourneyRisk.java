package com.pranab.playwithgraphs.model;

import com.pranab.playwithgraphs.weightedgraphs.Weight;

public class JourneyRisk implements Weight {

	private int distance;
	private Entity riskFactor;	
	
	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public Entity getRiskFactor() {
		return riskFactor;
	}


	public void setRiskFactor(Entity riskFactor) {
		this.riskFactor = riskFactor;
	}


	@Override
	public int getWeight() {
		return distance+riskFactor.getValue();
	}


	public JourneyRisk(int distance, Entity riskFactor) {
		super();
		this.distance = distance;
		this.riskFactor = riskFactor;
	}

}
