<%@page import="com.entity.BookDetails"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.BookDAOImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Book</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="Component/Navbar.jsp"%>

	<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		BookDAOImp d = new BookDAOImp(DBConnection.getConn());
		BookDetails b = d.getBooKById(bid);
	%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img alt="img" src="books/<%=b.getPhotoname()%>"
					style="heigth: 150px; width: 150px;">
				<h4 class="mt-3">
					Book Name: <span class="text-success"><%=b.getBookName()%></span>
				</h4>
				<h4>
					Author Name: <span class="text-success"><%=b.getAuthor()%></span>
				</h4>
				<h4>
					Book Category: <span class="text-success"><%=b.getBookCategory()%></span>
				</h4>

			</div>
			<div class="col-md-6 text-center p-5 border bg-white">
				<h2><%=b.getBookName()%></h2>
				
				<%
					if ("Old".equals(b.getBookCategory())) {
				%>


				<h5>Contact to Seller</h5>
				<h5 class="text-primary">
					<i class="far fa-envelope"></i>EMail:
					<%=b.getEmail()%></h5>

				<%
					}
				%>



				<div class="row">
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-truck-moving fa-2x"></i>
						<p>Free Shipping</p>
					</div>

				</div>
				<%
					if ("Old".equals(b.getBookCategory())) {
				%>
				
				<div class="text-center">
					<a href="index.jsp" class="btn btn-success"><i class="fas fa-cart-plus"></i>Continue Shopping
						</a> <a href="" class="btn btn-danger">250<i
						class="fas fa-rupee-sign"></i></a>
				</div>
				
				
				
				<%
					}else{
				%>
				
				<div class="text-center">
					<a href="" class="btn btn-primary"><i class="fas fa-cart-plus"></i>Add
						Cart</a> <a href="" class="btn btn-danger">250<i
						class="fas fa-rupee-sign"></i></a>
				</div>
				
				
				
				<%
					}
				%>
				
			</div>
		</div>
	</div>
	<%@include file="Component/Footer.jsp"%>
</body>
</html>