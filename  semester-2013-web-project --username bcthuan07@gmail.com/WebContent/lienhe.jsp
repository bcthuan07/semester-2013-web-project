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
				<h2>Phản hồi:</h2>
				<form action="Feedback" method="post">
					<div class="row">
						<div class="col-md-5 form-group">
							<label for="fullname">Họ và Tên:</label> <input type="text"
								name="fullname" id="fullname" class="form-control"
								value="<%=fullname%>">
							<p class="help-block"><%=fullname_err%></p>
						</div>
					</div>
					<div class="row">
						<div class=" col-md-5 form-group">
							<label for="email">Email:</label> <input type="email"
								name="email" id="email" value="<%=email%>" class="form-control">
							<p class="help-block"><%=email_err%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="content">Nội dung:</label>
							<textarea rows="6" class="form-control" name="content"></textarea>
							<p class="help-block"><%=content_err%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 form-group">
							<input type="submit" value="Gửi" class="form-control">
						</div>
					</div>
				</form>
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