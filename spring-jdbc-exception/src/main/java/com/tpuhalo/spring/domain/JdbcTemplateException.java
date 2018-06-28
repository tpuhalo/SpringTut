package com.tpuhalo.spring.domain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.tpuhalo.spring.dao.OrganizationDao;

public class JdbcTemplateException {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		List<Organization> organizations = null;
		try {
			organizations = dao.getAllOrganizations();
		} catch (BadSqlGrammarException eg) {
			System.out.println(eg.getMessage());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println("\n" + e.getClass());
		}
		for (Organization organization : organizations) {
			System.out.println(organization);
		}

		((ClassPathXmlApplicationContext) ctx).close();
	}

}
