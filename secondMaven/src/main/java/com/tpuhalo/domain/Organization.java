package com.tpuhalo.domain;

import com.tpuhalo.secondMaven.service.BusinessService;


public class Organization {

	private int year;
	private String name;

	private String postalCode;
	private int numOfEmp;
	
	private String message;
	private BusinessService businessService;

	
	public Organization(String name, int year) {
		this.year = year;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumOfEmp(int numOfEmp) {
		this.numOfEmp = numOfEmp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String slogan() {
		return message;
	}

	public String corporateService() {
		return businessService.OfferService(name);
	}
	
	@Override
	public String toString() {
		return "Organization [year=" + year + ", name=" + name + ", postalCode=" + postalCode + ", numOfEmp=" + numOfEmp
				+ "]";
	}

}
