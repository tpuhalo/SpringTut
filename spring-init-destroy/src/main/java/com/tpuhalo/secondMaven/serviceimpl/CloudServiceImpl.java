package com.tpuhalo.secondMaven.serviceimpl;

import java.util.Random;

import com.tpuhalo.secondMaven.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	public String OfferService(String companyName) {
	
		Random random = new Random();
		String service = "\nAs an organization, "+ companyName + " makes " + random.nextInt(revenue)+ "$.";
		return service;
	}
	
	
	public void postConstruct() {
		System.out.println("cloudservice: postConstruct called********");
	}
	
	public void preDestroy(){
		System.out.println("cloudservice: preDestroy called********");
	}

}
