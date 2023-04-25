<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<nav class="navbar navbar-expand navbar-dark bg-danger">
	<div class="container">
		<span class="navbar-brand">
			Spring Boots MVC
		</span>
		
		<ul class="navbar-nav">
			<li class="nav-item">
				<c:url value="/course" var="courseLink"></c:url>
				<a href="${courseLink}" class="nav-link">Courses</a>
			</li>
		</ul>
	</div>
</nav>	