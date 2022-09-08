package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DOA.BookDAOImp;
import com.DOA.CartDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;
import com.entity.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int bid=Integer.parseInt(req.getParameter("bid"));
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			BookDAOImp dao=new BookDAOImp(DBConnection.getConn());
			BookDetails b=dao.getBooKById(bid);
			
			Cart c=new Cart();
			c.setBid(bid);
			c.setUid(uid);
			c.setBookname(b.getBookName());
			c.setAuthor(b.getAuthor());
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotalprice(Double.parseDouble(b.getPrice()));
			
			CartDAOImp da=new CartDAOImp(DBConnection.getConn());
			boolean f=da.addCart(c);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("addCart", "Book Added to Cart");
				resp.sendRedirect("all_NewBook.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on Server..");
				resp.sendRedirect("all_NewBook.jsp");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
