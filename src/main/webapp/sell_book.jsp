<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Book</title>
<%@include file="Component/cssAndJs.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="Component/Navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<form action="add_old_book" method="post"
							enctype="multipart/form-data">

							<h5 class="text-center text-info p-1">Sell Old Book</h5>

							<input type="hidden" value="${userobj.email}" name="user">

							<c:if test="${not empty succMsg }">
								<h5 class="text-center text-success">${succMsg}</h5>
								<c:remove var="succMsg" scope="session" />
							</c:if>

							<c:if test="${not empty failedMsg }">
								<h5 class="text-center text-danger">${failedMsg}</h5>
								<c:remove var="failedMsg" scope="session" />
							</c:if>

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="bname">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="author">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="price">
							</div>

							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label><input
									name="bimg" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>

							<div class="text-center p-2">
								<button type="submit" class="btn btn-primary btn-block btn-sm">Sell</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 20px;">
		<%@include file="Component/Footer.jsp"%>
	</div>

</body>
</html>