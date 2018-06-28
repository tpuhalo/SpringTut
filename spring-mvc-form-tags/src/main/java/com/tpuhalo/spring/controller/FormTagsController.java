package com.tpuhalo.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tpuhalo.spring.domain.test.OrganizationRegistration;
import com.tpuhalo.spring.service.test.OrganizationRegistrationService;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagsController {

	@Autowired
	private OrganizationRegistrationService orgRegService;

	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formTagsTestViews/formTagsHome", "orgRegistration",
				new OrganizationRegistration());
	}

	@RequestMapping(value = "/registerOrg", method = RequestMethod.POST)
	public String organizationRegistration(@ModelAttribute OrganizationRegistration orgRegistration, Model model) {
		model.addAttribute("orgreg", orgRegistration);
		return "test/formTagsTestViews/formTagsResult";
	}

	@ModelAttribute
	public void populateFormObjectWithData(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("turnoverlist", orgRegService.populateTurnover());
		map.put("typelist", orgRegService.populateTypes());
		map.put("serviceLength", orgRegService.populateServiceLength());
		map.put("registeredPreviouslyList", orgRegService.populateRegisteredPreviously());
		map.put("subscriptionList", orgRegService.populateOptionalServices());
		map.put("premiumServicesList", orgRegService.populatePremiumServices());
		map.put("employeeStrengthList", orgRegService.populateEmployeeStrength());

	}

}