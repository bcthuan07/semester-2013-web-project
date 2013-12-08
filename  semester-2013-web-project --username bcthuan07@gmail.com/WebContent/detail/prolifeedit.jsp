<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User user = (User) session.getAttribute("user");
    	String username = "";
    	String fullname = "";
    	String phonenumber = "";
    	String email = "";
    	boolean gioitinh = true;
    	if(user!=null){
    		username = user.getUsername();
    		fullname = user.getFullname();
    		phonenumber = user.getPhoneNumber();
    		email = user.getEmail();
    		gioitinh = user.getGender();
    	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh Sửa Account</title>
</head>
<body>

<form action="ProlifeEdit" method="post">
	<label>Username:</label>
	<input type="text" name="username" value="<%=username%>">
	<label>Password cũ:</label>
	<input type="password" name="oldpassword">
	<label>Password mới:</label>
	<input type="password" name="password1">
	<label>Nhap lai password</label>
	<input type="password" name="password2">
	<label>Ten day du:</label>
	<input type="text" name="fullname" value="<%=fullname%>">
	<label>Phonenumber</label>
	<input type="text" name="phonenumber" value="<%=phonenumber %>">
	<label>Gioi tinh</label>
	<select name="gioitinh">
		<%if(gioitinh) {%>
		<option value="Nam" selected>Nam</option>
		<option value="Nu" >Nữ</option>
		<%}else{ %>
		<option value="Nam" >Nam</option>
		<option value="Nu" selected>Nữ</option>
		<%} %>
	</select>
	<label>email</label>
	<input type="text" name="email">

</form>


</body>
</html>