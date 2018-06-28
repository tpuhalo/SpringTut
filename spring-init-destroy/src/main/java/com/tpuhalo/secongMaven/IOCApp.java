package com.tpuhalo.secongMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.domain.HRDept;
import com.tpuhalo.domain.Organization;

public class IOCApp {

	public static void main(String[] args) {

		// Application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		// Bean
//		Organization org = (Organization) ctx.getBean("myOrganization");
//		Organization org2 = (Organization) ctx.getBean("myOrganization");
//		org2.setPostalCode("12300");

//		HRDept hrd = (HRDept) ctx.getBean("myhrdept");
		// Invoke slogan
//		System.out.println(org.slogan());
//		System.out.println(org);
//		System.out.println(org.corporateService());
//		System.out.println(hrd.hiringStatus(550));

		// Close app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}

