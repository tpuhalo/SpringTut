package com.tpuhalo.secondMaven.serviceimpl;

import java.util.Random;

import com.tpuhalo.secondMaven.service.RecruitmentService;

public class AgencyRecruitmentServiceImpl implements RecruitmentService {

	public String recruiEmployees(String companyName, String departmentName, int numOfRecruitments) {

		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " + random.nextInt(numOfRecruitments)
				+ " employees.";
		return hiringFacts;

	}

}
