<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Management</title>

<link rel="stylesheet" href="/resources/style/bootstrap.min.css" />
<script type="text/javascript" src="/resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<div class="container mt-4">
			
		<h3>Member Management</h3>
			
		<!-- Search Form -->
		<form class="row">
			<div class="col-auto">
				<label class="form-label">Role</label>
				<select name="role" id="role" class="form-select">
					<option value="">All Roles</option>
					<c:forEach items="${roles}" var="role">
						<option value="${role}" ${role eq param.role ? 'selected' : ''}>${role}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="col-auto">
				<label class="form-label">Keyword</label>
				<input type="text" name="keyword" value="${param.keyword}" class="form-control" placeholder="Search Keyword" />
			</div>
			
			<div class="col" style="padding-top: 2rem;">
				<button type="submit" class="btn btn-primary">Search</button>
				
				<c:url value="/manager/member/edit" var="addNewUrl" />
				<a href="${addNewUrl}" class="btn btn-danger">Add New</a>
			</div>
		</form>
		
		
		<!-- Result List -->
		<table class="table table-striped mt-3">
			<thead>
				<tr>
					<th>Role</th>
					<th>Name</th>
					<th>Email</th>
					<th>Active</th>
					<th>Locked</th>
					<th>Expired At</th>
					<th></th>
				</tr>
			</thead>
			
			<tobody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.role}</td>
						<td>${item.email}</td>
						<td>${item.activated ? 'Yes' : 'No'}</td>
						<td>${item.locked ? 'Yes' : 'No'}</td>
						<td>${item.expired}</td>
						<td>
							<c:url value="/manager/member/edit" var="editUrl">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<a href="${editUrl}">
								Edit
							</a>
						</td>
					</tr>
				</c:forEach>
			</tobody>
		</table>
		
		
	</div>


</body>
</html>