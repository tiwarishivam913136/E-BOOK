package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DOA.BookDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;

@WebServlet("/books_edit")
public class EditBooksServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String BookName = req.getParameter("bname");
			String Author = req.getParameter("author");
			String price = req.getParameter("price");
			String status = req.getParameter("bstatus");
			
			BookDetails book=new BookDetails();
			book.setBookId(id);
			book.setBookName(BookName);
			book.setAuthor(Author);
			book.setPrice(price);
			book.setStatus(status);
			
			BookDAOImp dao=new BookDAOImp(DBConnection.getConn());
			boolean b=dao.updateEditBooks(book);
			
			HttpSession session=req.getSession();
			
			if(b) {
				session.setAttribute("succMsg", "Book Update Successfully...");
				resp.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on Server...");
				resp.sendRedirect("admin/all_books.jsp");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
