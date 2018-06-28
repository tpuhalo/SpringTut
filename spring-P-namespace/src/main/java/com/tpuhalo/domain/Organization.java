package com.tpuhalo.domain;

public class Organization {

	private int year;
	private String name;
	private Address address;

	public void setYear(int year) {
		this.year = year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Organization [year=" + year + ", name=" + name + ", address=" + address + "]";
	}

}
