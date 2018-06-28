package com.tpuhalo.secongMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpuhalo.domain.promotion.TradeFair;

public class ComponentAnnotation {

	public static void main(String[] args) {

		// Application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// Bean
		TradeFair tradefair = (TradeFair) ctx.getBean("tradefair");
		System.out.println(tradefair.specialPromotionalPricing());
		
		// Close app context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
