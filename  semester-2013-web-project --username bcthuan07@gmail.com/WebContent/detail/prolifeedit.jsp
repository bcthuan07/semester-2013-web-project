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
				.getAttribute("usernam");
		fullname = request.getAttribute("fullname") == null ? user
				.getFullname() : (String) request
				.getAttribute("fullname");
		phonenumber = request.getAttribute("phonenumber") == null ? user
				.getPhoneNumber() : (String) request
				.getAttribute("phonenumber");
		email = request.getAttribute("email") == null ? user.getEmail()
				: (String) request.getAttribute("email");
		gioitinh = user.getGender();
	}

	String phonenumber_err = "";
	String email_err = "";
	String oldpassword_err = "";
	String password1_err = "";
	String password2_err = "";
	if (request.getAttribute("phonenumber_err") != null)
		phonenumber_err = (String) request
				.getAttribute("phonenumber_err");

	if (request.getAttribute("email_err") != null)
		email_err = (String) request.getAttribute("email_err");

	if (request.getAttribute("oldpassword_err") != null)
		oldpassword_err = (String) request
				.getAttribute("oldpassword_err");

	if (request.getAttribute("phonenumber_err") != null)
		password1_err = (String) request.getAttribute("password1_err");

	if (request.getAttribute("phonenumber_err") != null)
		password2_err = (String) request.getAttribute("password2_err");
	String contextPath = request.getContextPath() + "/";
	boolean permission = user == null ? false : user.getPermission();
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
				<a class="navbar-brand" href="http://startbootstrap.com">Nhà
					Hàng Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#about">Trang Chủ</a></li>
					<li><a href="#services">Thực Đơn</a></li>
					<li><a href="#contact">Liên Hệ</a></li>

					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown"><%=username%><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<%
								if (user == null) {
							%><li><a href="login.jsp">Đăng Nhập</a></li>
							<li><a href="register.jsp">Đăng Ký</a></li>
							<%
								}
							%>
							<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
							<!--<li class="dropdown-header">Nav header</li>-->
							<%
								if (user != null) {
							%>
							<li><a href="<%=contextPath%>detail/prolifeinfo.jsp">Thông
									tin tài khoản</a></li>
							<li class="divider"></li>

							<%
								if (permission) {
							%>
							<li><a href="Manage">Trang Quản Lý</a></li>
							<%
								}
							%>
							<li><a href="Logout">Thoát</a></li>
							<%
								}
							%>
						</ul></li>
					<li>
						<form class="navbar-form navbar-right" role="form">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Tìm Kiếm Món Ăn">
							</div>
							<input type="submit" value="Tìm" class="btn btn-success">
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<div class="container">
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
			</select><br> <label>email</label> <input type="text" name="email"
				value="<%=email%>"> <input type="submit" value="Lưu">
		</form>
		<%=email_err%>
		<%=phonenumber_err%>
		<%=oldpassword_err%>
		<%=password1_err%>
		<%=password2_err%>
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