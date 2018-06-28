package com.tpuhalo.spring.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tpuhalo.spring.domain.Organization;

public class OrganizationMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {

		Organization organization = new Organization();

		organization.setId(rs.getInt("id"));
		organization.setCompanyName(rs.getString("company_name"));
		organization.setYear(rs.getInt("year_of_company"));
		organization.setEmpCount(Integer.parseInt(rs.getString("employee_count")));
		organization.setSlogan(rs.getString("slogan"));
		organization.setPostalCode(rs.getString("postal"));

		return organization;
	}
}
