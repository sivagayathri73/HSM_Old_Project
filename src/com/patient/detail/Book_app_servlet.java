package com.patient.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detail.d_class.Book_app;
import com.detail.dao.Book_app_dao;

@WebServlet("/Book_app_servlet")
public class Book_app_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Book_app_dao ba_dao=new Book_app_dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	String Ba_name=request.getParameter("Ba_name");
	String Ba_email=request.getParameter("Ba_email");
	String Ba_time=request.getParameter("Ba_time");
	String Ba_doc=request.getParameter("Ba_doc");
	String Ba_pro=request.getParameter("Ba_pro");
	int x=0;
	Book_app Book=new Book_app();
		try {
			Book.setBa_name(Ba_name);
			Book.setBa_email(Ba_email);
			Book.setBa_time(Ba_time);
			Book.setBa_doc(Ba_doc);
			Book.setBa_pro(Ba_pro);
			x=ba_dao.Add(Book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//response.sendRedirect("Patient_dashboard.html");
	if(x>=1) {
		response.sendRedirect("Patient_dashboard.html");
	}
}
}
