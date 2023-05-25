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
	
	<div class="row">
		<div class="col-6">
			
			<!-- Course -->
			<div class="mb-3">
				<label class="form-label">Course Name</label>
				<span class="form-control">${dto.course.name}</span>
			</div>
			
			<!-- Level -->
			<div class="mb-3">
				<label class="form-label">Level</label>
				<span class="form-control">${dto.course.level}</span>
			</div>
			
			<div class="row mb-3">
				<!-- Start Date -->
				<div class="col">
					<label class="form-label">Start Date</label>
					<span class="form-control">${dto.startDate}</span>
				</div>
			
				<div class="col">
					<label class="form-label">Time From</label>
					<span class="form-control">${dto.startTime}</span>
				</div>

				<div class="col">
					<label class="form-label">Time To</label>
					<span class="form-control">${dto.endTime}</span>
				</div>
			</div>
			
			<div class="mb-3">
			
				<label class="form-label">Days</label>
				
				<div class="form-control d-flex">
					<c:forEach var="item" items="${dto.days}">
						<div class="me-3">${item}</div>
					</c:forEach>
				</div>
			</div>
	
			<div class="row mb-3">
				<!-- Hours -->
				<div class="col">
					<label class="form-label">Duration</label>
					<span class="form-control">${dto.course.months} Months</span>
				</div>

				<!-- Seats -->			
				<div class="col">
					<label class="form-label">Available Seats</label>
					<span class="form-control">${dto.seats}</span>
				</div>

				<!-- Fees -->			
				<div class="col">
					<label class="form-label">Fees</label>
					<span class="form-control">${dto.course.fees}</span>
				</div>
			
			</div>

			<div>
				<c:url value="/session/edit" var="editLink">
					<c:param name="id" value="${dto.id}" />
				</c:url>
				<a href="${editLink}" class="btn btn-outline-primary">Edit Session</a>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>