<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	String username = "";
	String phonenumber = "";
	String fullname = "";
	String email = "";
	String paymentmethod = "";
	String gioitinh = "";
	String id = "";
	if (user != null) {
		username = user.getUsername();
		fullname = user.getFullname();
		email = user.getEmail();
		paymentmethod = user.getPaymentMethod().getDescription();
		gioitinh = user.getGender() ? "Nam" : "Nữ";
		id = user.getUserId() + "";
	}

	String contextPath = request.getContextPath() + "/";
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
					<li><a href="home.jsp">Trang Chủ</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li><a href="lienhe.jsp">Liên Hệ</a></li>
					<jsp:include page="header.jsp"></jsp:include>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">

		<p><%=username%></p>
		<p><%=fullname%></p>
		<p><%=phonenumber%></p>
		<p><%=email%></p>
		<p><%=gioitinh%></p>
		<a href="<%=contextPath %>detail/prolifeedit.jsp">Chinh sua account</a>
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
	<script src="<%=contextPath %>js/jquery-1.10.2.js"></script>
	<script src="<%=contextPath %>js/bootstrap.js"></script>
	<script src="<%=contextPath %>js/holder.js"></script>


</body>

</html>