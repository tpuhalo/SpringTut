package com.tpuhalo.secondMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.domain.Organization;
import com.tpuhalo.domain.promotion.TradeFair;

public class PropertiesXML {

	public static void main(String[] args) {

		// Application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// Bean
		Organization organization = (Organization) ctx.getBean("myOrganization");
		System.out.println(organization);
		
		// Close app context
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
