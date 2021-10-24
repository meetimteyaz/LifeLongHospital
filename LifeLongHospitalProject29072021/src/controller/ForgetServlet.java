package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForgetServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String countrow="";
		try{
			String email=request.getParameter("email");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection cn=DriverManager.getConnection(url,"system","admin");
			PreparedStatement pst=cn.prepareStatement("select password from LifeLong where email=?");
		    pst.setString(1, email);;	
		    ResultSet rs=pst.executeQuery();
		    rs.next();
		    
		     countrow=rs.getString(1);
		    if (countrow.equals(""))		   
		   		    {
		    	
		    	out.println("<center><h2><font color=red>invalid id.</font></h2></center>");
				RequestDispatcher rd=request.getRequestDispatcher("forgetPassword.html");
				rd.include(request, response);
		    	
		    }
		    else {
		    	out.println("<h1>Your Password is<font color=red>'"+countrow+"'</font></h1>");
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
