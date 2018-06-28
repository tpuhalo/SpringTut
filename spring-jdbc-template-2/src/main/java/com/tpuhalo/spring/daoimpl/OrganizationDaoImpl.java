package com.tpuhalo.spring.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tpuhalo.spring.dao.OrganizationDao;
import com.tpuhalo.spring.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {

		jdbcTemplate = new JdbcTemplate(ds);
	}

	public boolean create(Organization org) {
		String sql = "INSERT INTO organization (company_name, year_of_company, postal, employee_count, slogan) "
				+ "VALUES(?, ? , ?, ?, ?)";
		Object[] args = new Object[] { org.getCompanyName(), org.getYear(), org.getPostalCode(), org.getEmpCount(),
				org.getSlogan() };
		return jdbcTemplate.update(sql, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		String sql = "SELECT id, company_name, year_of_company, postal, employee_count, slogan "
				+ "FROM organization WHERE id = ?";
		Object[] arg = new Object[] { id };
		Organization organization = jdbcTemplate.queryForObject(sql, arg, new OrganizationMapper());
		return organization;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		String sql = "DELETE FROM organization WHERE id = ?";
		Object[] arg = new Object[] {org.getId()};
		return jdbcTemplate.update(sql, arg) == 1;
				
	}

	public boolean update(Organization org) {
		String sql = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] arg = new Object[] { org.getSlogan(), org.getId() };
		return jdbcTemplate.update(sql, arg) == 1;

	}

	public void cleanup() {
		String sql = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sql);

	}

}
