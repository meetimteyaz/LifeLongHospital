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

public class DoctorsLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection cn=DriverManager.getConnection(url,"system","admin");
			PreparedStatement pst=cn.prepareStatement("select * from doctorslogin");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String username=rs.getString(1);
			String password=rs.getString(2);
			if(uname.equals(username)&&pass.equals(password))
			{
				RequestDispatcher rd=request.getRequestDispatcher("doctors_retrieval.html");
				rd.forward(request, response);
			}
		}
		out.println("<center><h2><font color=red>Sorry!! You are not an authorized person to access</font></h2></center>");
		RequestDispatcher rd=request.getRequestDispatcher("doctorslogin.html");
		rd.include(request, response);
	    
			
			}
		catch(Exception e)
		{
			out.println(e);
		}



		}
	}


