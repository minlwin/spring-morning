<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>

<c:url value='/resources/style/bootstrap.min.css' var="bootstrapCss"></c:url>
<link rel="stylesheet" href="${bootstrapCss}" />

<c:url value="/resources/style/common.css" var="commonCss"></c:url>
<link rel="stylesheet" href="${commonCss}" />

<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJs"></c:url>
<script src="${bootstrapJs}"></script>

</head>
<body>

<jsp:include page="/include/navbar.jsp"></jsp:include>

<div class="container pt-4">
	<h3>Session Details</h3>
	

</div>

</body>
</html>