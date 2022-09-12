package com.admin.detail;
import com.detail.dao.Admin_dao;
import java.io.*;
import com.detail.d_class.Admin_signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admin_signup_servlet")
public class Admin_signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Admin_dao a_dao=new Admin_dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String A_name=request.getParameter("As_name");
		String A_email=request.getParameter("As_email");
		String A_phone=request.getParameter("As_phno");
		String A_gender=request.getParameter("As_gender");
		String A_pass=request.getParameter("As_pass");
		String A_pass1=request.getParameter("As_pass1");
		PrintWriter out=response.getWriter();
		int x=0;
		Admin_signup Admin=new Admin_signup();
		if(A_pass.equals(A_pass1)) {
			try {
				Admin.setA_name(A_name);
				Admin.setA_email(A_email);
				Admin.setA_phone(A_phone);
				Admin.setA_gender(A_gender);
				Admin.setA_pass(A_pass);
				Admin.setA_pass1(A_pass1);
				x=a_dao.Register_Admin(Admin);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else {
			out.println("<h1>Password not matched.....</h1>");
			response.sendRedirect("Admin_login.jsp");
		}
		if(x>=1) {
			response.sendRedirect("Admin_login.jsp");
		}
	}
}
