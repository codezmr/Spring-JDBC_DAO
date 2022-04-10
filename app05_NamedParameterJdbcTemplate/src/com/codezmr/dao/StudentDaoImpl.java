package com.codezmr.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.codezmr.dto.Student;

public class StudentDaoImpl implements StudentDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	
	@Override
	public String add(Student std) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
