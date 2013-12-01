<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User user = (User) request.getAttribute("user");
    	String username = "";
    	String firstname = "";
    	String lastname = "";
    	String phonenumber = "";
    	String email = "";
    	String paymentmethod = "";
    	String gioitinh = "";
    	if(user != null){
    		username = user.getUsername();
    		firstname = user.getFirstName();
    		lastname = user.getLastName();
    		phonenumber = user.getPhoneNumber() +"";
    		email = user.getEmail();
    		paymentmethod = user.getPaymentMethod().getDescription();
    		gioitinh = user.getGender() ? "Nam" : "Nữ";
    		
    	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>