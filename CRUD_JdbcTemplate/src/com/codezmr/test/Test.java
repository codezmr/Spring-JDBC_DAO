package com.codezmr.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codezmr.dao.EmployeeDao;
import com.codezmr.dto.Employee;

public class Test {

	public static void main(String[] args)throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/codezmr/resources/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("1. ADD Employee");
			System.out.println("2. SEARCH Employee");
			System.out.println("3. UPDATE Employee");
			System.out.println("4. DELETE Employee");
			System.out.println("5. EXIT");
			System.out.print("Your Option[1,2,3,4,5] : ");
			int option  = Integer.parseInt(br.readLine());
			System.out.println();
			
			Employee emp = null;
			String status = "";
			
			String eno = "" , ename = "", eaddr = "";
			float esal = 0;
			
			switch (option) {
				
			case 1:
				System.out.println("***|| ADD Employee ||***");
				
				System.out.print("Employee No    : ");
				eno = br.readLine();
				
				System.out.print("Employee Name   : ");
				ename = br.readLine();
				
				System.out.print("Employee Salary : ");
				esal = Float.parseFloat( br.readLine());
				
				System.out.print("Employee Address : ");
				eaddr = br.readLine();
				
				emp = new Employee();
				emp.setEno(eno);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);
				
				status = employeeDao.add(emp);
				System.out.println(status);

				break;
				
			case 2:
				System.out.println("***|| SEARCH Employee ||***");
				
				System.out.print("Employe No : ");
				eno = br.readLine();
				
				emp = employeeDao.search(eno);
				
				if(emp == null) {
					 
					System.out.println("Employee Not Existed!!"); 
					  
				  }else{
					  System.out.println("***|| Employee Details ||***");
					  System.out.println("-----------------------------");
					  System.out.println("Employee No        : "+ emp.getEno());
					  System.out.println("Employee Name      : "+ emp.getEname());
					  System.out.println("Employee Salary    : "+ emp.getEsal());
					  System.out.println("Employee Address   : "+ emp.getEaddr());
				  }
				break;
				
			case 3:
				
				System.out.println("***|| UPDATE Employee ||***");
				
				System.out.print("Employe No : ");
				eno = br.readLine();
				
				emp = employeeDao.search(eno);
				
				if(emp == null) {
					 
					System.out.println("Employee Not Existed!!"); 
					  
				  }else {
					  
					    System.out.println("Employee No   : "+emp.getEno());
						
						System.out.print("Employee Name    [Old Value - "+emp.getEname()+" ] : ");
						String ename_New = br.readLine();
						
						System.out.print("Employee Salary  [Old Value - "+emp.getEsal()+" ]  : ");
						float esal_New = Float.parseFloat( br.readLine());
						
						System.out.print("Employee Address [Old Value - "+emp.getEaddr()+" ] : ");
						String eaddr_New = br.readLine();
						
						Employee emp_New = new Employee();
						
						emp_New.setEno(eno);
						emp_New.setEname(ename_New);
						emp_New.setEsal(esal_New);
						emp_New.setEaddr(eaddr_New);
						
						status = employeeDao.update(emp_New);
						System.out.println(status);
				  }
				
				
				break;
				
			case 4:
				
				System.out.println("***|| DELETE Employee ||***");
				
				System.out.print("Employe No : ");
				eno = br.readLine();
				
				status = employeeDao.delete(eno);
				System.out.println(status);

				break;
				
			case 5:
				System.out.println("***|| Thanku For Choosing This App ||***");
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter the option from 1,2,3,4,5.");
				break;
			}
		}

	}

}
