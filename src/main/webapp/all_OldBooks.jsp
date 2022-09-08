<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.BookDAOImp"%>
<%@page import="com.entity.BookDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-book : Index Page</title>
<%@include file="Component/cssAndJs.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>

</head>
<body style="background-color: #f7f7f7">
	<%@include file="Component/Navbar.jsp"%>

	<!-- Start Old Book   -->
	<div class="container">
		<h3 class="text-center">Old Book</h3>
		<div class="row">

			<%
				BookDAOImp d = new BookDAOImp(DBConnection.getConn());
				List<BookDetails> list3 = d.allOldBook();
				for (BookDetails s : list3) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=s.getPhotoname()%>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
						<p><%=s.getBookName()%></p>
						<p><%=s.getAuthor()%></p>
						<p>
							Categories:<%=s.getStatus()%></p>
						<div class="row">
							<a href="view_Book.jsp?bid=<%=s.getBookId() %>" class="btn btn-success btn-sm ml-5">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=s.getPrice() %></a>
						</div>

					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>

	<!-- End Old Book   -->

	<%@include file="Component/Footer.jsp"%>
</body>
</html>