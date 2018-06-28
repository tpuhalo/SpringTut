package com.tpuhalo.domain;

public class Organization {

	private int year;
	private String name;
	private Address address;



	public Organization(int year, String name, Address address) {
		this.year = year;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Organization [year=" + year + ", name=" + name + ", address=" + address + "]";
	}


}
