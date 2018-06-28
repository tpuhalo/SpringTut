package com.tpuhalo.secondMaven.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.tpuhalo.secondMaven.service.BusinessService;

@Component("myOrganization")
public class Organization {

	@Value("${year}")
	private int year;

	@Value("${nameOfCompany}")
	private String name;

	@Value("${postal}")
	private String postalCode;

	@Value("${numOfEmp:234}")
	private int numOfEmp;

	@Value("${slogan:Super smo si}")
	private String message;

	@Value("${statement}")
	private String statement;
	
	@Autowired
	private Environment enviroment;
	
	private BusinessService businessService;

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
		statement = enviroment.getProperty("statement");
		return message + " i " + statement;
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
