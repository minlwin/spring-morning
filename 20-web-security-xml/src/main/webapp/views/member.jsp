<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Page</title>
<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script src="../resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h1>Member Home</h1>

		<c:url value="/logout" var="logoutAction"></c:url>
		<sf:form action="${logoutAction}" method="post">
			<button class="btn btn-primary">Logout</button>
		</sf:form>
	
	</div>

</body>
</html>