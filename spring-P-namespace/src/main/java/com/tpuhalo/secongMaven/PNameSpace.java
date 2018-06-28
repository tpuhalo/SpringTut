package com.tpuhalo.secongMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.domain.Organization;

public class PNameSpace {

	public static void main(String[] args) {

		// Application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// Bean
		Organization org = (Organization) ctx.getBean("myOrganization");

		System.out.println(org);

		// Close app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
