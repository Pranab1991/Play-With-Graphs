package com.pranab.playwithgraphs.model;

public class Profile {
	private String firstName;
	private String lastName;
	private String company;
	private String[] skills;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public Profile(String firstName, String lastName, String company, String[] skills) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.skills = skills;
	}
	public Profile() {
		super();
	}	
}
