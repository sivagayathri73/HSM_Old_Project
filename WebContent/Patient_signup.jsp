<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient_Signup</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<style>
body{
  margin: 0;
  padding: 0;
  font-family: Century Gothic;
  background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url(signup.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
.login-box{
  width: 280px;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%,-50%);
  color: white;
}
.login-box h1{
  float: left;
  font-size: 35px;
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
<form method="post" action="Patient_signup_servlet">
  <h1>PATIENT SIGNUP</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" name="Ps_name" placeholder="Name">
  </div> 	
  <div class="textbox">
    <i class="fas fa-blender-phone"></i>
    <input type="text" name="Ps_phno" placeholder="Phone No">
  </div>
  <div class="textbox">
    <i class="fas fa-mars-double"></i>
    <input type="text" name="Ps_gender" placeholder="Gender">
  </div>
  <div class="textbox">
    <i class="fas fa-hand-holding-medical"></i>
    <input type="text" name="Ps_blood" placeholder="Blood Group">
  </div>
  <div class="textbox">
    <i class="fas fa-house-user"></i>
    <input type="text" name="Ps_addr" placeholder="Address">
  </div>
  <div class="textbox">
    <i class="fas fa-envelope"></i>
    <input type="email" name="Ps_email" placeholder="E-mail">
  </div>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" name="Ps_pass" placeholder="Password">
  </div>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" name="Ps_pass1" placeholder="Confirm Password">
  </div>
  
  <input type="submit" class="btn" value="Sign in">
 </form>
</div>
</body>
</html>