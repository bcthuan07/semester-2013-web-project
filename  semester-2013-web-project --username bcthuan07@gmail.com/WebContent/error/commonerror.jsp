<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String error = "";
	if(request.getAttribute("error")!=null)
		error = (String) request.getAttribute("error");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lỗi</title>
</head>
<body>
<%=error %>
</body>
</html>