package com.tpuhalo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpuhalo.spring.service.GenericWelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping
	public String doWelcome(Model model) {
		
		
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("John Wick");
		
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		return "welcomeNew";
		
	}
	
}
