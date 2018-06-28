package com.tpuhalo.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.tpuhalo.spring.domain.Organization;

public interface OrganizationDao {

	//Set data-source
	public void setDataSource(DataSource ds);
	
	//Create a record 
	public boolean create(Organization org);
	
	//Retrieve a single organization
	public Organization getOrganization(Integer id);
	
	//Retrieve all 
	public List<Organization> getAllOrganizations();
	
	//Delete specific organizatioon
	public boolean delete(Organization org);
	
	//Update an existing org
	public boolean update(Organization org);
	
	//
	public void cleanup();
	
	
}
