<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Chủ</title>

	<script src="js/pace.min.js"></script>
	<link href="css/loading.css" rel="stylesheet">


<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
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
				<a class="navbar-brand" href="home.jsp">Nhà Hàng Jamie Oliver's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li class="active"><a href="lienhe.jsp">Liên Hệ</a></li>
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<br> <br> <br>
		<div class="row">
			<div class="col-md-7">
				<iframe width="640" height="480" frameborder="0" scrolling="no"
					marginheight="0" marginwidth="0"
					src="https://maps.google.com/?ie=UTF8&amp;t=m&amp;source=embed&amp;ll=10.869216,106.802559&amp;spn=0.04046,0.054932&amp;z=14&amp;output=embed"></iframe>
				<br />
				<small><a
					href="https://maps.google.com/?ie=UTF8&amp;t=m&amp;source=embed&amp;ll=10.869216,106.802559&amp;spn=0.04046,0.054932&amp;z=14"
					style="color: #0000FF; text-align: left">Xem Bản đồ cỡ lớn hơn</a></small>
				<div class="clearfix visible-xs"></div>
			</div>
			<div class="col-md-3">
				<h1>Địa chỉ:</h1>
				<p>Số 327 Biên Hòa</p>
				<p>Số ĐT: 1234567</p>
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
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/holder.js"></script>


</body>

</html>