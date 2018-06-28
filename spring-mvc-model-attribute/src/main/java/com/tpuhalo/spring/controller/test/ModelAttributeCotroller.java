package com.tpuhalo.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tpuhalo.spring.domain.Address;

@Controller
public class ModelAttributeCotroller {

	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeCotroller.class);

	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home:" + System.currentTimeMillis());
		return "modelAttributeHome";
	}

	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("modelAttributeHome");
		modelAndView.addObject("command", new Address());
		return modelAndView;
	}

	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView modelAndView = new ModelAndView("modelAttributeHome");
		modelAndView.addObject("anAddress", new Address());
		return modelAndView;
	}

	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Zagreb", "120343"));
	}

	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Bjelovar", "2000"));
		return "modelAttributeHome";
	}

	// Test series to determine the nature @ModelAttribue
	@ModelAttribute
	public void modelAttributeTest1(Model model) {

		LOGGER.info("INSIDE modelAttributeTest1:" + System.currentTimeMillis());
		model.addAttribute("testdata1a", "Welcome to the @ModelAttribute Test bed");
		model.addAttribute("testdata1b", "We will test both usage of the @ModelAttribute");
	}

	// Test of usage of the name attribute
	@ModelAttribute(name = "testdata2")
	public String modelAttribute2() {
		LOGGER.info("INSIDE modelatributte2");
		return "We will conduct a series of tests here";
	}
	// Test usage of the @modelAtribute to implicity add an attribute

	@ModelAttribute(value = "testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAtributte3");
		return new Address("Zagreb", "1000");
	}

	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("inside modelAtributeTest4");
		return new Address("Osijek", "23000");
	}

	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value = "anAdress") Address anAddress, ModelMap model) {
		model.addAttribute("testdata5a", anAddress.getCity());
		model.addAttribute("testdata5b", anAddress.getZipCode());
		return "modelAttributeTest";
	}

	@RequestMapping(value = "/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Žirjevo", "320482");
	}

}
