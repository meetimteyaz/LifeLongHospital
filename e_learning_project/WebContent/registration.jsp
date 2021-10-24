<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
			background-color:blue;
			margin: 0;
			padding: 0;
			}
			.navbar{
			width: 100%;
			height: 30px;
			padding-bottom: 1rem;
			background-color: white;


		}
			.container{
			background-color: navy;
			
			height: 500px;
			width: 850px;
			margin-left:11rem; 
			border-radius: 12px;
			padding-right: 2rem;
			}
			
		
		.content{
			color: white;
			font-size: 17px;
			padding-top: 2rem;
			}
			.btn{
			width: 90px;
			height: 40px;
			border-radius: 10px;
			border:none;
			font-size: 19px;
			font-weight: bold;

		}
		
		input{
			height: 30px;
			border-radius: 5px;
			border:none;
		}
</style>
</head>
<body>

	<div class="navbar">
	<h1 style="text-align: center;padding-top:.5rem;color: navy;">REGISTRATION FORM</h1>
	</div>
	<div class="container">
	<form   onsubmit="return validate(this)">
		<pre class="content">
			User ID                       :<input type="number"  name="userid" placeholder="User ID" id="userid" required><br>
			Name                          :<input type="text" id="name" name="name" placeholder="Name" required> <br>			
			E-Mail                        :<input type="email" id="email" name="email" placeholder="E-mail ID"><br>
			Password                      :<input type="password" name="password" id="password" placeholder="password" required><br>
			Contact                       :<input type="number" id="num"  name="contact" placeholder="10 digit number" required><br>
			Address                       :<input type="text" width="80px" height="50px" id="address" name="address" placeholder="Address" required><br>
			Upload Photo                  :<input type="file">
			                    
			                    
			         <button class="btn">Register</button>    <input type="reset" value="Reset" class="btn">    <a href="doctors.html"><input type="button" value="Back" class="btn"></a> 
        </pre>
    </form>
</div>
        
		        
</body>
</html>