package com.codezmr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codezmr.dao.EmployeeDao;
import com.codezmr.dto.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/codezmr/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		/*
		Employee employee = new Employee();
		employee.setEno("E-222");
		employee.setEname("ZMR");
		employee.setEsal(80000);
		employee.setEaddr("BPL");
		
		String status = employeeDao.add(employee);
		System.out.println(status);
		*/
		
		Employee emp = employeeDao.search("E-222");
		if(emp==null) {
			System.out.println("Employee Not Existed.");
		}else{
			System.out.println("Employee Details");
			System.out.println("-----------------------");
			System.out.println("Employee Number    : "+ emp.getEno());
			System.out.println("Employee Name      : "+ emp.getEname());
			System.out.println("Employee Salary    : "+ emp.getEsal());
			System.out.println("Employee Address   : "+ emp.getEaddr());
		}
	
	}

}
