package com.tpuhalo.domain;

import com.tpuhalo.secondMaven.service.BusinessService;

public class Organization {

	private int year;
	private String name;
	private String postalCode;
	private int numOfEmp;
	private String message;
	private BusinessService businessService;

	public Organization() {
		System.out.println("defaultconst");
	}

	public Organization(String name, int year) {
		this.year = year;
		this.name = name;
		System.out.println("realconst");
	}

//	public void initialize() {
//		System.out.println("organization:initalize");
//	}
//
//	public void destroy() {
//		System.out.println("organization:destroy");
//	}

	public static Organization createInstance(String companyName, int year) {
		System.out.println("INvokingthe static method");
		return new Organization(companyName, year);
	}

	public String getName() {
		return name;
	}

	public void setNumOfEmp(int numOfEmp) {
		this.numOfEmp = numOfEmp;
		System.out.println("setemployeecount");

	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("setslogan");

	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("set bussines service");

	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setposlacode");

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
