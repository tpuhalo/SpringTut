package com.tpuhalo.spring.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpuhalo.spring.service.RandomizerRequestScope;
import com.tpuhalo.spring.service.RandomizerSessionScope;

@Controller
public class ScoppedController {
	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	@Autowired
	RandomizerSessionScope randomizerSessionScope;

	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception {

		response.getWriter().write("******* Request scope ******");
		response.getWriter().write("Old number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference " + randomizerRequestScope + "<br>");
		
		response.getWriter().write("******* Session scope ******");
		response.getWriter().write("Old number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference " + randomizerSessionScope + "<br>");	
	}

}
