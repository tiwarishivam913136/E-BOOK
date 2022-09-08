<%@page import="com.entity.BookOrder"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.BookOrderDAOImp"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body>

	<c:if test="${empty userobj }">

		<c:redirect url="login.jsp"></c:redirect>

	</c:if>
<%@include file="Component/Navbar.jsp"%>
	<div class="container">
	<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
				<%
					User us = (User) session.getAttribute("userobj");
					BookOrderDAOImp dao = new BookOrderDAOImp(DBConnection.getConn());
					List<BookOrder> list = dao.getBookUser(us.getEmail());
					for (BookOrder b : list) {
				%>

				<tr>
					<th scope="row"><%=b.getOrderid()%></th>
					<td><%=b.getUser_name()%></td>
					<td><%=b.getBook_name()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getPayment()%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>




	</div>


	
</body>
</html>