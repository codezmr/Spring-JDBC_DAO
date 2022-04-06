package com.codezmr.factory;

import com.codezmr.service.StudentService;
import com.codezmr.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	
	static {
		studentService = new StudentServiceImpl();
	}
	
	public static StudentService getStudentService() {
		
		return studentService;
	}
}
