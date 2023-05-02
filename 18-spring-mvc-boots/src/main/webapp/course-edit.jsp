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
	<h3>Course Edit</h3>
	
	<div class="row">
		<div class="col-6">
			
			<c:url value="/course" var="saveAction"></c:url>
			<form:form action="${saveAction}" method="POST" modelAttribute="dto">
			
				<!-- ID -->
				<form:hidden path="id"/>
							
				<!-- Level -->
				<div class="mb-3">
					<form:label path="level" cssClass="form-label">Level</form:label>
					<form:select path="level" cssClass="form-select">
						<form:option value="">Select Level</form:option>
						<form:options items="${levels}" />
					</form:select>
				</div>
	
				<!-- Name -->
				<div class="mb-3">
					<form:label cssClass="form-label" path="name">Course Name</form:label>
					<form:input path="name" cssClass="form-control" placeholder="Enter Course Name"/>
				</div>
				
				<!-- Months -->
				<div class="mb-3">
					<form:label path="months" cssClass="form-label">Months</form:label>
					<form:input path="months" cssClass="form-control" type="number"/>
				</div>
				
				<!-- Fees -->
				<div class="mb-3">
					<form:label path="fees" cssClass="form-label">Fees</form:label>
					<form:input path="fees" cssClass="form-control" type="number"/>
				</div>
				
				
				<!-- Save Button -->
				<button type="submit" class="btn btn-primary">Save</button>
			
			</form:form>
			
		</div>
	</div>
	
</div>

</body>
</html>