<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	Product product = (Product) request.getAttribute("product");
	String name = "";
	String description = "";
	String type = "";
	String price = "";
	String id = "";
	String number_err = "";
	String quantity = "";
	if (product != null) {
		name = product.getProductName();
		description = product.getDescription();
		type = product.getProductType().getDescription();
		price = product.getPrice().toString();
		id = product.getProductId() + "";
		quantity = product.getQuantity().toString();

	}
	if (request.getAttribute("number_err") != null) {
		number_err = (String) request.getAttribute("number_err");
	}
	String contextPath = request.getContextPath() + "/";
	String username = user == null ? "Thành Viên" : "Xin Chào "
			+ user.getUsername();
	boolean permission = user == null ? false : user.getPermission();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Three Column Portfolio Template for Bootstrap 3</title>

<!-- Bootstrap core CSS -->
<link href="<%=contextPath%>css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="<%=contextPath%>css/3-col-portfolio.css" rel="stylesheet">
</style>
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
				<a class="navbar-brand" href="<%=contextPath%>home.jsp">Start
					Bootstrap</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#about">About</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="#contact">Contact</a></li>

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
							%>
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
							<input type="submit" value="Tìm Kiếm" class="btn btn-success">
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<br><br><br>
		<div class="row">
			<div class="col-md-7">
				<a href="ProductInfo?product=<%=product.getProductId()%>"><img class="img-responsive"
					src=""></a>
			</div>
			<div class="col-md-3">
				<p>Tên: <%=name%></p>
				<p>Chi tiết:<%=description%></p>
				<p>Loại:<%=type%></p>
				<p>Giá:<%=price%></p>
				<p>Số lượng còn lại:<%=quantity%></p>
				<form action="ChooseProduct" method="post">
					<input type="hidden" name="id" value="<%=id%>"> <input
						type="number" name="number" value="1"><span><%=number_err%></span>
					<input class="btn btn-primary" type="submit"
						value="Thêm vào giỏ hàng">
				</form>
			</div>
		</div>
	</div>
	<footer>
		<div class="info">
			<p>COPYRIGHT © 2013</p>
			<a href="lienhe.jsp"> <b>Liên Hệ </b>
			</a>
		</div>
	</footer>
</body>
</html>