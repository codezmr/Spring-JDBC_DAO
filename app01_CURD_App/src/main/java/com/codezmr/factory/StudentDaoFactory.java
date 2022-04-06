package com.codezmr.factory;

import com.codezmr.dao.StudentDao;
import com.codezmr.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDao studentDao;
	
	static {
		studentDao = new StudentDaoImpl();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
