package com.tpuhalo.spring.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	private String home() {
		return "requestMappingAndParamHome";

	}

	// test 1
	@RequestMapping(value = "/test1")
	public String requestMappingAndParam(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";

	}

	// test2
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}

	// test3
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgname", defaultValue = "Anonymus Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}

	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "empcount", "orgname" })
	public String requestMappingAndParamTest6Subtest3(@RequestParam String empcount, @RequestParam String orgname,
			Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}

	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "empcount", "orgname" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");
		return "requestMappingAndParamResults2";
	}

	@RequestMapping(value = { "/test7", "/test8" }, method = RequestMethod.GET)
	public String requestMappingAndParamTest67and8(@RequestParam String orgname, Model model,
			HttpServletRequest request) {
		model.addAttribute("orgname", orgname);
		LOGGER.info(request.getRequestURL().toString());
		if (request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testserial", "test7");
		} else {
			model.addAttribute("testserial", "test8");
		}
		return "requestMappingAndParamResults2";
	}
}
