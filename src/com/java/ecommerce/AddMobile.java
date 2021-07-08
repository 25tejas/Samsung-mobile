package com.java.ecommerce;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/AddMobile")
@MultipartConfig(maxFileSize = 9999999999L)
public class AddMobile extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
           
    public AddMobile() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String modelno=request.getParameter("modelno");
		String desc=request.getParameter("desc");
		String price=request.getParameter("price");
		int qty=Integer.parseInt(request.getParameter("qty"));
		Part part=request.getPart("image");
		InputStream is=part.getInputStream();
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ ecommerce","root","root");
				PreparedStatement ps=con.prepareStatement("insert into mobile(name,modelno,description,price,quantity,image) values(?,?,?,?,?,?)");
				ps.setString(1,"Samsung");
				ps.setString(2,modelno);
				ps.setString(3,desc);
				ps.setString(4,price);
				ps.setInt(5, qty);
				ps.setBlob(6, is);
				ps.executeUpdate();
				response.sendRedirect("addProduct.jsp");
		
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
