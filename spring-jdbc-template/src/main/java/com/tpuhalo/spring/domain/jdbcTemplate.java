package com.tpuhalo.spring.domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.spring.dao.OrganizationDao;

public class jdbcTemplate {

	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		List<Organization> organizations = dao.getAllOrganizations();
		for(Organization organization: organizations) {
			System.out.println(organization);
		}
		
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
