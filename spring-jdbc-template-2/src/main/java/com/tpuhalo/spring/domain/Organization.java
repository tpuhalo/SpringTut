package com.tpuhalo.spring.domain;

public class Organization {
	private int id;
	private String companyName;
	private int year;
	private String postalCode;
	private int empCount;
	private String slogan;

	public Organization() {
	}

	public Organization(String companyName, int year, String postalCode, int empCount, String slogan) {
		this.companyName = companyName;
		this.year = year;
		this.postalCode = postalCode;
		this.empCount = empCount;
		this.slogan = slogan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", year=" + year + ", postalCode="
				+ postalCode + ", empCount=" + empCount + ", slogan=" + slogan + "]";
	}

}
