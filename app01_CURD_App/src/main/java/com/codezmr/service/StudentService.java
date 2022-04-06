package com.codezmr.service;

import com.codezmr.dto.Student;

public interface StudentService {
	public String addStudent(Student std);
	public Student searchStudent(String sid);
	public String deleteStudent(String sid);
}
