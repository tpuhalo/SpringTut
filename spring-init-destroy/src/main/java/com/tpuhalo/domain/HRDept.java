package com.tpuhalo.domain;

import com.tpuhalo.secondMaven.service.RecruitmentService;

public class HRDept implements Department {

	private String departmentName;
	private RecruitmentService recruitmentService;
	private Organization organization;

	public HRDept(RecruitmentService recruitmentService, Organization organization) {
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String hiringStatus(int numberOfRecruitments) {
		return recruitmentService.recruiEmployees(organization.getName(), departmentName, numberOfRecruitments);
	}

}
