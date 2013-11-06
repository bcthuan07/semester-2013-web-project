<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	String username = "";
	if (user != null) {
		username = user.getUsername();
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Nhà Hàng Jamie Oliver's</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--<meta name="description" content="">
    <meta name="author" content="">-->

<!-- Le styles -->
<link href="css\bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
/* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */

/* Carousel base class */
.carousel {
	margin-top: 0;
	margin-bottom: 60px;
}

.carousel .container {
	position: relative;
	z-index: 9;
}

.carousel-control {
	height: 80px;
	margin-top: 0;
	font-size: 120px;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .4);
	background-color: transparent;
	border: 0;
	z-index: 10;
}

.carousel .item {
	height: 500px;
}

.carousel img {
	position: absolute;
	top: 0;
	left: 0;
	min-width: 100%;
	height: 500px;
}

.carousel-caption {
	background-color: transparent;
	position: static;
	max-width: 550px;
	padding: 0 20px;
	margin-top: 200px;
}

.carousel-caption h1,.carousel-caption .lead {
	margin: 0;
	line-height: 1.25;
	color: #fff;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .4);
}

.carousel-caption .btn {
	margin-top: 10px;
}
</style>
<link href="css\bootstrap-responsive.css" rel="stylesheet">

<!-- Fav and touch icons -->
<link rel="shortcut icon" href=" ico/favicon.png">
</head>

<body>

	<div id="top" class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="index.jsp">Jamie Oliver's </a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="index.jsp">Trang Chủ</a></li>
						<li><a href="about.jsp">Giới Thiệu</a></li>
						<li><a href="contact.jsp">Liên Hệ</a></li>
						<li><a href="">Đặt Bàn Online</a></li>
						<!--drop down menu-->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Thực đơn <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="foods.jsp">Món Ăn</a></li>
								<li><a href="">Đồ Uống</a></li>
							</ul></li>
					</ul>
					<%
						if (username.length() <= 0) {
					%>
					<a class="navbar-search pull-right"
						style="margin: 10px; font-size: 12pt;" href="login.jsp">Đăng
						Nhập</a>
					<%
						} else {
					%>
					<a class="navbar-search pull-right"
						style="margin: 10px; font-size: 12pt;" href="logout">Thoát</a><span>|</span>
					<a class="navbar-search pull-right"
						style="margin: 10px; font-size: 12pt;" href="">Xin
						Chào <%=username%></a>|
					<%
						}
					%>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<h1>Danh sách các món ăn</h1>
	</div>
	<div class="container">
		<div class="row-fluid" style="margin: 20px;">
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>
			</div>
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>

			</div>
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>

			</div>
		</div>

		<div class="row-fluid" style="margin: 20px;">
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>
			</div>
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>

			</div>
			<div class="span4">
				<a href="#project-link"><img class="img-responsive"
					src="http://placehold.it/700x400"></a>
				<h3>
					<a href="#project-link">Project Name</a>
				</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
					viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				<a href="" class="btn btn-success">Thêm</a>

			</div>
		</div>
		<hr class="featurette-divider">
		<footer>
			<p class="pull-right">
				<a href="#top">Back to top</a>
			</p>
			<p>
				© 2013 Company, Inc. · <a
					href="">Privacy</a> · <a
					href="">Terms</a>
			</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-transition.js"></script>
	<script src="js/bootstrap-alert.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	<script src="js/bootstrap-dropdown.js"></script>
	<script src="js/bootstrap-scrollspy.js"></script>
	<script src="js/bootstrap-tab.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script src="js/bootstrap-popover.js"></script>
	<script src="js/bootstrap-button.js"></script>
	<script src="js/bootstrap-collapse.js"></script>
	<script src="js/bootstrap-carousel.js"></script>
	<script src="js/bootstrap-typeahead.js"></script>

</body>
</html>
