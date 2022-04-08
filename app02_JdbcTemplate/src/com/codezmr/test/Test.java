package com.codezmr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codezmr.dao.EmployeeDao;
import com.codezmr.dto.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/codezmr/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		Employee employee = new Employee();
		employee.setEno("E-222");
		employee.setEname("ZMR");
		employee.setEsal(80000);
		employee.setEaddr("BPL");
		
		String status = employeeDao.add(employee);
		System.out.println(status);
		
	
	
	}

}
