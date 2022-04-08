package com.codezmr.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.codezmr.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String add(Employee emp) {
		
		String status = "";
		try {
						
			List<Employee> empList = jdbcTemplate.query("select * from employee_db where eno = '"+ emp.getEno()+"'", (rs, index)-> { // remove EmployeeRowMapper and use lambda expression
				
				Employee employee = new Employee();
				employee.setEno(rs.getString("eno"));
				employee.setEname(rs.getString("ename"));
				employee.setEsal(rs.getFloat("esal"));
				employee.setEaddr(rs.getString("eaddr"));
				
				return employee;
			});
				
			  if(empList.isEmpty() == true) {
					
				   int rowCount = jdbcTemplate.update("insert into employee_db values("+"'"+emp.getEno()+"','"+emp.getEname()+"',"+emp.getEsal()+",'"+emp.getEaddr()+"')");
					
					   if(rowCount == 1) {
							status = "Employee inserted Success";
						}else {
							status = "Employee insertion failure";
						}
					
				}else {
					status ="Employee existed already.";
				}
			
			} catch (Exception e) {
				status = "Employee insertion failure";
				e.printStackTrace();
			}
		
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
