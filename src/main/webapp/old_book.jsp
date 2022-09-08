<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.BookDAOImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Old Book</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body>
	<%@include file="Component/Navbar.jsp"%>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center">${succMsg}</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>


	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
					User u = (User) session.getAttribute("userobj");
					String email = u.getEmail();
					BookDAOImp dao = new BookDAOImp(DBConnection.getConn());
					List<BookDetails> list = dao.getBookByOld(email, "Old");
					for (BookDetails b : list) {
				%>
				<tr>
					<th scope="row"><%=b.getBookName()%></th>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getBookCategory()%></td>
					<td><a
						href="delete_old_book?em=<%=email%>&&bid=<%=b.getBookId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div style="margin-top: 280px;">
		<%@include file="Component/Footer.jsp"%>
	</div>
</body>
</html>