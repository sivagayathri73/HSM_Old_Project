package com.detail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Admin_login_dao {
	public boolean check(String Ad_email,String Ad_pass){
		String sql_query="select *from admin_detail where email=? and pass=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Ad_email);
			ps.setString(2, Ad_pass);
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
