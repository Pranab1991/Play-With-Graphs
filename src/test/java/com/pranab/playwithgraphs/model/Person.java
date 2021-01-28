package com.pranab.playwithgraphs.model;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
	private String name;
	private Character gender;
	private LocalDate dob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + gender;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person(String name, char gender, LocalDate dob) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}

	public Person() {
		super();
	}

	@Override
	public int compareTo(Person person) {
		int dobComparisionResult = this.dob.compareTo(person.getDob());
		if (dobComparisionResult != 0) {
			return dobComparisionResult;
		}
		int genderComparisionResult = this.gender.compareTo(person.getGender());
		if (genderComparisionResult != 0) {
			return genderComparisionResult;
		}
		return this.name.compareTo(person.getName());
	}

}
