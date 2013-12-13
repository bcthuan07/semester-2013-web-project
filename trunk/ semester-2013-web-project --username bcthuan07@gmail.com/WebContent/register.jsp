<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	User user = (User) session.getAttribute("user");
	if (user != null) {
		response.sendRedirect("home.jsp");
	}
	String username = request.getAttribute("username") != null ? (String) request
			.getAttribute("username") : "";
	String phonenumber = request.getAttribute("phonenumber") != null ? (String) request
			.getAttribute("phonenumber") : "";
	String fullname = request.getAttribute("fullname") != null ? (String) request
			.getAttribute("fullname") : "";
	String email = request.getAttribute("email") != null ? (String) request
			.getAttribute("email") : "";
	String street = request.getAttribute("street") != null ? (String) request
			.getAttribute("street") : "";
	String buildingnumber = request.getAttribute("buildingnumber") != null ? (String) request
			.getAttribute("buildingnumber") : "";
	String zipcode = request.getAttribute("zipcode") != null ? (String) request
			.getAttribute("zipcode") : "";
	String city = request.getAttribute("city") != null ? (String) request
			.getAttribute("city") : "";

	String username_err = request.getAttribute("username_err") != null ? (String) request
			.getAttribute("username_err") : "";
	String phonenumber_err = request.getAttribute("phonenumber_err") != null ? (String) request
			.getAttribute("phonenumber_err") : "";
	String fullname_err = request.getAttribute("fullname_err") != null ? (String) request
			.getAttribute("fullname_err") : "";
	String email_err = request.getAttribute("email_err") != null ? (String) request
			.getAttribute("email_err") : "";
	String street_err = request.getAttribute("street_err") != null ? (String) request
			.getAttribute("street_err") : "";
	String buildingnumber_err = request
			.getAttribute("buildingnumber_err") != null ? (String) request
			.getAttribute("buildingnumber_err") : "";
	String zipcode_err = request.getAttribute("zipcode_err") != null ? (String) request
			.getAttribute("zipcode_err") : "";
	String city_err = request.getAttribute("city_err") != null ? (String) request
			.getAttribute("city_err") : "";
	String password_err = request.getAttribute("password_err") != null ? (String) request
			.getAttribute("password_err") : "";
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
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="css/3-col-portfolio.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">

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
							<li class="divider"></li>
							<!--<li class="dropdown-header">Nav header</li>-->
							<%
								if (user != null) {
							%><li><a href="Logout">Thoát</a></li>
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
		<div style="max-width: 900px; margin-left: auto; margin-right: auto;">
		<form method="post" action="Register">
			<legend>Đăng Ký:</legend>
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Username"
					name="username" value="<%=username%>">
				<p class="help-block"><%=username_err%></p>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password">
				<p class="help-block"><%=password_err%></p>
			</div>
			<div class="form-group">
				<label for="fullname">Tên Đầy Đủ:</label> <input type="text"
					class="form-control" id="fullname" placeholder="Tên Đầy Đủ"
					name="fullname" value="<%=fullname%>">
				<p class="help-block"><%=fullname_err%></p>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Email"
					name="email" value="<%=email%>">
				<p class="help-block"><%=email_err%></p>
			</div>
			<div class="form-group">
				<label for="phone">Số Điện Thoại:</label> <input type="text"
					class="form-control" id="phone" placeholder="Số Điện Thoại"
					name="phonenumber" value="<%=phonenumber%>">
				<p class="help-block"><%=phonenumber_err%></p>
			</div>
			<div class="form-group">
				<label for="gend">Giới Tính</label>
			</div>
			<div class="radio" id="gend">
				<label>
					<input type="radio" value="Nam" name="gender" checked="checked">
					Nam
				</label>
			</div>
			<div class="radio">
				<label>
					<input type="radio" value="Nu" name="gender">
					Nữ
				</label>
			</div>
			<div class="form-group">
				<label for="buildingnumber">Số Nhà:</label> <input type="text"
					class="form-control" id="buildingnumber" placeholder="Số Nhà"
					name="buildingnumber" value="<%=buildingnumber%>">
				<p class="help-block"><%=buildingnumber_err%></p>
			</div>
			<div class="form-group">
				<label for="street">Đường:</label> <input type="text"
					class="form-control" id="street" placeholder="Đường"
					name="street" value="<%=street%>">
				<p class="help-block"><%=street_err%></p>
			</div>
			<div class="form-group">
				<label for="zipcode">Mã Zip Code:</label> <input type="text"
					class="form-control" id="zipcode" placeholder="Mã Zip Code"
					name="zipcode" value="<%=zipcode%>">
				<p class="help-block"><%=zipcode_err%></p>
			</div>
			<div class="form-group">
				<label for="city">Thành Phố:</label> <input type="text"
					class="form-control" id="city" placeholder="Thành Phố"
					name="city" value="<%=city%>">
				<p class="help-block"><%=city_err%></p>
			</div>
			<div class="form-group">
				<input type="submit" class="form-control" value="Đăng Ký">
			</div>
		</form>
	</div>
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
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/holder.js"></script>


</body>