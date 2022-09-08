package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DOA.UserDAOImp;
import com.DataBase.DBConnection;
import com.entity.User;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phnno");
			String password = req.getParameter("pwd");

			User us = new User();
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phone);

			UserDAOImp dao = new UserDAOImp(DBConnection.getConn());

			HttpSession session = req.getSession();

			boolean f = dao.checkPassword(id, password);

			if (f) {
				boolean f2 = dao.updateProfile(us);
				if (f2) {
					session.setAttribute("succMsg", "User Profile Update Successfully..");
					resp.sendRedirect("editProfile.jsp");
				} else {
					session.setAttribute("failedMsg", "Something went wrong on server");
					resp.sendRedirect("editProfile.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "Your Password is Incorrect");
				resp.sendRedirect("editProfile.jsp");
		}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
