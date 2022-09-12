package com.detail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.detail.d_class.Book_app;

public class Book_app_dao {
	public int Add(Book_app Book)throws Exception{
		String sql_query="insert into Book_app values (?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","keerthana123");
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql_query);
			ps.setString(1, Book.getBa_name());
			ps.setString(2, Book.getBa_email());
			ps.setString(3, Book.getBa_time());
			ps.setString(4, Book.getBa_doc());
			ps.setString(5, Book.getBa_pro());
			res=ps.executeUpdate();
			con.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
