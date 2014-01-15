<%@page import="dao.AdDAO"%>
<%@page import="model.Ads"%>
<%@page import="service.DAOService"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	DAOService<Ads, Integer> service = new DAOService<Ads, Integer>(
			new AdDAO());
	List<Ads> list = service.listObject();
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
<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

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
					Hàng Jamie Oliver's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<%=contextPath%>home.jsp">Home</a></li>
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
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="<%=contextPath%>image/home/img1.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Đăng kí thành viên</h1>
						<p>Đăng kí làm thành viên ngay, để nhận hàng loạt ưu đãi hấp
							dẫn!</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<%=contextPath%>register.jsp" role="button">Đăng kí</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="<%=contextPath%>image/home/img2.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Thực Đơn</h1>
						<p>Thực đơn phong phú, hấp dẫn</p>
						<p>
							<a class="btn btn-lg btn-primary" href="<%=contextPath%>Menu"
								role="button">Xem Thực Đơn</a>
						</p>
					</div>
				</div>
			</div>

			<div class="item">
				<img src="<%=contextPath%>image/home/img3.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Liên Hệ</h1>
						<p>Thực đơn phong phú, hấp dẫn</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<%=contextPath%>lienhe.jsp" role="button">Liên Hệ</a>
						</p>
					</div>
				</div>
			</div>

		</div>
		<a class="left carousel-control"
			href="http://getbootstrap.com/examples/carousel/#myCarousel"
			data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
		<a class="right carousel-control"
			href="http://getbootstrap.com/examples/carousel/#myCarousel"
			data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>

	</div>
	<!-- /.carousel -->
	<div class="container marketing">

		<div class="row">

			<%
				for (Ads a : list) {
			%>
			<div class="col-lg-4">
				<img class="center-block thumbnail"
					src="<%=contextPath%><%=a.getImagePath()%>"
					alt="<%=a.getContent()%>">
				<h2><%=a.getName()%></h2>
				<p><%=a.getContent()%></p>
				<p>
					<a class="btn btn-default" href="<%=a.getLink()%>" target="_blank"
						role="button">View details &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->

			<%
				}
			%>
		</div>
	</div>
	<div class="container">

		<hr>

		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2014</p>
					<p>Design by Nhóm 5 - Đại học Nông Lâm</p>
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