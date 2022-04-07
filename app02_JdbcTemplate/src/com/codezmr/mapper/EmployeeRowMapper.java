package com.codezmr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codezmr.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEno(rs.getString("eno"));
		employee.setEname(rs.getString("ename"));
		employee.setEsal(rs.getFloat("esal"));
		employee.setEaddr(rs.getString("eaddr"));
		
		return employee;
	}

}
