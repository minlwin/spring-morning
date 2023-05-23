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
					<form:select path="course" cssClass="form-select">
						<option value="">Select One</option>
						<form:options items="${courses}" itemLabel="name" itemValue="id"/>						
					</form:select>
					<form:errors path="course" />
				</div>
				
				<!-- Start Date -->
				<div class="mb-3">
					<label class="form-label">Start Date</label>
					<form:input type="date" path="startDate" cssClass="form-control"/>
					<form:errors path="startDate" />
				</div>
				
				<!-- Days -->
				<div class="mb-3">
					<label class="form-label">Days</label>
					<div class="row row-cols-4">
						<form:checkboxes element="div class='col'" cssClass="me-1" items="${days}" path="days"/>
					</div>
					<form:errors path="days" />
				</div>
				
				<div class="row mb-3">
					<!-- Start Time -->
					<div class="col">
						<label class="form-label">Start Time</label>
						<form:input path="startTime" type="time" cssClass="form-control"/>
						<form:errors path="startTime" />
					</div>
							
					<!-- End Time -->
					<div class="col">
						<label class="form-label">End Time</label>
						<form:input path="endTime" type="time" cssClass="form-control"/>
						<form:errors path="endTime" />
					</div>
				</div>
				
				
				<!-- Seats -->
				<div class="mb-3">
					<label class="form-label">Available Seats</label>
					<form:input path="seats" type="number" cssClass="form-control"/>
					<form:errors path="seats" />
				</div>
				
				
				<!-- Save Button -->
				<button type="reset" class="btn btn-primary me-2">Clear</button>
				
				<button type="submit" class="btn btn-primary">Save</button>
			
			</form:form>
			
		</div>
	</div>
	
</div>

</body>
</html>