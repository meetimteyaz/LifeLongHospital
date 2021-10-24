package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Doctors_Retrieval
 */
public class Doctors_RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String depart=request.getParameter("depart");
		String date=request.getParameter("date");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection cn=DriverManager.getConnection(url,"system","admin");
			PreparedStatement pst=cn.prepareStatement("select * from patient_record where department=? and PREFFERED_DATE_FOR_APPOINTMENT=?");
			pst.setString(1,depart);
			pst.setString(2,date);
			ResultSet rs=pst.executeQuery();
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		
			out.println("<div class='table-responsive'>");
			out.print("<table class='table table-striped'>");
			 out.print("<center><h1><u>Patient Details</u></h1></center>");
            out.println("<tr><th>PATIEN_NAME</th><th> GENDER</th><th> CONTACT</th><th> EMAIL</th><th> DATE_OF_BIRTH</th><th> PREFFERED_DATE_FOR_APPOINTMENT</th><th>DEPARTMENT</th><tr>");
			  
			while(rs.next())
			{
						  
				     String patient_name=rs.getString(1);
				     String gender=rs.getString(2);
				     String contact=rs.getString(3);
				     String email=rs.getString(4);
				     String dob=rs.getString(5);
				     String pdot=rs.getString(6);
				     String department=rs.getString(7);
				     out.println("<tr><td>" + patient_name + "</td><td>" + gender + "</td><td>" + contact + "</td><td>"+ email +"</td><td>" + dob + "</td><td>"+pdot+"</td><td>" + department + "</td></tr>");   
			}
		  
        out.println("</table>");
        out.println("</div>");
          
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
				     
			
		
			
	


