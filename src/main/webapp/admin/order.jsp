<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.entity.BookOrder"%>
<%@page import="java.util.List"%>
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
<title>Admin:all_books</title>
<%@include file="cssAndJs.jsp"%>
</head>
<body>
	<%@include file="navbar_admin.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<h3 class="text-center">Hello Admin</h3>
	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">BookName</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>

			<%
				User us = (User) session.getAttribute("userobj");
				BookOrderDAOImp dao = new BookOrderDAOImp(DBConnection.getConn());
				List<BookOrder> list = dao.getAllOrder();
				for (BookOrder b : list) {
			%>



			<tr>
				<th scope="row"><%=b.getOrderid()%></th>
				<td><%=b.getUser_name()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getAddress()%></td>
				<td><%=b.getPhone()%></td>
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
	<div style="margin-top: 200px;">
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>