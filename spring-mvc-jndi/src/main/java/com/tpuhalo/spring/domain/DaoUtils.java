package com.tpuhalo.spring.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tpuhalo.spring.dao.OrganizationDao;

@Service
public class DaoUtils {

	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> org, String operation) {

		System.out.println("\nPrint organization after: " + operation);
		for (Organization organization : org)
			System.out.println(organization);

	}

	public void printOrganization(Organization organization, String operation) {

		System.out.println("\nPrinting organization after " + operation + "\n" + organization);
	}

	public void printSuccesFailure(String operation, boolean param) {
		if (param)
			System.out.println("\nOperation " + operation + " succesful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}

	public void createSeedData(OrganizationDao dao) {

		Organization org1 = new Organization("Amazon", 1994, "23245", 300, "Slogan1");
		Organization org2 = new Organization("Google", 1998, "10245", 3, "Slogan2");
		Organization org3 = new Organization("Alibaba", 2005, "3245", 1000, "Slogan3");

		List<Organization> organizations = new ArrayList<Organization>();

		organizations.add(0, org1);
		organizations.add(1, org2);
		organizations.add(2, org3);

		int createCount = 0;
		for (Organization org : organizations) {
			boolean isCreated = dao.create(org);
			if (isCreated)
				createCount++;
		}
		System.out.println("\nCreated " + createCount);
	}

	public void printOrganizationCount(List<Organization> org, String operation) {
		System.out.println("\nCurrently we have " + org.size() + " organizations after " + operation + "******");
	}

}
