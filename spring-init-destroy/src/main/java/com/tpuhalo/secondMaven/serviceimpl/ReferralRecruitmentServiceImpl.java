package com.tpuhalo.secondMaven.serviceimpl;

import java.util.Random;

import com.tpuhalo.secondMaven.service.RecruitmentService;

public class ReferralRecruitmentServiceImpl implements RecruitmentService {

	public String recruiEmployees(String companyName, String departmentName, int numOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " + random.nextInt(numOfRecruitments)
				+ " employees which were referred to company.";
		return hiringFacts;
	}

}
