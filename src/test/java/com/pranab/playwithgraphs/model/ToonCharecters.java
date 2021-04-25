package com.pranab.playwithgraphs.model;

public class ToonCharecters {

	private String name;
	private String featuringMovie;
	private String moto;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeaturingMovie() {
		return featuringMovie;
	}
	public void setFeaturingMovie(String featuringMovie) {
		this.featuringMovie = featuringMovie;
	}
	public String getMoto() {
		return moto;
	}
	public void setMoto(String moto) {
		this.moto = moto;
	}
	public ToonCharecters(String name, String featuringMovie, String moto) {
		super();
		this.name = name;
		this.featuringMovie = featuringMovie;
		this.moto = moto;
	}
	public ToonCharecters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
