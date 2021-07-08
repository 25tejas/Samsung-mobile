package com.java.ecommerce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ValidatePayment")
public class ValidatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidatePayment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String cartid=request.getParameter("cid");
		String cardno=request.getParameter("cardno");
		String date=request.getParameter("expdate");
		String cvv=request.getParameter("cvv");
		int uid = ((Model)session.getAttribute("m")).getUid();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ ecommerce","root","root");
			if(cardno==null && date==null && cvv==null)
			{
				PreparedStatement ps=con.prepareStatement("insert into ordered(cid,payment_type,uid) values(?,?,?)");
				ps.setString(1, cartid);
				ps.setString(2, "card");
				ps.setInt(3, uid);
				int row=ps.executeUpdate();
				if(row>0){
					
					PreparedStatement ps1=con.prepareStatement("update cart set status='ordered' where cid="+cartid);
					ps1.executeUpdate();
					response.getWriter().println("" 
							+ "<script>"
							+ "alert('Orderded Placed successfully!!!');"
							+ "window.location='index.jsp';"
							+ "</script>");
				}
				else {
					response.getWriter().println(""
							+ "<script>"
							+ "alert('Payment credentials are wrong');"
							+ "window.location='cart.jsp';"
							+ "</script>");
				}
			}
			else
			{
				PreparedStatement ps=con.prepareStatement("insert into ordered(cid,cardno,exp,cvv,payment_type,uid) values(?,?,?,?,?,?)");
				ps.setString(1, cartid);
				ps.setString(2, cardno);
				ps.setString(3, date);
				ps.setString(4, cvv);
				ps.setString(5, "card");
				ps.setInt(6, uid);
				int row=ps.executeUpdate();
				if(row>0){
					
					PreparedStatement ps1=con.prepareStatement("update cart set status='ordered' where cid="+cartid);
					ps1.executeUpdate();
					response.getWriter().println("" 
							+ "<script>"
							+ "alert('Orderded Placed successfully!!!');"
							+ "window.location='index.jsp';"
							+ "</script>");
				}
				else {
					response.getWriter().println(""
							+ "<script>"
							+ "alert('Payment credentials are wrong');"
							+ "window.location='cart.jsp';"
							+ "</script>");
				}
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
