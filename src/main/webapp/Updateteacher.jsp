<%@page import="entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
	
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("shivam");
		EntityManager em = emf.createEntityManager();
	
		Teacher t = em.find(Teacher.class, id1);
	
	%>
	<form action="update" method="post">
		Id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		salary: <input type="text" value="<%=t.getSal()%>" name="sal">
		subject: <input type="text" value="<%=t.getSubject()%>"name="sub">
		<input type="submit">
	</form>
</body>
</html>