package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DOA.BookOrderDAOImp;
import com.DOA.CartDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;
import com.entity.BookOrder;
import com.entity.Cart;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       	try {
       	 HttpSession session=req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phnno");
			String address = req.getParameter("address");
			String landMark = req.getParameter("lmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String zip = req.getParameter("zip");
			String paymentType = req.getParameter("ptype");

			String fullAddress = address + "," + landMark + "," + city + "," + state + "," + zip;

			CartDAOImp dao = new CartDAOImp(DBConnection.getConn());
			List<Cart> blist = dao.getBookByUser(id);
	       if(blist.isEmpty()) {
	    	   session.setAttribute("failedMsg", "Please Add Item in your Cart");
	    	   resp.sendRedirect("checkOut.jsp");
	       }else {
	   		BookOrderDAOImp dao1 = new BookOrderDAOImp(DBConnection.getConn());
			

			BookOrder o = null;
            ArrayList<BookOrder> arrlist = new ArrayList<BookOrder>();


			Random r=new Random();
			for (Cart c : blist) {
				o=new BookOrder();
				o.setOrderid("BOOK-ORD-ID-" + r.nextInt(1000));
				o.setUser_name(name);
				o.setEmail(email);
				o.setPhone(phno);
				o.setFullAddress(fullAddress);
				o.setBook_name(c.getBookname());
				o.setAuthor(c.getAuthor());
				o.setPrice(c.getPrice() + "");
				o.setPayment(paymentType);

				arrlist.add(o);
			}

			if ("noselect".equals(paymentType)) {
				session.setAttribute("failedMsg", "Please Choose Payment Method....");
				resp.sendRedirect("checkOut.jsp");
			} else {
				boolean f = dao1.saveOrder(arrlist);

				if (f) {
					resp.sendRedirect("order_success.jsp");
				} else {
					session.setAttribute("failedMsg", "Your Order Failed");
					resp.sendRedirect("checkOut.jsp");
				}
			}
	       }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
