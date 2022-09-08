package com.admin.servlet;

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

@WebServlet("/books_add")
@MultipartConfig
public class BooksAddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String BookName = req.getParameter("bname");
		String Author = req.getParameter("author");
		String price = req.getParameter("price");
		String category = req.getParameter("btype");
		String status = req.getParameter("bstatus");
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
			resp.sendRedirect("admin/add_books.jsp");
	
		} else {
		
			session.setAttribute("failedMsg", "Something wrong on Server...");
			resp.sendRedirect("admin/add_books.jsp");
	
		}

	}

}
