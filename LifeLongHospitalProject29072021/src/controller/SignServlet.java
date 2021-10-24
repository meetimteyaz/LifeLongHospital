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
			String email=request.getParameter("email");
			String pass=request.getParameter("password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement pst=cn.prepareStatement("insert into LifeLong values(?,?)");
			pst.setString(1, email);
			pst.setString(2, pass);
			int i=pst.executeUpdate();
			if(i>0)
			{
				out.println("<center><h2><font color=red>Registration Successfull. Please Login</font></h2></center>");
				RequestDispatcher rd=request.getRequestDispatcher("signup.html");
				rd.include(request, response);
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
