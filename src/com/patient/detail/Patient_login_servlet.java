package com.patient.detail;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.detail.dao.Patient_login_dao;

@WebServlet("/Patient_login_servlet")
public class Patient_login_servlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	Patient_login_dao Pd=new Patient_login_dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Pd_email=request.getParameter("P_email");
		String Pd_pass=request.getParameter("P_pass");
		if(Pd.check(Pd_email, Pd_pass)){
			HttpSession session=request.getSession();
			session.setAttribute("Pd_email",Pd_email);
			response.sendRedirect("Patient_dashboard.html");
		}
		else {
			response.sendRedirect("Patient_login.jsp");
		}
	}

}
