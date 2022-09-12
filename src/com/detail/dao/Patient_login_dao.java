package com.detail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patient_login_dao {
	public boolean check(String Pd_email,String Pd_pass){
		String sql_query="select *from Patient_detail where email=? and pass=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Pd_email);
			ps.setString(2, Pd_pass);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}

