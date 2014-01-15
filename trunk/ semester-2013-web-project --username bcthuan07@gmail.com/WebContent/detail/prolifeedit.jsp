<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	String username = "";
	String fullname = "";
	String email = "";

	boolean gioitinh = true;
	String email_err = "";
	String oldpassword_err = "";
	String password1_err = "";
	String password2_err = "";
	String phonenumber = request.getAttribute("phonenumber") == null ? ""
			: (String) request.getAttribute("phonenumber");
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

	String fullname_err = request.getAttribute("fullname_err") == null ? ""
			: (String) request.getAttribute("fullname_err");

	if (user == null) {
		response.sendRedirect(request.getContextPath() + "/home.jsp");
	} else if (user != null) {
		username = user.getUsername();
		fullname = request.getAttribute("fullname") == null ? user
				.getFullname() : (String) request
				.getAttribute("fullname");
		email = request.getAttribute("email") == null ? user.getEmail()
				: (String) request.getAttribute("email");
		gioitinh = user.getGender();
		phonenumber = request.getAttribute("phonenumber") == null ? user
				.getPhoneNumber().toString() : (String) request
				.getAttribute("phonenumber");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Thông tin tài khoản</title>
<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

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
				<a class="navbar-brand" href="<%=contextPath%>home.jsp">Nhà Hàng
					Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=contextPath%>home.jsp">Trang Chủ</a></li>
					<li><a href="<%=contextPath%>Menu">Thực Đơn</a></li>
					<li><a href="<%=contextPath%>lienhe.jsp">Liên Hệ</a></li>
					<li><a href="<%=contextPath%>order/cartview.jsp">Giỏ Hàng</a></li>

					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<h2>Thông tin tài khoản</h2>
				<hr>
				<div class="well">
					<form action="<%=contextPath%>EditProlife" method="post"
						class="form-horizontal">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">Username:</label>
							<div class="col-sm-3">
								<input class="form-control" id="username" type="text"
									name="username" value="<%=username%>" disabled="disabled">
							</div>
						</div>

						<div class="form-group">
							<label for="oldpass" class="col-sm-2 control-label">Password
								cũ:</label>
							<div class="col-sm-4">
								<input type="password" name="oldpassword" class="form-control"
									id="oldpass">
								<p class="help-block"><%=oldpassword_err%></p>
							</div>
						</div>

						<div class="form-group">
							<label for="pass1" class="col-sm-2 control-label">Password
								mới:</label>
							<div class="col-sm-4">
								<input type="password" name="password1" class="form-control"
									id="pass1">
								<p class="help-block"><%=password1_err%></p>
							</div>
						</div>

						<div class="form-group">
							<label for="pass2" class="col-sm-2 control-label">Nhập
								lại Password mới:</label>
							<div class="col-sm-4">
								<input type="password" name="password2" class="form-control"
									id="pass2">
								<p class="help-block"><%=password2_err%></p>
							</div>
						</div>

						<div class="form-group">
							<label for="fullname" class="col-sm-2 control-label">Họ
								và tên:</label>
							<div class="col-sm-4">
								<input type="text" name="fullname" value="<%=fullname%>"
									class="form-control" id="fullname">
								<p class="help-block"><%=fullname_err%></p>
							</div>
						</div>

						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">Số điện
								thoại:</label>
							<div class="col-sm-3">
								<input type="text" name="phonenumber" value="<%=phonenumber%>"
									class="form-control" id="phone">
								<p class="help-block"><%=phonenumber_err%></p>
							</div>
						</div>

						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">Giới
								tính:</label>
							<div class="col-sm-2">
								<select name="gioitinh" id="gender" class="form-control">
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
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Địa chỉ
								Email:</label>
							<div class="col-sm-4">
								<input type="text" name="email" value="<%=email%>" id="email"
									class="form-control">
								<p class="help-block"><%=email_err%></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Điểm thưởng tích lũy:</label>
							<div class="col-sm-3">
								<span class="form-control"><%=user.getScore().toString() %></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-3 col-sm-offset-2">
								<input class="form-control btn btn-success" type="submit"
									value="Lưu">
							</div>
						</div>
					</form>
				</div>
			</div>
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
	<script src="<%=contextPath%>js/jquery-1.10.2.js"></script>
	<script src="<%=contextPath%>js/bootstrap.js"></script>
	<script src="<%=contextPath%>js/holder.js"></script>


</body>

</html>