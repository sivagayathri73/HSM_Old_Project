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
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Patient_details</title>
</head>
  <style>
  body{
  margin: 0;
  padding: 0;
  font-family: Century Gothic;
}

header{
  z-index: 1;	
  position: fixed;
  background: #22242A;
  padding: 20px;
  width: calc(100% - 0%);
  top: 0;
  height: 30px;
}

.left_area h3{
  color: #fff;
  margin: 0;
  text-transform: uppercase;
  font-size: 22px;
  font-weight: 900;
}

.left_area span{
  color: #19B3D3;
}

.logout_btn{
  padding: 5px;
  background: #19B3D3;
  text-decoration: none;
  float: right;
  margin-top: -30px;
  margin-right: 40px;
  border-radius: 2px;
  font-size: 15px;
  font-weight: 600;
  color: #fff;
  transition: 0.5s;
  transition-property: background;
}

.logout_btn:hover{
  background: #0B87A6;
}

.sidebar{
  z-index: 1;
  top: 0;
  background: #2f323a;
  margin-top: 70px;
  padding-top: 30px;
  position: fixed;
  left: 0;
  width: 250px;
  height: calc(100% - 9%);
  transition: 0.5s;
  transition-property: left;
  overflow-y: auto;
}

.profile_info{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.sidebar .profile_info .profile_image{
  width: 100px;
  height: 100px;
  border-radius: 100px;
  margin-bottom: 10px;
}

.sidebar .profile_info h4{
  color: #ccc;
  margin-top: 0;
  margin-bottom: 20px;
}

.sidebar a{
  color: #fff;
  display: block;
  width: 100%;
  line-height: 60px;
  text-decoration: none;
  padding-left: 40px;
  box-sizing: border-box;
  transition: 0.5s;
  transition-property: background;
}

.sidebar a:hover{
  background: #19B3D3;
}

.sidebar i{
  padding-right: 10px;
}

label #sidebar_btn{
  z-index: 1;
  color: #fff;
  position: fixed;
  cursor: pointer;
  left: 300px;
  font-size: 20px;
  margin: 5px 0;
  transition: 0.5s;
  transition-property: color;
}

label #sidebar_btn:hover{
  color: #19B3D3;
}

#check:checked ~ .sidebar{
  left: -185px;
}

#check:checked ~ .sidebar a span{
  display: none;
}

#check:checked ~ .sidebar a{
  font-size: 20px;
  margin-left: 165px;
  width: 100%;
}

.content{
  width: (100% - 250px);
  display: flex;
  flex-wrap: wrap;
  margin-top: 60px;
  padding: 20px;
  margin-left: 250px;
  background: url(background.png) no-repeat;
  background-position: center;
  background-size: cover;
  height: 100vh;
  -webkit-box-pack:justify;
  justify-content:space-between;
  padding-left:25px;
  padding-right:25px;
  transition: 0.5s;
}

#check:checked ~ .content{
  margin-left: 60px;
}

#check:checked ~ .sidebar .profile_info{
  display: none;
}

#check{
  display: none;
}

.mobile_nav{
  display: none;
}

.content .card p{
  background: #fff;
  padding: 15px;
  margin-bottom: 10px;
  font-size: 14px;
  opacity: 0.8;
}

/* Responsive CSS */

@media screen and (max-width: 780px){
  .sidebar{
    display: none;
  }

  #sidebar_btn{
    display: none;
  }

  .content{
    margin-left: 0;
    margin-top: 0;
    padding: 10px 20px;
    transition: 0s;
  }

  #check:checked ~ .content{
    margin-left: 0;
  }

  .active{
    display: block;
  }
  }
 
  a{
  text-decoration:none;
  }
    td{
  color:#ffff;
  }
  </style>
  <body>

    <input type="checkbox" id="check">
    <header>
      <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
      </label>
      <div class="left_area">
        <h3><span>Patient|Medical History</span></h3>
      </div>
      <div class="right_area">
        <a href="Patient_logout.jsp" class="logout_btn">Logout</a>
      </div>
    </header>
    <div class="sidebar">
     <a href="Patient_dashboard.html"><i class="fas fa-desktop"></i><span>Dashboard</span></a>
      <a href="Patient_medical_detail.jsp"><i class="fas fa-history"></i><span>Medical History</span></a>
      <a href="app_his.jsp"><i class="fas fa-sync-alt"></i><span>Appointment History</span></a>
      <a href="Book_app.jsp"><i class="fas fa-tasks"></i><span>Book Appointment</span></a>    </div>

    <div class="content">
		<%
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try{ 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "keerthana123");
			statement=connection.createStatement();
			String email=session.getAttribute("Pd_email").toString(); 
			String sql ="SELECT * FROM doctor_medical where p_email=?";
			out.println("<table align=center cellpadding=5 cellspacing=5 border=1>");
			out.println("<tr bgcolor=#0B87A6>");
			out.println("<td><b>NAME</b></td>"+
			"<td><b>E-MAIL</b></td>"+
			"<td><b>PRESCRIPTION</b></td>"+
			"<td><b>FEES</b></td>"+
			"</tr>");
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			resultSet = ps.executeQuery();
			String row="";
			while(resultSet.next()){
			
			row="<td>"+resultSet.getString(1)+"</td><td>"+resultSet.getString(2)+"</td><td>"+resultSet.getString(3)+"</td><td>"+resultSet.getString(4)+"</td>";
			out.println("<tr bgcolor=#7099e0>"+row+"</tr>");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			out.println("</table>");
			%>
			</div>
</body>
</html>