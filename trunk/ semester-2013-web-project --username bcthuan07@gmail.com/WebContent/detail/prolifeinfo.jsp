<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User user = (User) request.getAttribute("user");
    	String username = "";
    	String phonenumber = "";
    	String fullname = "";
    	String email = "";
    	String paymentmethod = "";
    	String gioitinh = "";
    	String id="";
    	if(user != null){
    		username = user.getUsername();
    		fullname=user.getFullname();
    		phonenumber = user.getPhoneNumber() +"";
    		email = user.getEmail();
    		paymentmethod = user.getPaymentMethod().getDescription();
    		gioitinh = user.getGender() ? "Nam" : "Nữ";
    		id=user.getUserId()+"";
    	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=username %></p>
<p><%=fullname %></p>
<p><%=phonenumber %></p>
<p><%=email %></p>
<p><%=gioitinh %></p>
<a href="EditProlife?id=<%=id %>">Chinh sua account</a>
</body>
</html>