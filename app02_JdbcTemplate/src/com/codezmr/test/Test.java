package com.codezmr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codezmr.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/codezmr/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		
	
	
	}

}
