package com.detail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.detail.d_class.Doctor_medical;
public class Doctor_medical_dao {
	public int Doctor_prescription(Doctor_medical medical)throws Exception{
		String sql_query="insert into doctor_medical values (?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, medical.getDm_name());
			ps.setString(2, medical.getDm_email());
			ps.setString(3, medical.getDm_pre());
			ps.setString(4, medical.getDm_bill());
			res=ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
