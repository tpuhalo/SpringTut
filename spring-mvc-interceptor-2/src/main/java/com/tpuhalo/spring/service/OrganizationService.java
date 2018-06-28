package com.tpuhalo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpuhalo.spring.dao.OrganizationDao;
import com.tpuhalo.spring.domain.Organization;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;

	public List<Organization> getOrgList() {
		
		return organizationDao.getAllOrganizations();
	}
}
