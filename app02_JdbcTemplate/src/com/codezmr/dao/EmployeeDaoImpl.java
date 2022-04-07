package com.codezmr.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.codezmr.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String add(Employee employee) {
		
		String status = "";
		
		
		return status;
	}

	@Override
	public Employee search(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

}
