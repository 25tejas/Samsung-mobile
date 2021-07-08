package com.java.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname"); 
		String password=request.getParameter("psw");
		PrintWriter out=response.getWriter();
		Model m=new Model();
		
    	try 
    	{
    
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ ecommerce","root","root");
			PreparedStatement pt= con.prepareStatement("select * from users where username=? and password=?");
			pt.setString(1, username);
			pt.setString(2, password);
			ResultSet rs=pt.executeQuery();
			
			if(rs.next()) 
			{
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(60*2);
				m.setEmail(rs.getString("email"));
				m.setUsername(rs.getString("username"));
				m.setUid(rs.getInt("uid"));
				session.setAttribute("m", m);
				response.sendRedirect("index.jsp");
			}
			else
			{
				out.print("Sorry UserName or Password Error!");  
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
			
	
		}
    	catch (Exception e) 
    	{
		    System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
