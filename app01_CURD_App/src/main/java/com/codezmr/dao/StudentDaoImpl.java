package com.codezmr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.codezmr.dto.Student;
import com.codezmr.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
		String status = "";
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst  = con.prepareStatement("select * from servletStudent where sid= ?");
			pst.setString(1, std.getSid());
			ResultSet rs = pst.executeQuery();
			
			boolean b = rs.next();
			
			if(b==true) {
				status = "existed";
			}else {
				
				pst = con.prepareStatement("insert into servletStudent values(?,?,?)");
				
				pst.setString(1, std.getSid());
				pst.setString(2, std.getSname());
				pst.setString(3, std.getSaddr());
				
				int rowCount = pst.executeUpdate();
				
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
			}
			
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		
		Student std = null;
		try {

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst  = con.prepareStatement("select * from servletStudent where sid= ?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();
			
			boolean b = rs.next();
			
			
			if(b==true) {
				
				std = new Student();
				std.setSid(rs.getString("sid"));
				std.setSname(rs.getString("sname"));
				std.setSaddr(rs.getString("saddr"));
				
			}else {
				std = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return std;
	}

	@Override
	public String delete(String sid) {
		String status = "";
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst  = con.prepareStatement("select * from servletStudent where sid= ?");
			pst.setString(1, sid);
			ResultSet rs = pst.executeQuery();
			
			boolean b = rs.next();
			if(b == true) {
				
				pst = con.prepareStatement("delete from servletStudent where SID = ?");
				pst.setString(1, sid);
				int rowCount = pst.executeUpdate();
				
				if(rowCount == 1) {
					status = "success";
				}else {
					status = "failure";
				}
				
			}else {
				status = "notexisted";
			}
			
			
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

}
