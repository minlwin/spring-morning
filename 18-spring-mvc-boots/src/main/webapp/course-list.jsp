<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			
			<a href="#" class="btn btn-outline-danger">
				Add New
			</a>
		</div>
	</form>
	
	<!-- Result List -->
</div>

</body>
</html>