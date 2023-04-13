<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1 class="pb-3 pt-3">Report Application</h1>
<form:form action="search" modelAttribute="search" method="POST">
	<table>
	<tr>
	<td>Plan Name:</td>
	<td><form:select path="planName">
	<form:option value="">-Select-</form:option>
	<form:options items="${names}"/>
	</form:select>
	</td>
	</tr>
	<tr>
	<td>Plan Status:</td>
	<td><form:select path="planStatus">
	<form:option value="">-Select-</form:option>
	<form:options items="${status}"/>
	</form:select>
	</td>
	</tr>
	<tr>
	<td>Gender:</td>
	<td><form:select path="gender">
	<form:option value="">-Select-</form:option>
	<form:option value="male">Male</form:option>
	<form:option value="female">FeMale</form:option>
	</form:select>
	</td>
	</tr>
	<tr>
	<td>
	StartDate:
	</td>
	<td><form:input path="planStartDate" type="date"/></td>
	<td>
	EndDate:
	</td>
	<td><form:input path="planEndDate" type="date"/></td>
	</tr>
	<tr>
	<td><a href="/insurence/" class="btn btn-secondary">Reset</a></td>
	<td><input type="submit" value="search" class="btn btn-primary"/></td>
	</tr>
	</table>
	</form:form>
	<hr/>
	<table class="table table-striped table-hover" >
	<thead>
	<tr>
	<th>citizenId</th>
	<th>citizenName</th>
	<th>gender</th>
	<th>planName</th>
	<th>planStatus</th>
	<th>planStartDate</th>
	<th>planEndDate</th>
	<th>benifitAmount</th>
	<th>deniadReason</th>
	<th>terminatedDate</th>
	<th>terminatedReason</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${plans}" var="plan" varStatus="index">
	<tr>
    <td>${index.count}</td>
     <td>${plan.citizenName}</td>
     <td>${plan.gender}</td>
     <td>${plan.planName}</td>
     <td>${plan.planStatus}</td>
     <td>${plan.planStartDate}</td>
     <td>${plan.planEndDate}</td>
     <td>${plan.benifitAmount}</td>
     <td>${plan.deniadReason}</td>
     <td>${plan.terminatedDate}</td>
     <td>${plan.terminatedReason}</td>
	</tr>
	</c:forEach>
	<tr>
	<c:if test="${empty plans}">
	<td colspan="11" style="text-align:center">No Records Found</td>
	</c:if>
	</tr>
	</tbody>
	</table>
	
	<hr/>
	Export:<a href="/insurence/excel">Excel</a>  <a href="/insurence/pdf">Pdf</a>
</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>