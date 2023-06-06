<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script src="../resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h1>Login Home</h1>
		
		<c:url value="/auth" var="loginAction"></c:url>
		<sf:form action="${loginAction}" method="post" cssClass="w-50">
			
			<div class="mb-3">
				<label class="form-label">Login Id</label>
				<input type="text" name="username" placeholder="Enter Login Id" class="form-control" />
			</div>
			
			<div class="mb-3">
				<label class="form-label">Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control" />
			</div>

			<button type="submit" class="btn btn-primary">Login</button>
		</sf:form>
		
	
	</div>

</body>
</html>