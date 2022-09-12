<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			Connection connection = null;
			Statement statement=null;
			try{ 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "keerthana123");
			String sql ="DELETE FROM doctor_detail WHERE phone=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			String phno=request.getParameter("n");
			ps.setString(1, phno);
			ps.execute();
			ps.close();
			connection.commit();
			response.sendRedirect("Doctor_edit_detail.jsp");
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
</body>
</html>