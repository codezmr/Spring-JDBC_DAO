package com.codezmr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codezmr.dao.StudentDao;
import com.codezmr.dto.Student;

public class Test {

	public static void main(String[] args) {
		
		//Step-1 Getting ApplicationContext object 
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/codezmr/resources/applicationContext.xml");
		
		//Step-2 Get Dao implementation (StudentDaoImpl) object 
		StudentDao studentDao  = (StudentDao) context.getBean("studentDao");
		
		/*
		 * Student std = new Student(); std.setSid("S-111"); std.setSname("AAA");
		 * std.setSaddr("IND"); String status = studentDao.add(std);
		 * System.out.println(status);
		 */
		
		Student std = studentDao.search("S-112");
		
		if(std == null) {
			System.out.println("Student Not Existed.");
		}else {
		  System.out.println("Student Details");
		  System.out.println("-----------------------");
		  System.out.println("Studnet Id        : "+ std.getSid());
		  System.out.println("Student Name      : "+ std.getSname());
		  System.out.println("Studnet Address   : "+ std.getSaddr());
		}
		
	}

}
