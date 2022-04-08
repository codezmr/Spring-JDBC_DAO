package com.codezmr.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.codezmr.dto.Employee;
import com.codezmr.mapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String add(Employee emp) {
		
		String status = "";
		try {
						
			List<Employee> empList = jdbcTemplate.query("select * from employee_db where eno = '"+ emp.getEno()+"'", new EmployeeRowMapper());
				
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
	public Employee search(String eno) {
		
		Employee emp = null;
		
		try {
			
			  List<Employee> empList = jdbcTemplate.query("select * from employee_db where eno = '"+ eno+"'", new EmployeeRowMapper());
			  boolean b = empList.isEmpty();
			  if(b == true ) {
				  emp = null;
			  }else {
				  emp = empList.get(0);
			  }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public String update(Employee employee) {

		String status = "";
		
		try {
				int rowCount = jdbcTemplate.update("update employee_db set ename = '"+employee.getEname()+"', esal = "+employee.getEsal()+", eaddr = '"+employee.getEaddr()+"' where eno = '"+employee.getEno()+"'");                                   
				if(rowCount == 1) {
					System.out.println("Employee Updated Successfully.");
				}else {
					System.out.println("Employee Update Failure.");
				}

		} catch (Exception e) {
			status = "Employee Update Failure.";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String delete(String eno) {
		
		String status = "";
		
		try {
			Employee emp = search(eno);
			if(emp == null) {
				status = "Employee Not Existed";
			}else {
				int rowCount = jdbcTemplate.update("delete from employee_db where eno = '"+eno+"'");
				if(rowCount == 1) {
					
					status = "Employee Deleted Successfully.";
				}else {
					status = "Employee Deletion Failure";
				}
			}
			
			
		} catch (Exception e) {
			status = "Employee Deletion Failure";
			e.printStackTrace();
		}
		return status;
	}

}
