<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Home</title>

<link rel="stylesheet" href="../resources/style/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	
	<div class="container mt-4">
		<h1>Manager Home</h1>
		
		<div class="d-flex">
			
			<c:url value="/manager/member" var="memberUrl"></c:url>
			<a href="${memberUrl}" class="btn btn-danger me-2">Members</a>

			<c:url value="/logout" var="logoutLink" />
			<sf:form action="${logoutLink}">
				<button class="btn btn-primary" type="submit">Logout</button>
			</sf:form>
		</div>
	</div>

</body>
</html>