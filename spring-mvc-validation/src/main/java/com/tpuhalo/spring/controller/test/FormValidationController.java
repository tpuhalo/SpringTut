package com.tpuhalo.spring.controller.test;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tpuhalo.spring.domain.test.OrganizationRepresentative;

@Controller
@RequestMapping("/formValidation")
public class FormValidationController {

	private static Logger logger = LoggerFactory.getLogger(FormValidationController.class);

	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formValidationTestView/formValidationHome", "orgrep",
				new OrganizationRepresentative());
	}

	@RequestMapping(value = "/registerOrgRep", method = RequestMethod.POST)
	public String organizationRepresentativeRegistration(
			@Valid @ModelAttribute("orgrep") OrganizationRepresentative orgRepresentative, BindingResult result,
			Model model) {
		// debug
		if (result.hasErrors()) {

			model.addAttribute("formerroes", result.getAllErrors());
			List<FieldError> ferrList = result.getFieldErrors();
			for (FieldError ferr : ferrList) {
				logger.info("field error:" + ferr.getDefaultMessage());
			}

			List<ObjectError> gerrFeList = result.getAllErrors();
			for (ObjectError gerr : gerrFeList) {
				logger.info("global error" + gerr.getDefaultMessage());
			}

			return "test/formValidationTestView/formValidationHome";
		} else {
			return "test/formValidationTestView/formValidationResult";
		}
	}

}
