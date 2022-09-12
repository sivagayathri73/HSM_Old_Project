package com.detail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.detail.d_class.Patient_signup;

public class Patient_dao {
	public int Register_Patient(Patient_signup Patient)throws Exception{
		String sql_query="insert into patient_detail values (?,?,?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Patient.getP_name());
			ps.setString(2, Patient.getP_email());
			ps.setString(3, Patient.getP_gender());
			ps.setString(4, Patient.getP_phone());
			ps.setString(5, Patient.getP_blood());
			ps.setString(6, Patient.getP_addr());
			ps.setString(7, Patient.getP_pass());
			res=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
