<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient_Login</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<style>
body{
  margin: 0;
  padding: 0;
  font-family: Century Gothic;
  background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url(Patient_log.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
.login-box{
  width: 280px;
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%,-50%);
  color: white;
}
.login-box h1{
  float: left;
  font-size: 40px;
  border-bottom: 6px solid #a0ff3b;
  margin-bottom: 50px;
  padding: 13px 0;
}
.textbox{
  width: 100%;
  overflow: hidden;
  font-size: 20px;
  padding: 8px 0;
  margin: 8px 0;
  border-bottom: 1px solid #a0ff3b;
}
.textbox i{
  width: 26px;
  float: left;
  text-align: center;
}
.textbox input{
  border: none;
  outline: none;
  background: none;
  color: white;
  font-size: 18px;
  width: 80%;
  float: left;
  margin: 0 10px;
}
.btn{
  width: 100%;
  background: none;
  border: 2px solid #a0ff3b;
  color: white;
  padding: 5px;
  font-size: 18px;
  cursor: pointer;
  margin: 12px 0;
}
::-webkit-input-placeholder {
  color: #ffff;
}
a{
text-decoration:none;
color:#ffff ;
padding:5px 20px;
border:1px solid transparent;
transition:0.6s ease;
align:center;
}
</style>
<body>
<div class="login-box">
<form method="post" action="Patient_login_servlet">
  <h1>PATIENT LOGIN</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="email" name="P_email" placeholder="E-mail">
  </div> 	
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" name="P_pass" placeholder="Password">
  </div>
  <input type="submit" class="btn" value="Sign in">
  <a href="Patient_signup.jsp">  Sign up/Register  </a>
 </form>
</div>
</body>
</html>