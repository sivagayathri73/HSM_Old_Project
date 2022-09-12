package com.patient.detail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.detail.d_class.Patient_signup;
import com.detail.dao.Patient_dao;

@WebServlet("/Patient_signup_servlet")
public class Patient_signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Patient_dao p_dao=new Patient_dao();
			String P_name=request.getParameter("Ps_name");
			String P_email=request.getParameter("Ps_email");
			String P_phone=request.getParameter("Ps_phno");
			String P_gender=request.getParameter("Ps_gender");
			String P_pass=request.getParameter("Ps_pass");
			String P_pass1=request.getParameter("Ps_pass1");
			String P_blood=request.getParameter("Ps_blood");
			String P_addr=request.getParameter("Ps_addr");
			PrintWriter out=response.getWriter();
			int x=0;
			Patient_signup Patient=new Patient_signup();
			if(P_pass.equals(P_pass1)) {
				try {
					Patient.setP_name(P_name);
					Patient.setP_email(P_email);
					Patient.setP_phone(P_phone);
					Patient.setP_gender(P_gender);
					Patient.setP_pass(P_pass);
					Patient.setP_blood(P_blood);
					Patient.setP_addr(P_addr);
					x=p_dao.Register_Patient(Patient);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			else {
				out.println("<h1>Password not matched.....</h1>");
				response.sendRedirect("Patient_signup.jsp");
			}
			if(x>=1) {
				response.sendRedirect("Patient_login.jsp");
			}
		}
	}
