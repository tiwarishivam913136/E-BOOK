<%@page import="com.user.servlet.RegisterServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-book: Register</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="Component/Navbar.jsp"%>

	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="class-body">
						<h4 class="text-center mt-2">Registration Page</h4>
						
						<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session" />
						</c:if>
					
						<form action="register" method="post">

							<div class="form-group ml-3 mr-3">
								<label for="exampleInputEmail1">Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname">
							</div>
							<div class="form-group ml-3 mr-3">
								<label for="exampleInputEmail1">Email Address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group ml-3 mr-3">
								<label for="exampleInputEmail1">Phone No</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phnno">
							</div>
							<div class="form-group ml-3 mr-3">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" required="required" name="pwd">
							</div>
							<div class="form-check ml-3 mr-3">
								<input type="checkbox" class="form-check-input " name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree Terms & Condition</label>
							</div>
							
							
							<button type="submit" class="btn btn-primary ml-2 mt-1 mb-3 ">Register</button>
							<button type="reset" class="btn btn-primary ml-4 mt-1 mb-3 ">Reset</button>
							


						</form>

					</div>
				</div>

			</div>

		</div>

	</div>


	<%@include file="Component/Footer.jsp"%>
</body>
</html>