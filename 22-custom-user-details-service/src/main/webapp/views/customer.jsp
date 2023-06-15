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
	
		<h1>Employee Home</h1>
	
		<c:url value="/logout" var="logoutLink" />
		<sf:form action="${logoutLink}">
			<button class="btn btn-outline-primary" type="submit">Logout</button>
		</sf:form>
	</div>


</body>
</html>