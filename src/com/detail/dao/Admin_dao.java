package com.detail.dao;
import com.detail.d_class.Admin_signup;
import java.sql.*;
public class Admin_dao {
	public int Register_Admin(Admin_signup Admin)throws Exception{
		String sql_query="insert into admin_detail values (?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Admin.getA_name());
			ps.setString(2, Admin.getA_email());
			ps.setString(3, Admin.getA_gender());
			ps.setString(4, Admin.getA_phone());
			ps.setString(5, Admin.getA_pass());
			res=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
