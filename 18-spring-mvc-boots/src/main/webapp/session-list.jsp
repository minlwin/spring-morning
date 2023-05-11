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
	<h3>Session Management</h3>
	
	<!-- Search Bar -->
	<form class="row mb-4">
		
		<!-- Level -->
		<div class="col-auto">
			<label class="form-label">Course Level</label>
			<select name="level" class="form-select">
				<option value="">All Level</option>
				<c:forEach items="${levels}" var="level">
					<option value="${level}" ${level eq param.level ? 'selected' : ''}>${level}</option>
				</c:forEach>
			</select>		
		</div>
		
		<!-- Course Name -->
		<div class="col-auto">
			<label class="form-label">Course Name</label>
			<input value="${param.course}" type="text" name="course" class="form-control" placeholder="Search Course Name" />
		</div>
		
		<!-- Date From -->
		<div class="col-auto">
			<label class="form-label">Date From</label>
			<input value="${param.fromDate}" type="date" name="fromDate" class="form-control" />
		</div>
		
		<!-- Date Tom -->
		<div class="col-auto">
			<label class="form-label">Date To</label>
			<input value="${param.toDate}" type="date" name="toDate" class="form-control" />
		</div>
		
		
		<div class="col-auto btn-wrapper">
			<button class="btn btn-outline-primary me-2">
				Search
			</button>
			
			<c:url value="/session/edit" var="addNew"></c:url>
			<a href="${addNew}" class="btn btn-outline-primary">Add New Session</a>
		</div>
	</form>
	
	<!-- Result List -->
	<c:choose>
		<c:when test="${not empty list}">
			<table class="table table-striped">
			
				<thead>
					<tr>
						<th>ID</th>
						<th>Level</th>
						<th>Course</th>
						<th>Start Date</th>
						<th>Days</th>
						<th>Duration</th>
						<th>Fees</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.course.level}</td>
							<td>${item.course.name}</td>
							<td>${item.startDate}</td>
							<td>${item.days}</td>
							<td>${item.course.duration}</td>
							<td>${item.course.fees}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
				
				
			</table>
		</c:when>
		
		<c:otherwise>
			<div class="alert alert-info">
				There is no data.			
			</div>
		</c:otherwise>		
	
	</c:choose>

</div>

</body>
</html>