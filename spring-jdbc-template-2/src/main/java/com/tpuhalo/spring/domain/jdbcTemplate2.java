package com.tpuhalo.spring.domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.spring.dao.OrganizationDao;

public class jdbcTemplate2 {

	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");

		//Creating seed data
		DaoUtils.createSeedData(dao);
		
		//List organizations
		List<Organization> organizations = dao.getAllOrganizations();
		DaoUtils.printOrganizations(organizations, DaoUtils.readOperation);
		
		//Create new org record
		Organization organization = new Organization("GBN", 1978, "19022", 4598, "Slogan89");
		boolean isCreated = dao.create(organization);
		DaoUtils.printSuccesFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizationCount(organizations, DaoUtils.createOperation);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.readOperation);
		
		//Printing one row
		Organization oneOrg = dao.getOrganization(2);
		DaoUtils.printOrganization(oneOrg, "getOrganizations");
		
		//Updating a slogan
		Organization organization3 = dao.getOrganization(1);
		organization3.setSlogan("We are always the best");
		boolean isUpdated = dao.update(organization3);
		DaoUtils.printSuccesFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(1),DaoUtils.updateOperation);
		
		//Deleting row
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		DaoUtils.printSuccesFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.deleteOperation);
		
		//Cleanup
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganizations(), DaoUtils.cleanupOperation);
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
