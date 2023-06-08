<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Public Home</h1>
	
	<ul>
		<li>
			<c:url value="/manager" var="managerLink" />
			<a href="${managerLink}">Manager Home</a>
		</li>
		<li>
			<c:url value="/employee" var="employeeLink" />
			<a href="${employeeLink}">Employee Home</a>
		</li>
	</ul>

</body>
</html>