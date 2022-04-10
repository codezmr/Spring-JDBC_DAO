package com.codezmr.dao;

import com.codezmr.dto.Student;

public interface StudentDao {
	public String add(Student std);
	public Student search(String sid);
	public String update(String sid);
	public String delete(String sid);
}
