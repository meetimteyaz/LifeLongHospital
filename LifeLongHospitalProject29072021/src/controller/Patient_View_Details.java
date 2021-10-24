package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Patient_View_Detail
 */
public class Patient_View_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		String contact=request.getParameter("contact");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		   try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   String url="jdbc:oracle:thin:@localhost:1521:xe";
			   Connection cn=DriverManager.getConnection(url,"system","admin");
			   PreparedStatement pst=cn.prepareStatement("select * from patient_record where contact=?");
			   pst.setString(1,contact);
			   ResultSet rs=pst.executeQuery();
			   out.print("<center>");
			   out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
			   out.println("<div class='table-responsive'>");
				out.print("<table class='table table-striped'>");
			   out.print("<center><h1><u>Booking Status</u></h1></center>");
			   ResultSetMetaData rsmd=rs.getMetaData();
			   
			   while(rs.next()) {
				   
				   out.print("<tr>");
				   out.print("<td>"+rsmd.getColumnName(1)+"</td>");
				      out.print("<td>"+rs.getString(1)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
				      out.print("<td>"+rs.getString(2)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
				      out.print("<td>"+rs.getString(3)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
				      out.print("<td>"+rs.getString(4)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
				      out.print("<td>"+rs.getString(5)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
				      out.print("<td>"+rs.getString(6)+"</td></tr>");
				      out.print("<tr><td>"+rsmd.getColumnName(7)+"</td>");
				      out.print("<td>"+rs.getString(7)+"</td></tr>");
				      out.println("<tr><td> Status</td>");
				      out.print("<td> Successfull</td></tr>");
			      }
			   out.print("</table>");
			   out.print("</center>");
		   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		   
		   }
		}

	
