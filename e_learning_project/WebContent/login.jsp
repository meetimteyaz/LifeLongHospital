  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	background: url(images/Green.jpg) no-repeat;
	background-size: cover;
	font-family:sans-serif;
}

.container{
	width: 30%;
	height:350px;
	overflow: hidden;
   padding:1rem;
   margin: auto;
   background-color:white;
   border-radius: 10px;
   text-align: center;
   margin-top: 7%;
}

.container input{
	width: 60%;
	padding: 0.3rem;
	border-radius: 6px;

}

.container input[type=checkbox]{
	width: auto;

}
a{
	text-decoration: none;
}
.btn{
	width: 50%;
	padding: 0.8rem;
	color: white;
	background-color: green;
	border-radius: 5px;
	border:none;
}
</style>
<script type="text/javascript">
function validate()
	{
	var uname=document.getElementById("username").value;
		
		var pass=document.getElementById("pass").value;
		if(uname=="")
			{
			alert("username can't be empty");
			return false;
			}
		if(pass==""||pass.length<6)
		{
			alert("Password must be of atleast 6 character");
			return false;
		}
		return true;

	}</script>
</head>
<body>

	<div class="container">
		<h1>Login</h1>
				
        <form  action="login"  method="post" onsubmit="return validate()">
        
        
        
        
		<input type="text" name="username" id="username" placeholder="Username"><br><br>
		
		<input type="password" name="password" placeholder="Password" id="pass"><br>
		 <input type="checkbox" name="checkbox" onclick="showPassword()" style="margin-left:5rem">Show Password<br><br>
		<button class="btn">Login</button><br><br><br>
		<a href="forgetpassword.html">forget your password?</a><br><br>
		<a href="signup.jsp">signup/create new account</a>


   </form>
	</div>

</body>
<script type="text/javascript">
function showPassword()
{
     var pass=document.getElementById("pass");
     if(pass.type=="password")
     {
           pass.type="text";
     }
     else
     {
          pass.type="password";
     }

}
</script>
</html>
</body>
</html>