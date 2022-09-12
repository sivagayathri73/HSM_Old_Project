package com.doctor.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detail.d_class.Doctor_medical;
import com.detail.dao.Doctor_medical_dao;


@WebServlet("/Doctor_medical_servlet")
public class Doctor_medical_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Doctor_medical_dao dm_dao=new Doctor_medical_dao();
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String Dm_name=request.getParameter("Dm_name");
		String Dm_email=request.getParameter("Dm_email");
		String Dm_pre=request.getParameter("Dm_pre");
		String Dm_bill=request.getParameter("Dm_bill");
		int x=0;
		Doctor_medical medical=new Doctor_medical();
			try {
				medical.setDm_name(Dm_name);
				medical.setDm_email(Dm_email);
				medical.setDm_pre(Dm_pre);
				medical.setDm_bill(Dm_bill);
				x=dm_dao.Doctor_prescription(medical);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//response.sendRedirect("Doctor_dashboard.html");
			if(x>=1) {
				response.sendRedirect("Doctor_dashboard.html");
			}
	}
}
