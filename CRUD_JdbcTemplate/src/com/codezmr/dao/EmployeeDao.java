package com.codezmr.dao;

import com.codezmr.dto.Employee;

public interface EmployeeDao {
	public String add(Employee employee);
	public Employee search(String eno);
	public String update(Employee employee);
	public String delete(String eno);
}
