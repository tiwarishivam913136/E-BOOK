<%@page import="com.entity.BookDetails"%>
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
<title>Admin:Add_Books</title>
<%@include file="cssAndJs.jsp"%>
</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar_admin.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card ">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>

						<%
							int id = Integer.parseInt(request.getParameter("id"));
							BookDAOImp dao = new BookDAOImp(DBConnection.getConn());
							BookDetails b = dao.getBooKById(id);
						%>


						<form action="../books_edit" method="post">
						<input type="hidden" name="id" value="<%=b.getBookId()%>">

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="bname"
									value="<%=b.getBookName()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="author"
									value="<%=b.getAuthor()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="price"
									value="<%=b.getPrice()%>">
							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="bstatus" class="form-control">
									<%
										if ("Active".equals(b.getStatus())) {
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<%
										} else {
									%>
									<option value="Inactive">Inactive</option>
									<option value="Active">Active</option>
									<%
										}
									%>
								</select>
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>