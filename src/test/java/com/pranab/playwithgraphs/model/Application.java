package com.pranab.playwithgraphs.model;

public class Application {
	private float amount;
	private int terms;
	private float premium;
	private float maturityAmmount;
	private int order;

	public int getOrder() {
		return order;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setMaturityAmmount(float maturityAmmount) {
		this.maturityAmmount = maturityAmmount;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getTerms() {
		return terms;
	}

	public void setTerms(int terms) {
		this.terms = terms;
	}

	public float getPremium() {
		return premium;
	}

	public void setPremium(float premium) {
		this.premium = premium;
	}

	public float getAmount() {
		return amount;
	}

	public float getMaturityAmmount() {
		return maturityAmmount;
	}

	public Application(float amount, int terms) {
		super();
		this.amount = amount;
		this.terms = terms;
	}

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

}
