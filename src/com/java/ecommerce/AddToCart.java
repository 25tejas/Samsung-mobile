package com.java.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.x.ReusableInputStream;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddToCart() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();	
		int mid = Integer.parseInt(request.getParameter("id"));
		String price=request.getParameter("pr");
		int uid = ((Model)session.getAttribute("m")).getUid();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ ecommerce","root","root");
				
				PreparedStatement ps = con.prepareStatement("insert into cart(mid,uid,price,status) values(?,?,?,?)");
				ps.setInt(1, mid);
				ps.setInt(2, uid);
				ps.setString(3, price);
				ps.setString(4, "notOrdered");
				ps.executeUpdate();
				
				
				PrintWriter out=response.getWriter();
				
				out.println(""
						+ "<script>"
						+ "alert('cart item added successfully!!!');"
						+ "window.location='cart.jsp';"
						+ "</script>");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
