<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-book: Login</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="Component/Navbar.jsp"%>

	<div class="container p-2">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="class-body">
						<h3 class="text-center mt-2">Login</h3>

						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="login" method="post">
							<div class="form-group ml-3 mr-3">
								<label for="exampleInputEmail1">Email Address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group ml-3 mr-3">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="pwd">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary ml-3 mb-2 mt-2">Login</button>
								<br> <a href="register.jsp">Create a new account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<div style="margin-top: 140px;">
	<%@include file="Component/Footer.jsp"%>
</div>	
</body>
</html>