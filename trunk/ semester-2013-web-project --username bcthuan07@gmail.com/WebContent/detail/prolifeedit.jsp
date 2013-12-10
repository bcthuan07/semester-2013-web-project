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
    	if(request.getAttribute("email")!=null){
    		fullname=(String) request.getAttribute("fullname");
    		phonenumber = (String) request.getAttribute("phonenumber");
    		email = (String) request.getAttribute("email");
    	}
    	else if(user!=null){
    		username = user.getUsername();
    		fullname = user.getFullname();
    		phonenumber = user.getPhoneNumber();
    		email = user.getEmail();
    		gioitinh = user.getGender();
    	}
    	
		String phonenumber_err = "";
		String email_err = "";
		String oldpassword_err = "";
		String password1_err = "";
		String password2_err = "";
		if(request.getAttribute("phonenumber_err")!=null)
	phonenumber_err = (String) request.getAttribute("phonenumber_err");
		
		if(request.getAttribute("email_err")!=null)
	email_err = (String) request.getAttribute("email_err");
		
		if(request.getAttribute("oldpassword_err")!=null)
	oldpassword_err = (String) request.getAttribute("oldpassword_err");
		
		if(request.getAttribute("phonenumber_err")!=null)
	password1_err = (String) request.getAttribute("password1_err");
		
		if(request.getAttribute("phonenumber_err")!=null)
	password2_err = (String) request.getAttribute("password2_err");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh Sửa Account</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/EditProlife" method="post">
		<label>Username:</label> <input type="text" name="username"
			value="<%=username%>"><br> <label>Password cũ:</label>
		<input type="password" name="oldpassword"><br> <label>Password
			mới:</label> <input type="password" name="password1"><br> <label>Nhap
			lai password</label> <input type="password" name="password2"><br>
		<label>Ten day du:</label> <input type="text" name="fullname"
			value="<%=fullname%>"><br> <label>Phonenumber</label> <input
			type="text" name="phonenumber" value="<%=phonenumber%>"><br>
		<label>Gioi tinh</label> <select name="gioitinh">
			<%
				if(gioitinh) {
			%>
			<option value="Nam" selected>Nam</option>
			<option value="Nu">Nữ</option>
			<%
				}else{
			%>
			<option value="Nam">Nam</option>
			<option value="Nu" selected>Nữ</option>
			<%
				}
			%>
		</select><br> <label>email</label> <input type="text" name="email"
			value="<%=email%>"> <input type="submit" value="Lưu">
	</form>
	<%=email_err%>
	<%=phonenumber_err%>
	<%=oldpassword_err%>
	<%=password1_err%>
	<%=password2_err%>

</body>
</html>