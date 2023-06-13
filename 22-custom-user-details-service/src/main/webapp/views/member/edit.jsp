<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Member</title>

<link rel="stylesheet" href="../../resources/style/bootstrap.min.css" />
<script type="text/javascript" src="../../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>


	<div class="container mt-4">
		<h3>Edit Member</h3>
		
		<sf:form method="post" cssClass="w-50" modelAttribute="form" >
			
			<sf:hidden path="id"/>
			
			<!-- Role -->
			<div class="mb-3">
				<label class="form-label">Role</label>
				<sf:select cssClass="form-select" path="role">
					<sf:option value="">Select One</sf:option>
					<sf:options items="${roles}"/>
				</sf:select>
				<sf:errors path="role" cssClass="text-secondary" />
			</div>

			<!-- Name -->
			<div class="mb-3">
				<label class="form-label">Name</label>
				<sf:input path="name" placeholder="Please enter Name." cssClass="form-control"/>
				<sf:errors path="role" cssClass="text-secondary" />
			</div>
			
			<!-- Email -->	
			<div class="mb-3">
				<label class="form-label">Email</label>
				<sf:input path="email" placeholder="Please enter Email." type="email" cssClass="form-control"/>
				<sf:errors path="role" cssClass="text-secondary" />
			</div>
			
			<!-- Retired Date -->
			<div class="mb-3">
				<label class="form-label">Retire Date</label>
				<sf:input path="expired" type="date" cssClass="form-control"/>
			</div>
			
			<div class="mb-3 row">
				<!-- Activated -->	
				<div class="col-auto">
					<sf:checkbox path="activated" id="activated"/>
					<label for="activated">Active</label>
				</div>
				<!-- Locked -->
				<div class="col">
					<sf:checkbox path="locked" id="locked"/>
					<label for="locked">Locked</label>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary">
				Save
			</button>
			
		</sf:form>
	</div>

</body>
</html>