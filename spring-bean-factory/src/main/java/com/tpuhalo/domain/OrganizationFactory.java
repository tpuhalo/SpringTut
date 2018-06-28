package com.tpuhalo.domain;

public class OrganizationFactory {

	public Organization getInstance(String name, int year) {
		
		System.out.println("Invoking instance factory method");
		return new Organization(name, year);
		
	}
}
