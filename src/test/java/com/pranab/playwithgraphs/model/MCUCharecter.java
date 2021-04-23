package com.pranab.playwithgraphs.model;

import java.util.ArrayList;
import java.util.List;

public class MCUCharecter {

	private String name;
	private List<String> powers = new ArrayList<>();
	private boolean infinityStoneKeeper;
	private String stone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPowers() {
		return powers;
	}

	public void setPowers(List<String> powers) {
		this.powers = powers;
	}

	public boolean isInfinityStoneKeeper() {
		return infinityStoneKeeper;
	}

	public void setInfinityStoneKeeper(boolean infinityStoneKeeper) {
		this.infinityStoneKeeper = infinityStoneKeeper;
	}

	public String getStone() {
		return stone;
	}

	public void setStone(String stone) {
		this.stone = stone;
	}

	public MCUCharecter() {
		super();
	}

	public MCUCharecter(String name, List<String> powers, boolean infinityStoneKeeper, String stone) {
		super();
		this.name = name;
		this.powers = powers;
		this.infinityStoneKeeper = infinityStoneKeeper;
		this.stone = stone;
	}

}
