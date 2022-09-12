package com.doctor.detail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detail.d_class.Doctor_signup;
import com.detail.dao.Doctor_dao;

@WebServlet("/Doctor_signup_servlet")
public class Doctor_signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Doctor_dao d_dao=new Doctor_dao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String D_name=request.getParameter("Ds_name");
		String D_email=request.getParameter("Ds_email");
		String D_phone=request.getParameter("Ds_phno");
		String D_addr=request.getParameter("Ds_addr");
		String D_gender=request.getParameter("Ds_gender");
		String D_speci=request.getParameter("Ds_speci");
		String D_pass=request.getParameter("Ds_pass");
		String D_pass1=request.getParameter("Ds_pass1");
		PrintWriter out=response.getWriter();
		int x=0;
		Doctor_signup Doctor=new Doctor_signup();
		if(D_pass.equals(D_pass1)) {
			try {
				Doctor.setD_name(D_name);
				Doctor.setD_email(D_email);
				Doctor.setD_phone(D_phone);
				Doctor.setD_gender(D_gender);
				Doctor.setD_pass(D_pass);
				Doctor.setD_addr(D_addr);
				Doctor.setD_speci(D_speci);
				x=d_dao.Register_Doctor(Doctor);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else {
			out.println("<h1>Password not matched.....</h1>");
			response.sendRedirect("Admin_doc_dashboard.html");
		}
		if(x>=1) {
			response.sendRedirect("Admin_doc_dashboard.html");
		}
	}
}
