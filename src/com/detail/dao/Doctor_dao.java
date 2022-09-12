package com.detail.dao;

import com.detail.d_class.Doctor_signup;

import java.sql.*;
public class Doctor_dao {
	public int Register_Doctor(Doctor_signup Doctor)throws Exception{
		String sql_query="insert into doctor_detail values (?,?,?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Doctor.getD_name());
			ps.setString(2, Doctor.getD_email());
			ps.setString(3, Doctor.getD_gender());
			ps.setString(4, Doctor.getD_phone());
			ps.setString(5, Doctor.getD_speci());
			ps.setString(6, Doctor.getD_addr());
			ps.setString(7, Doctor.getD_pass());
			res=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
