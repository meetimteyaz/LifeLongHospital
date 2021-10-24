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

/**
 * Servlet implementation class Patient_Record
 */
public class Patient_Record extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pname=request.getParameter("pname");
		String gender=request.getParameter("gender");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String prefer=request.getParameter("appointment");
		String department=request.getParameter("depart");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection cn=DriverManager.getConnection(url,"system","admin");
			PreparedStatement pst=cn.prepareStatement("insert into Patient_Record values(?,?,?,?,?,?,?)");
			pst.setString(1,pname);
			pst.setString(2, gender);
			pst.setString(3, contact);
			pst.setString(4,email);
			pst.setString(5,dob);
			pst.setString(6,prefer);
			pst.setString(7, department);
			int i=pst.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("status");
				rd.forward(request, response);
				
		     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		
				
				
				
		
	}

}
	
