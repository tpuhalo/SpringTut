package com.tpuhalo.secondMaven.serviceimpl;

import java.util.Random;

import com.tpuhalo.secondMaven.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

	public String OfferService(String companyName) {
		Random random = new Random();
		String service = "\nAs an organization, "+ companyName + " provides Ecommerce platform in " + random.nextInt(200) + " countries.";
		return service;
	}

}
