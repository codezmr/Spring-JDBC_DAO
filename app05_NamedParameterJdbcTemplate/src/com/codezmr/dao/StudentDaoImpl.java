package com.codezmr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.codezmr.dto.Student;

public class StudentDaoImpl implements StudentDao {
	
	DriverManagerDataSource dataSource;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	
	@Override
	public String add(Student std) {
		
		/*
		 * Provide NamedParameter in this example
		 * and provide value to this NamedParmeter through Map object
		 * */
		
		
		String status = "";
		
		String query = "";
		try {
			
			/*
			 * we have already data in the form of Student 'std'
			 * 
			 * We have to check student is exist or not if student is existed so return
			 * Student existed else insert data into database and return inserted success
			 */
			
			query = "select * from student_db where sid = :sid";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("sid", std.getSid());
			
			List<Student> studentList = namedParameterJdbcTemplate.query(query, params, (rs,index) ->{
				
				Student std1 = new Student();
				
					std1.setSid(rs.getString("sid"));
					std1.setSname(rs.getString("sanme"));
					std1.setSaddr(rs.getString("saddr"));
				
				return std1;
				
				/*
				 * Mapper main intention is it will copy the data from ResultSet rs object
				 * and data will be store in bean object
				 * so finally all the bean object will be prepared 
				 * that and all the bean object will be store in the form of List studentList object
				 * */
			});
			
			//check student is existed or not
			if(studentList.isEmpty() == true) {
				
				query = "insert into student_db values(:sid, :sname, :saddr)";
				params  = new HashMap<String, Object>();
				params.put("sid", std.getSid());
				params.put("sname", std.getSname());
				params.put("saddr", std.getSaddr());
				
				int rowCount = namedParameterJdbcTemplate.update(query, params);
				
				if(rowCount == 1) {
					status = "Student Insterted Successfully.";
				}else {
					status = "Student Insterted Failure.";

				}
			}
			 else {
				 status = "Student Existed Already.";
			 }
			
			
		} catch (Exception e) {
			status = "Student Insterted Failure.";
			e.printStackTrace();
		}
		return status;
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
