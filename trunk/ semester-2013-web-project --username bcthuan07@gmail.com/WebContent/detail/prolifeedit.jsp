<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh Sửa Account</title>
</head>
<body>

<form action="ProlifeEdit" method="post">
	<label>Username:</label>
	<input type="text" name="username">
	<label>Password cũ:</label>
	<input type="password" name="oldpassword">
	<label>Password mới:</label>
	<input type="password" name="newpassword1">
	<label>Nhap lai password</label>
	<input type="password" name="newpassword2">
	<label>First name:</label>
	<input type="text" name="firstname">
	<label>Last name:</label>
	<input type="text" name="lastname">
	<label>Phonenumber</label>
	<input type="text" name="phonenumber">
	<label>Gioi tinh</label>
	<input type="text" name="gioitinh">
	<label>email</label>
	<input type="text" name="email">

</form>


</body>
</html>