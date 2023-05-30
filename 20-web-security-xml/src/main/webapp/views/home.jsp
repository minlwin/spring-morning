<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>
<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script src="../resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h1>Spring Security</h1>
	
		<div class="mt-4">
			<c:url value="/admin" var="adminHome"></c:url>
			<c:url value="/member" var="memberHome"></c:url>
			
			<a href="${adminHome}" class="btn btn-primary me-2">Admin Home</a>
			<a href="${memberHome}" class="btn btn-primary">Member Home</a>
		</div>

	</div>

</body>
</html>