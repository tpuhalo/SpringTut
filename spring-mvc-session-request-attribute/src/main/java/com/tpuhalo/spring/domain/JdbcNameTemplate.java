package com.tpuhalo.spring.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.tpuhalo.spring.dao.OrganizationDao;

@Component
public class JdbcNameTemplate {
	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {

		daoUtils.createSeedData(dao);

		// List organizations
		List<Organization> organizations = dao.getAllOrganizations();
		daoUtils.printOrganizations(organizations, daoUtils.readOperation);

		// Create new org record
		Organization organization = new Organization("GBN", 1978, "19022", 4598, "Slogan89");
		boolean isCreated = dao.create(organization);
		daoUtils.printSuccesFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizationCount(organizations, daoUtils.createOperation);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		// Printing one row
		Organization oneOrg = dao.getOrganization(2);
		daoUtils.printOrganization(oneOrg, "getOrganizations");

		// Updating a slogan
		Organization organization3 = dao.getOrganization(1);
		organization3.setSlogan("We are always the best");
		boolean isUpdated = dao.update(organization3);
		daoUtils.printSuccesFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(1), daoUtils.updateOperation);

		// Deleting row
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccesFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);

		// Cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);

	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		JdbcNameTemplate mainApp = ctx.getBean(JdbcNameTemplate.class);
		mainApp.actionMethod();
		((ClassPathXmlApplicationContext) ctx).close();


//		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		
		

	}

}
