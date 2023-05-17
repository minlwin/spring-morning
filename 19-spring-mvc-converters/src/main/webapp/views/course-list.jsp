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
	<h3>Course Management</h3>
	
	<!-- Search Bar -->
	<form class="row">
		<div class="col-auto">
			<label class="form-label">Search Keyword</label>
			<input type="text" name="name" class="form-control" placeholder="Search Keyword" />
		</div>
		
		<div class="col-auto btn-wrapper">
			<button class="btn btn-outline-primary me-2">
				Search
			</button>
			
			<c:url value="/course/edit" var="addNewCourse"></c:url>
			<a href="${addNewCourse}" class="btn btn-outline-danger">
				Add New
			</a>
		</div>
	</form>
	
	<!-- Result List -->
	<table class="table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Months</td>
				<td>Fees</td>
				<td></td>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>
					<c:url value="/course/${item.id}" var="detailsLink"></c:url>
					<a href="${detailsLink}" class="btn-link">${item.name}</a>
				</td>
				<td>${item.months}</td>
				<td>${item.fees}</td>
				<td>
					<c:url value="/course/edit" var="editCourse">
						<c:param name="id" value="${item.id}"></c:param>
					</c:url>
					<a href="${editCourse}" class="btn-link">
						Edit
					</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
</div>

</body>
</html>