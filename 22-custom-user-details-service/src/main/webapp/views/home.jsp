<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>
<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-4">
		<h1>Public Home</h1>
		
		<div>
			<c:url value="/manager" var="managerLink" />
			<a class="btn btn-primary" href="${managerLink}">Manager Home</a>
		
			<c:url value="/employee" var="employeeLink" />
			<a class="btn btn-primary" href="${employeeLink}">Employee Home</a>
		</div>
	
	</div>


</body>
</html>