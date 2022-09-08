package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.File;

import com.DOA.BookDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;

@WebServlet("/add_old_book")
@MultipartConfig
public class AddOldBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String BookName = req.getParameter("bname");
		String Author = req.getParameter("author");
		String price = req.getParameter("price");
		String category = "Old";
		String status = "Active";
		Part part = req.getPart("bimg");
		String filename = part.getSubmittedFileName();
		
		String useremail=req.getParameter("user");

		BookDetails d = new BookDetails(BookName, Author, price, category, status, filename, useremail);

		BookDAOImp book = new BookDAOImp(DBConnection.getConn());

		boolean f = book.addBooks(d);

		HttpSession session = req.getSession();

		if (f) {

			String path = getServletContext().getRealPath("") + "books";

			File fa = new File(path);
			part.write(path + File.separator + filename);

			session.setAttribute("succMsg", "Book Added Successfully...");
			resp.sendRedirect("sell_book.jsp");
	
		} else {
		
			session.setAttribute("failedMsg", "Something wrong on Server...");
			resp.sendRedirect("sell_book.jsp");
	
		}

	}

}
