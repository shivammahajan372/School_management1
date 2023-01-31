<%@page import="entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>TEACHER DETAILS</h2>
<% Teacher t = (Teacher) request.getAttribute("data"); %>
<table border="1px solid black">
<tr>
<td>Id</td>
<td>Name</td>
<td>Subject</td>
<td>Salary</td>
</tr>
<tr> 
<td><%= t.getId() %></td>
<td><%= t.getName() %></td>
<td><%= t.getSubject() %></td>
<td><%= t.getSal() %></td>
</tr>
</table>
</body>
</html>