<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Session</title>

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
	<h3>Session Edit</h3>
	
	<div class="row">
		<div class="col-6">
			
			<c:url value="/session" var="saveAction"></c:url>
			<form:form action="${saveAction}" method="POST" modelAttribute="dto">
			
				<!-- ID -->
				<form:hidden path="id" />
				
				<!-- Course -->
				<div class="mb-3">
					<label class="form-label">Course</label>
					<select name="course" class="form-select">
						<option value="">Select One</option>
						<c:forEach items="${courses}" var="course">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<!-- Start Date -->
				<div class="mb-3">
					<label class="form-label">Start Date</label>
					<input type="date" name="startDate" class="form-control" />
				</div>
				
				<!-- Days -->
				
				<div class="row mb-3">
					<!-- Start Time -->
					<div class="col">
						<label class="form-label">Start Time</label>
						<input type="time" name="startTime" class="form-control" />
					</div>
							
					<!-- End Time -->
					<div class="col">
						<label class="form-label">End Time</label>
						<input type="time" name="endTime" class="form-control" />
					</div>
				</div>
				
				
				<!-- Seats -->
				<div class="mb-3">
					<label class="form-label">Available Seats</label>
					<input type="number" name="seats" placeholder="Enter Available Seats" class="form-control" />
				</div>
				
				
				<!-- Save Button -->
				<button type="submit" class="btn btn-primary">Save</button>
			
			</form:form>
			
		</div>
	</div>
	
</div>

</body>
</html>