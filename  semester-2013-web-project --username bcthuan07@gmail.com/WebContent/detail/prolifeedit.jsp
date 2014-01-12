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
	if (user == null) {
		response.sendRedirect(request.getContextPath() + "/home.jsp");
	} else if (user != null) {
		username = request.getAttribute("username") == null ? user
				.getUsername() : (String) request
				.getAttribute("username");
		fullname = request.getAttribute("fullname") == null ? user
				.getFullname() : (String) request
				.getAttribute("fullname");
		email = request.getAttribute("email") == null ? user.getEmail()
				: (String) request.getAttribute("email");
		gioitinh = user.getGender();
	}
	
	String email_err = "";
	String oldpassword_err = "";
	String password1_err = "";
	String password2_err = "";

	if (request.getAttribute("email_err") != null)
		email_err = (String) request.getAttribute("email_err");

	if (request.getAttribute("oldpassword_err") != null)
		oldpassword_err = (String) request
				.getAttribute("oldpassword_err");

	if (request.getAttribute("password1_err") != null)
		password1_err = (String) request.getAttribute("password1_err");

	if (request.getAttribute("password2_err") != null)
		password2_err = (String) request.getAttribute("password2_err");
	String contextPath = request.getContextPath() + "/";

	String phonenumber_err = request.getAttribute("phonenumber_err") == null ? ""
			: (String) request.getAttribute("phonenumber_err");
	
	String fullname_err = request.getAttribute("fullname_err")==null?"":(String)request.getAttribute("fullname_err");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Chủ</title>

<!-- Bootstrap core CSS -->
<link href="<%=contextPath%>css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="<%=contextPath%>css/3-col-portfolio.css" rel="stylesheet">
<link href="<%=contextPath%>css/carousel.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=contextPath%>home.jsp">Nhà
					Hàng Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=contextPath%>home.jsp">Trang Chủ</a></li>
					<li><a href="<%=contextPath%>Menu">Thực Đơn</a></li>
					<li><a href="<%=contextPath%>lienhe.jsp">Liên Hệ</a></li>
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<div class="container">
		<form action="<%=contextPath%>EditProlife" method="post">
			<div class="form-group">
				<label for="username">Username:</label> <input class="form-control"
					id="username" type="text" name="username" value="<%=username%>"
					disabled="disabled">
			</div>

			<div class="form-group">
				<label for="oldpass">Password cũ:</label> <input type="password"
					name="oldpassword" class="form-control" id="oldpass">
					<p class="help-block"><%=oldpassword_err %></p>

			</div>

			<div class="form-group">
				<label for="pass1">Password mới:</label> <input type="password"
					name="password1" class="form-control" id="pass1">
					<p class="help-block"><%=password1_err %></p>

			</div>

			<div class="form-group">
				<label for="pass2">Nhập lại Password mới:</label> <input type="password"
					name="password2" class="form-control" id="pass2">
					<p class="help-block"><%=password2_err %></p>

			</div>

			<div class="form-group">
				<label for="fullname">Họ và tên:</label> <input type="text" name="fullname"
					value="<%=fullname%>" class="form-control" id="fullname">
					<p class="help-block"><%=fullname_err %></p>

			</div>

			<div class="form-group">
				<label for="phone">Số điện thoại:</label> <input type="text" name="phonenumber"
					value="<%=phonenumber%>" class="form-control" id="phone">
				<p class="help-block"><%=phonenumber_err%></p>
			</div>

			<div class="form-group">
				<label for="gender">Giới tính:</label> <select name="gioitinh"
					id="gender" class="form-control">
					<%
						if (gioitinh) {
					%>
					<option value="Nam" selected>Nam</option>
					<option value="Nu">Nữ</option>
					<%
						} else {
					%>
					<option value="Nam">Nam</option>
					<option value="Nu" selected>Nữ</option>
					<%
						}
					%>
				</select>
			</div>

			<div class="form-group">
				<label for="email">Địa chỉ Email:</label> <input type="text"
					name="email" value="<%=email%>" id="email" class="form-control">
				<p class="help-block"><%=email_err%></p>
			</div>

			<input type="submit" value="Lưu">
		</form>
	</div>
	<div class="container">

		<hr>

		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2013</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=contextPath%>js/jquery-1.10.2.js"></script>
	<script src="<%=contextPath%>js/bootstrap.js"></script>
	<script src="<%=contextPath%>js/holder.js"></script>


</body>

</html>