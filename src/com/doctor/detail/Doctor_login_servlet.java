package com.doctor.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.detail.dao.Doctor_login_dao;

@WebServlet("/Doctor_login_servlet")
public class Doctor_login_servlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	Doctor_login_dao Dd=new Doctor_login_dao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Dd_email=request.getParameter("D_email");
		String Dd_pass=request.getParameter("D_pass");
		if(Dd.check(Dd_email, Dd_pass)){
			HttpSession session=request.getSession();
			session.setAttribute("Dd_email",Dd_email);
			response.sendRedirect("Doctor_dashboard.html");
		}
		else {
			response.sendRedirect("Doctor_login.jsp");
		}
	}

}
