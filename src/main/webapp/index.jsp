<%@page import="com.entity.User"%>
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
.back-img {
	background: url("images/books.jpg");
	heigth: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>

</head>
<body style="background-color: #f7f7f7">
	<%@include file="Component/Navbar.jsp"%>

	<%
		User u = (User) session.getAttribute("userobj");
	%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-danger">
			<i class="fas fa-book"></i>E-book Management System
		</h2>
	</div>

	<!-- Start Recent Book   -->

	<div class="container">
		<h3 class="text-center">Recent Book</h3>
		<div class="row">

			<%
				BookDAOImp da = new BookDAOImp(DBConnection.getConn());
				List<BookDetails> li = da.getrecentBooks();
				for (BookDetails d : li) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=d.getPhotoname()%>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
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

							<a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
							<%
								}else{
							%>
                             <a href="cart?bid=<%=d.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                             <%
								} 
                            %>
						
							 <a
								href="view_Book.jsp?bid=<%=d.getBookId()%>"
								class="btn btn-success btn-sm ">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><i class="fas fa-rupee-sign"></i><%=d.getPrice()%></i></a>
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
		<div class="text-center mt-1">
			<a href="all_RecentBook.jsp"
				class="btn btn-danger btn-sm text-white mt-1 mb-3">View All</a>
		</div>
	</div>
	<hr>
	<!-- End Recent Book   -->

	<!-- Start New Book   -->

	<div class="container">
		<h3 class="text-center">New Book</h3>
		<div class="row">
			<%
				BookDAOImp dao = new BookDAOImp(DBConnection.getConn());
				List<BookDetails> list = dao.getnewBooks();
				for (BookDetails b : list) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="books/<%=b.getPhotoname()%>"
							style="width: 150px; heigth: 200px" class="img-thumblin">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories:<%=b.getBookCategory()%>
						</p>
						<div class="row">

							<%
								if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
							<%
								}else{
							%>
                             <a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                             <%
								} 
                            %>

							 <a
								href="view_Book.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><i
								class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<div class="text-center mt-2">
			<a href="all_NewBook.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>
	<hr>
	<!-- End New Book   -->


	<!-- Start Old Book   -->
	<div class="container">
		<h3 class="text-center">Old Book</h3>
		<div class="row">

			<%
				BookDAOImp d = new BookDAOImp(DBConnection.getConn());
				List<BookDetails> list3 = d.getoldBooks();
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
							<a href="view_Book.jsp?bid=<%=s.getBookId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1">350</a>
						</div>

					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>

		<div class="text-center mt-1">
			<a href="all_OldBooks.jsp"
				class="btn btn-danger btn-sm text-white mt-1 mb-1">View All</a>
		</div>
	</div>

	<!-- End Old Book   -->

	<%@include file="Component/Footer.jsp"%>
</body>
</html>