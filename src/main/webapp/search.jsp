<%@page import="com.entity.User"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.BookDAOImp"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Book</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
<body style="background-color: #f7f7f7">
	<%@include file="Component/Navbar.jsp"%>

	<%
		User u = (User) session.getAttribute("userobj");
	%>

	<div class="container fluid">
		<div class="row p-4">
			<%
				String ch = request.getParameter("search");
				BookDAOImp da = new BookDAOImp(DBConnection.getConn());
				List<BookDetails> l = da.getBookBySearch(ch);
				for (BookDetails d : l) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=d.getPhotoname()%>"
							style="width: 100px; heigth: 200px" class="img-thumblin">
						<p><%=d.getBookName()%></p>
						<p><%=d.getAuthor()%></p>
						<p>
							<%
								if (d.getBookCategory().equals("Old")) {
							%>
							Categories:<%=d.getBookCategory()%></p>
						<div class="row">
							<a href="view_Book.jsp?bid=<%=d.getBookId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><i
								class="fas fa-rupee-sign"></i><%=d.getPrice()%></a>
						</div>
						<p>
							<%
								} else {
							%>
							Categories:<%=d.getBookCategory()%>
						</p>
						<div class="row">


							<%
								if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add
								Cart</a>
							<%
								} else {
							%>
							<a href="cart?bid=<%=d.getBookId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-2">Add Cart</a>
							<%
								}
							%>

							<a href="view_Book.jsp?bid=<%=d.getBookId()%>"
								class="btn btn-success btn-sm ">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><i class="fas fa-rupee-sign"></i><%=d.getPrice()%></a>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>

</body>
</html>