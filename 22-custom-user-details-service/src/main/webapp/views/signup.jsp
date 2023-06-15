<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<div class="container mt-4">
	
		<h1>Customer Sign Up</h1>
	
		<c:url value="/signup" var="signUp" />
		<sf:form action="${signUp}" cssClass="w-50" modelAttribute="form">
		
			<div class="mb-3">
				<label class="form-label">Customer Name</label>
				<sf:input path="name" cssClass="form-control" placeholder="Enter Customer Name"/>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Email</label>
				<sf:input path="email" type="email" cssClass="form-control" placeholder="Enter Email Address"/>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label>
				<sf:input path="password" type="password" cssClass="form-control" placeholder="Enter Password"/>
			</div>

			<button class="btn btn-outline-primary" type="submit">Sign Up</button>
		</sf:form>
	</div>


</body>
</html>