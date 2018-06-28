package com.tpuhalo.spring.service.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {

	@Value("#{serviceLengthOptions}")
	private Map<String, String> serviceLengthList;

	public Map<String, String> populateTurnover() {
		Map<String, String> turnover = new LinkedHashMap<String, String>();
		turnover.put("none", "---SELECT---");
		turnover.put("1000", "less than 1000");
		turnover.put("10000", "Greater than 1000 but less then 10000");
		turnover.put("100000", "Greater than 10000 but less then 100000");
		return turnover;
	}

	public Map<String, String> populateTypes() {
		Map<String, String> types = new LinkedHashMap<String, String>();
		types.put("gov", "Goverment");
		types.put("semigov", "Semi Goverment");
		types.put("private", "Private");
		return types;
	}

	public Map<String, String> populateServiceLength() {
		return new TreeMap<String, String>(serviceLengthList);
	}

	public Map<String, String> populateRegisteredPreviously() {
		Map<String, String> registeredPreviously = new LinkedHashMap<String, String>();
		registeredPreviously.put("true", "Yes");
		registeredPreviously.put("false", "No");
		return registeredPreviously;
	}

	public Map<String, String> populateOptionalServices() {
		Map<String, String> optionalServices = new LinkedHashMap<String, String>();
		optionalServices.put("emailService", "Mailing list");
		optionalServices.put("promotionalService", "Promo");
		optionalServices.put("weeklyUpdate", "Weekly update");
		return optionalServices;
	}

	public Map<String, String> populatePremiumServices() {
		Map<String, String> premiumServices = new LinkedHashMap<String, String>();
		premiumServices.put("directorService", "Director");
		premiumServices.put("revenueReportService", "Revenue Reports");
		premiumServices.put("revenueAnalyticsUpdate", "Revenue analytics");
		return premiumServices;
	}

	public Map<String, String> populateEmployeeStrength() {
		Map<String, String> employeeStrength = new LinkedHashMap<String, String>();
		employeeStrength.put("small", "Large");
		employeeStrength.put("medium", "Medium");
		employeeStrength.put("large", "Large");
		return employeeStrength;
	}
}
