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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		{
			try {
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				Connection cn=DriverManager.getConnection(url,"system","admin");
				PreparedStatement pst=cn.prepareStatement("select * from Login_Table");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					String uname=rs.getString(1);
					String pass=rs.getString(2);
					if(username.equals(uname)&&password.equals(pass))
					{
						RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
						rd.forward(request, response);
					}
				}
				out.println("<center><h2><font color=red>Sorry!! Email ID or Password do not match. Please enter valid emailId and Password.</font></h2></center>");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			catch(Exception e)
			{
			out.println(e);
			}

	

			}
		}
	}


