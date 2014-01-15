<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	List<Product> listProduct;
	Double amount = 0.0;
	if (session.getAttribute("listproduct") != null) {
		listProduct = (List<Product>) session
				.getAttribute("listproduct");
		for (Product p : listProduct) {
			amount += p.getPrice();
		}
	} else {
		listProduct = new ArrayList<Product>();
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

<title>Giỏ Hàng</title>
<link rel="shortcut icon" href="<%=contextPath %>image/icon/icon.png" />

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
				<a class="navbar-brand" href="<%=contextPath %>home.jsp">Nhà Hàng Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=contextPath%>home.jsp">Trang
							Chủ</a></li>
					<li><a href="<%=contextPath%>Menu">Thực Đơn</a></li>
					<li><a href="<%=contextPath%>lienhe.jsp">Liên Hệ</a></li>
					<li class="active"><a href="<%=contextPath%>order/cartview.jsp">Giỏ Hàng</a></li>

					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<h1>Thông tin giỏ hàng</h1>
		<hr>
		<div class="row">
			<div class="col-sm-2">
				<h5>Tổng thành tiền</h5>
			</div>
			<div class="col-sm-4">
				<h4><%=amount.toString()%></h4>
			</div>
			<div class="col-sm-4">
				<a class="btn btn-success" href="validatecart.jsp"
					title="Thanh Toán">Thanh Toán</a>
			</div>
		</div>
		<hr>
		<h4>Các sản phẩm trong giỏ hàng:</h4>
		<hr>
		<div class="well">
			<%
				int count = 0;
				for (Product product : listProduct) {
					count++;
					if (count % 3 == 1) {
			%>
			<div class="row">
				<%
					}
				%>
				<div class="col-sm-2">
					<a href="ProductInfo?product=<%=product.getProductId()%>"><img
						class="img-responsive"
						src="<%=contextPath + product.getImagePath()%>"></a>
				</div>

				<div class="col-sm-2">
					<h5>
						<a href="<%=contextPath %>ProductInfo?product=<%=product.getProductId()%>"><%=product.getProductName()%></a>
					</h5>
					<a
						href="<%=contextPath%>RemoveProduct?product=<%=product.getProductId()%>"
						class="btn btn-danger btn-xs" title="Bỏ sản phẩm">X</a>
				</div>
				<%
					if (count % 3 == 0) {
				%>
			</div>
			<br>

			<%
				}
				}
			%>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=contextPath%>js/jquery-1.10.2.js"></script>
	<script src="<%=contextPath%>js/bootstrap.js"></script>
	<script src="<%=contextPath%>js/holder.js"></script>
</body>

</html>