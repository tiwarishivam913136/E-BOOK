<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setting Page</title>
<%@include file="Component/cssAndJs.jsp"%>
<style type="text/css">

a{
  text-decoration: none;
  color: black;
  
}

a:hover{
    text-decoration: none;

}

</style>
</head>

<body style="background-color: #f7f7f7;">
	<%@include file="Component/Navbar.jsp"%>

<c:if test="${empty userobj }">

<c:redirect url="login.jsp"></c:redirect>

</c:if>


	<div class="container">
	<c:if test="${not empty userobj }">
		<h3 class="text-center">Hello,${userobj.name }</h3>
		</c:if>
		<div class="row p-5">
			
			<div class="col-md-4">
				<a href="sell_book.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fas fa-book-open fa-3x"></i>
							</div>
							<h3 Class="text-center">Sell Old Book</h3>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="old_book.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fas fa-edit fa-3x"></i>
							</div>
							<h4 Class="text-center">Old Book</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4">
				<a href="editProfile.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fas fa-edit fa-3x"></i>
							</div>
							<h4 Class="text-center">Edit Profile</h4>
						</div>
					</div>
				</a>
			</div>
			
		
			
			<div class="col-md-6 mt-3">
				<a href="order.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-danger">
								<i class="fas fa-box-open fa-3x"></i>
							</div>
							<h4 Class="text-center">My Order</h4>
							<p>Track Your Order</p>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-6 mt-3">
				<a href="helpLine.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fas fa-user-circle fa-3x"></i>
							</div>
							<h4 Class="text-center">Help Center</h4>
							<p>24 * 7 Service</p>
						</div>
					</div>
				</a>
			</div>


		</div>
	</div>

  <div >
	<%@include file="Component/Footer.jsp"%>
</div>	

</body>
</html>