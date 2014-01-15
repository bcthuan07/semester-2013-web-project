<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	String fullname = request.getAttribute("fullname") == null ? ""
			: (String) request.getAttribute("fullname");
	String content = request.getAttribute("content") == null ? ""
			: (String) request.getAttribute("content");
	String email = request.getAttribute("email") == null ? ""
			: (String) request.getAttribute("email");

	String fullname_err = request.getAttribute("fullname_err") == null ? ""
			: (String) request.getAttribute("fullname_err");
	String content_err = request.getAttribute("content_err") == null ? ""
			: (String) request.getAttribute("content_err");
	String email_err = request.getAttribute("email_err") == null ? ""
			: (String) request.getAttribute("email_err");
	String contextPath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Liên Hệ</title>

<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

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
					<li><a href="home.jsp">Trang Chủ</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li class="active"><a href="lienhe.jsp">Liên Hệ</a></li>
					<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
					<!--<li class="dropdown-header">Nav header</li>-->
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
				<div class="row">
					<h2>Địa chỉ:</h2>
				</div>
				<hr>
				<div class="row">
					<iframe width="650" height="350" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=vi&amp;geocode=&amp;q=&amp;aq=&amp;sll=10.872103,106.792817&amp;sspn=0.104351,0.169086&amp;ie=UTF8&amp;t=m&amp;ll=10.541821,106.464386&amp;spn=0.472538,0.686646&amp;z=10&amp;output=embed"></iframe>
					<br />
					<small><a
						href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=vi&amp;geocode=&amp;q=&amp;aq=&amp;sll=10.872103,106.792817&amp;sspn=0.104351,0.169086&amp;ie=UTF8&amp;t=m&amp;ll=10.541821,106.464386&amp;spn=0.472538,0.686646&amp;z=10"
						style="color: #0000FF; text-align: left">Xem Bản đồ cỡ lớn hơn</a></small>
				</div>
			</div>

			<div class="col-md-5">

				<h2>Liên Hệ</h2>
				<form action="Feedback" method="post" class="form-horizontal">
				<br><br><br>
					<div class=" form-group">
						<label for="fullname" class="col-sm-3 control-label">Họ và
							Tên:</label>
						<div class="col-sm-7">
							<input type="text" name="fullname" id="fullname"
								class="form-control" value="<%=fullname%>">
							<p class="help-block"><%=fullname_err%></p>
						</div>
					</div>
					<div class=" form-group">
						<label for="email" class="col-sm-3 control-label">Email:</label>
						<div class="col-sm-7">
							<input type="email" name="email" id="email" value="<%=email%>"
								class="form-control">
							<p class="help-block"><%=email_err%></p>
						</div>
					</div>
					<div class=" form-group">
						<label for="content" class="col-sm-3 control-label">Nội
							dung:</label>
						<div class="col-sm-7">
							<textarea rows="6" class="form-control" name="content"></textarea>
							<p class="help-block"><%=content_err%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 col-md-offset-5">
							<input type="submit" value="Gửi"
								class="form-control btn btn-success">
						</div>
					</div>
				</form>
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