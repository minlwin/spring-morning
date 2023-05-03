<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>

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
	<h3>Course Details</h3>
	
	<div class="row">
		<div class="col-6">
		
			<c:if test="${not empty message}">
			<div class="alert alert-info mb-3">
				${message}
			</div>
			</c:if>
			
			<!-- Name -->
			<div class="mb-3">
				<label class="form-label">Name</label>
				<div class="form-control">${dto.name}</div>
			</div>
			
			<!-- Level -->
			<div class="mb-3">
				<label class="form-label">Level</label>
				<div class="form-control">${dto.level}</div>
			</div>
			
			<!-- Duration -->
			<div class="mb-3">
				<label class="form-label">Duration</label>
				<div class="form-control">${dto.months} Months</div>
			</div>
			
			<!-- Fees -->
			<div class="mb-3">
				<label class="form-label">Fees</label>
				<div class="form-control">${dto.fees} MMK</div>
			</div>
			
			<!-- Edit Button -->
			<c:url value="/course/edit" var="editLink">
				<c:param name="id" value="${dto.id}"></c:param>
			</c:url>
			<a href="${editLink}" class="btn btn-danger">Edit Course</a>
			
		</div>
	</div>
	
</div>

</body>
</html>