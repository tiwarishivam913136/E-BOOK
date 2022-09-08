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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phone=req.getParameter("phnno");
			String password=req.getParameter("pwd");
			String check=req.getParameter("check");
			
		//System.out.println(name + email +phone +password);
			
			
			
		  User us=new User();
		  us.setName(name);
		  us.setEmail(email);
		  us.setPhno(phone);
		  us.setPassword(password);
		  
		  HttpSession session=req.getSession();
		  
		  
		  if(check!=null) {
		  
		  UserDAOImp dao=new UserDAOImp(DBConnection.getConn());
		     boolean f2=dao.checkUser(email);
		     
		     if(f2) {
		    	 boolean f=dao.userRegister(us);
				  if(f) {
					 // System.out.println("User Register Successfull");
					  session.setAttribute("succMsg", "Registration Successfully..");
					  resp.sendRedirect("register.jsp");
				  }else {
					 // System.out.println("Something wrong on server");
					  session.setAttribute("failedMsg", "Something went wrong on server");
					  resp.sendRedirect("register.jsp");
				  }
				  
		     }else {
		    	  session.setAttribute("failedMsg", "User Email Already Exist try Another Email ID");
		    	  resp.sendRedirect("register.jsp");
		     }
		     
		     
		  }else {
			 // System.out.println("Please Agree Terms And Condition");
			  session.setAttribute("failedMsg", "Please Agree Terms And Condition");
			  resp.sendRedirect("register.jsp");
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
