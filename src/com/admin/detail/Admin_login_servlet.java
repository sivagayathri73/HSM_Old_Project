package com.admin.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.detail.dao.Admin_login_dao;

@WebServlet("/Admin_login_servlet")
public class Admin_login_servlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin_login_dao Ad=new Admin_login_dao();
		String Ad_email=request.getParameter("A_email");
		String Ad_pass=request.getParameter("A_pass");
			if(Ad.check(Ad_email, Ad_pass)){
				HttpSession session=request.getSession();
				session.setAttribute("Ad_email",Ad_email);
				response.sendRedirect("Admin_dashboard.html");
			}
			else {
				response.sendRedirect("Admin_login.jsp");
			}
	}

}
