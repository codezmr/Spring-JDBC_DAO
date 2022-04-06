package com.codezmr.service;

import com.codezmr.dao.StudentDao;
import com.codezmr.dto.Student;
import com.codezmr.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao = StudentDaoFactory.getStudentDao();

	@Override
	public String addStudent(Student std) {
		
		String status  = studentDao.add(std);
		
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		Student std = studentDao.search(sid);
		return std;
	}

	@Override
	public String deleteStudent(String sid) {
		String status = studentDao.delete(sid);
		return status;
	}

}
