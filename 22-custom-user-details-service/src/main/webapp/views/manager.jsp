<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Manager Home</h1>
	
	<c:url value="/logout" var="logoutLink" />
	<sf:form action="${logoutLink}">
		<button type="submit">Logout</button>
	</sf:form>

</body>
</html>