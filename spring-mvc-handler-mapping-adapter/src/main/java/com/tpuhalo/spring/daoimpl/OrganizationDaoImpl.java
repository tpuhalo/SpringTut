package com.tpuhalo.spring.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.tpuhalo.spring.dao.OrganizationDao;
import com.tpuhalo.spring.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {

		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Organization org) {

		SqlParameterSource beanParam = new BeanPropertySqlParameterSource(org);
		String sql = "INSERT INTO organization (company_name, year_of_company, postal, employee_count, slogan) "
				+ "VALUES(:companyName, :year , :postalCode, :empCount, :slogan)";

		return namedParameterJdbcTemplate.update(sql, beanParam) == 1;
		// Object[] args = new Object[] { org.getCompanyName(), org.getYear(),
		// org.getPostalCode(), org.getEmpCount(),
		// org.getSlogan() };
		// return jdbcTemplate.update(sql, args) == 1;
	}

	public Organization getOrganization(Integer id) {

		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sql = "SELECT id, company_name, year_of_company, postal, employee_count, slogan "
				+ "FROM organization WHERE id = :ID";
		Organization organization = namedParameterJdbcTemplate.queryForObject(sql, params, new OrganizationMapper());
		return organization;

		// Object[] arg = new Object[] { id };

	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sql = "DELETE FROM organization WHERE id = :id";
		// Object[] arg = new Object[] { org.getId() };
		return namedParameterJdbcTemplate.update(sql, beanParams) == 1;

	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sql = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		// Object[] arg = new Object[] { org.getSlogan(), org.getId() };
		return namedParameterJdbcTemplate.update(sql, beanParams) == 1;

	}

	public void cleanup() {
		String sql = "TRUNCATE TABLE organization";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sql);

	}

}
