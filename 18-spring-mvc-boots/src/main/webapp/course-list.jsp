<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
<link rel="stylesheet" href="/resources/style/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/style/common.css" />
<script src="/resources/js/bootstrap.bundle.min.js"></script>
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
				<td>${item.name}</td>
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