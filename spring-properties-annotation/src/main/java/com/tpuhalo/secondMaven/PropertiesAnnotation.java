package com.tpuhalo.secondMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tpuhalo.secondMaven.domain.Organization;

public class PropertiesAnnotation {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization organization = (Organization) ctx.getBean("myOrganization");
		
		System.out.println(organization);
		System.out.println("Slogan: " + organization.slogan());
		((AnnotationConfigApplicationContext) ctx).close();
		
	}
}
