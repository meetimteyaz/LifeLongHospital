 package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			String username=request.getParameter("username");
			String pass=request.getParameter("password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement pst=cn.prepareStatement("insert into Login_table values(?,?)");
			pst.setString(1, username);
			pst.setString(2, pass);
			int i=pst.executeUpdate();
			if(i>0)
			{
				out.println("<h2 style='color:blue;padding-top:1rem;padding-left:0px;padding-right:0px;background:white;margin:0px;'><center>Signup Succesfull!!...Please login now</center></h2>");
				RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
				rd.include(request, response);
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
