<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() + "/";
	String pathToMarkUp = contextPath + "manage/";

	String username = request.getAttribute("username") == null ? ""
			: (String) request.getAttribute("username");
	String username_err = request.getAttribute("username_err") == null ? ""
			: (String) request.getAttribute("username_err");
	String password_err = request.getAttribute("password_err") == null ? ""
			: (String) request.getAttribute("password_err");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Đăng nhập - Admin</title>
<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

<!-- Bootstrap core CSS -->
<link href="<%=pathToMarkUp%>css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<%=pathToMarkUp%>css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=pathToMarkUp%>font-awesome/css/font-awesome.min.css">
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<link rel="stylesheet" href="<%=pathToMarkUp%>css/formsignin.css">
</head>

<body>
	<div class="container">
		<form action="<%=contextPath%>Manage/LoginManage" method="post"
			class="form-signin" role="form">
			<div class="form-group">
				<label for="username">Username:</label><input class="form-control"
					type="text" id="username" name="username" placeholder="Username"
					value="<%=username%>">
				<p class="help-block"><%=username_err%></p>
			</div>
			<div class="form-group">
				<label for="password">Password:</label><input class="form-control"
					placeholder="Password" id="password" type="password"
					name="password">
				<p class="help-block"><%=password_err%></p>
			</div>
			<div class="form-group">
				<input class="form-control btn btn-success" type="submit"
					value="Đăng Nhập">
			</div>
		</form>
		<hr>


	</div>


</body>
</html>