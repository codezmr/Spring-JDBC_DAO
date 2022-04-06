package com.codezmr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req_path = request.getRequestURI();
		
		if(req_path.endsWith("add.do")) {
			
		}
		
		if(req_path.endsWith("search.do")) {
					
				}
		
		if(req_path.endsWith("delete.do")) {
			
		}
	}

}
