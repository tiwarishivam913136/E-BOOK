package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DOA.BookDAOImp;
import com.DataBase.DBConnection;


@WebServlet("/delete_old_book")
public class DeleteOldBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email=req.getParameter("em");
			int bid=Integer.parseInt(req.getParameter("bid"));
			
			BookDAOImp dao=new BookDAOImp(DBConnection.getConn());
			boolean f=dao.deleteOldBook(email, "Old",bid);
			
			HttpSession session=req.getSession();
			
			if (f) {
				session.setAttribute("succMsg", "Old Book Delete Successfully...");
				resp.sendRedirect("old_book.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on Server");
				resp.sendRedirect("old_book.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
}
