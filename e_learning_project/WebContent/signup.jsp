<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	background: url(images/waterfall.jpg) no-repeat center center fixed;
	background-size: cover;
	margin:0px;;
	padding:0px;;
	font-family: sans-serif;

}
.container{
	width: 500px;
	height: 400px;
	background:rgba(0,0,0,.7);
	position:absolute;
	margin-left: 30%;
	margin-top: 5rem;
	text-align: center;
	
	box-shadow: 0 16px 26px rgba(0,0,0,.5);
	border-radius: 12px;

}
.container h2{
	color: white;
	font-family: cursive;
	font-size: 22px;
}
.container input{
	width: 70%;
	padding: 0.8rem;
	border-radius: 20px;
	border:none;
}
button{
	width: 20%;
	padding: 0.6rem;
	background-color: #0072ff;
	border:none;
	border-radius:5px;
	color: #fff;
}
</style>
<script type="text/javascript">

	function validate()
	{
		var username=document.getElementById("username").value;
		var pass=document.getElementById("pass").value;
var conpass=document.getElementById("conpass").value;
		if(username=="")
			{
			alert("username can't be empty");
			return false;
			
			}
		if(pass==""||pass.length<6)
		{
			alert("Password must be of atleast 6 character");
			return false;
		}
if(conpass=="" )
    {
    alert("Please confirm your password");
    return false;
}


if(pass!=conpass)
 {
  alert("Password do not match!");
 return false;
  }
		return true;

	}
		
	</script>
</head>
<body>
<div class="container">
		<h2 >SIGN UP</h2>
		<FORM action="sign" method="post" onsubmit="return validate()">
			<input type="text" name="username" placeholder="Username" id="username"><br><br>
			
			
			<input type="password" name="password" id="pass" placeholder="Password"><br><br>
			<input type="password" id="conpass" placeholder="Confirm Password"><br><br>
			<button> Sign Up</button>  <a href="index.jsp" style="color:red;text-decoration:underline;margin-right:0;">Login</a>
		</FORM>



	</div>

</body>
</html>