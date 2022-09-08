<%@page import="com.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.DataBase.DBConnection"%>
<%@page import="com.DOA.CartDAOImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body>
	<%@include file="Component/Navbar.jsp"%>

	<c:if test="${empty userobj }">

		<c:redirect url="login.jsp"></c:redirect>

	</c:if>

	<c:if test="${not empty succMsg }">

		<div class="alert alert-success" role="alert">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	
	<c:if test="${not empty failedMsg }">

		<div class="alert alert-danger text-center" role="alert">${failedMsg }</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>
	

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6 mt-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
									User u = (User) session.getAttribute("userobj");
									CartDAOImp dao = new CartDAOImp(DBConnection.getConn());
									List<Cart> c = dao.getBookByUser(u.getId());
									double totalPrice = 0.0;
									for (Cart d : c) {
										totalPrice = d.getTotalprice();
								%>

								<tr>
									<th scope="row"><%=d.getBookname()%></th>
									<td><%=d.getAuthor()%></td>
									<td><%=d.getPrice()%></td>
									<td><a href="removebook?bid=<%=d.getBid()%>&&uid=<%=d.getUid()%>&&cid=<%=d.getCid() %>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>

								<%
									}
								%>

								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><%=totalPrice%></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="col-md-6 mt-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										class="form-control" id="inputEmail4" value="${userobj.name }" name="fname" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										class="form-control" id="inputPassword4" value="${userobj.email }" name="email" required="required">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										type="number" class="form-control" id="inputEmail4" value="${userobj.phno }" name="phnno" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text"
										class="form-control" id="inputPassword4" name="address" required="required">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Land Mark</label> <input type="text"
										class="form-control" id="inputEmail4" name="lmark" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text"
										class="form-control" id="inputPassword4" name="city" required="required">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										class="form-control" id="inputEmail4" name="state" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin Code</label> <input
										type="number" class="form-control" id="inputPassword4" name="zip" required="required">
								</div>
							</div>

							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control" name="ptype">
									<option value="noselect">---Select---</option>
									<option value="COD">Cash on Delivery</option>

								</select>

							</div>
							<div>
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>


						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

<div class="margin-top:100px;">
	<%@include file="Component/Footer.jsp"%>
</div>

</body>
</html>